package bussinesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.orderdataservice.OrderDataService;
import factory.datahelper.DataHelperFactory;
import po.order.OrderPO;
import po.room.RoomRecordPO;
import util.Time;
import util.credit.CreditChangeAction;
import util.order.OrderState;
import util.resultmessage.ResultMessage_Order;
import vo.credit.CreditVO;
import vo.order.OrderMakeVO;
import vo.order.OrderVO;
import vo.room.RoomRecordVO;
import vo.user.ClientVO;

public class Order {
	
	private OrderDataService order_data_service; 
	
	private ClientInfo userInfo;
	private CreditUpdate credit;
	private PromotionGet promotion;
	private RoomUpdate room;
	private OrderPO orderPO;
	
	/**
	 * @param userInfo
	 * @param credit
	 * @param promotion
	 * @param room
	 */
	public Order(ClientInfo userInfo, CreditUpdate credit, PromotionGet promotion, RoomUpdate room) {
		try {
			this.order_data_service = DataHelperFactory.getDataFactoryHelperInstance().getOrderDatabase();
		}
		
		this.userInfo = userInfo;
		this.credit = credit;
		this.promotion = promotion;
		this.room = room;
		orderPO = null;
	}

	/**
	 * 撤销订单
	 * 同时删除房间预订记录
	 * @param orderID
	 * @return ResultMessage
	 */
	public ResultMessage_Order cancelOrder(String orderID) {
		try {
			OrderPO po = order_data_service.findById(orderID);
			// 错误：订单不存在
			if(po == null)
				return ResultMessage_Order.Order_Not_Exist;
			// 错误：订单不是未执行状态，不可撤销
			if(!po.getOrderState().equals(OrderState.Unexecuted))
				return ResultMessage_Order.Order_State_Error;
			
			// 撤销订单
			ResultMessage_Order result = order_data_service.cancelOrder(orderID);
			if(!result.equals(ResultMessage_Order.Cancel_Successful))
				return result;
			
			// 信用值处理（距离最晚订单执行时间不足6个小时则扣除订单价值一半的信用值）
			String currentTime = Time.getCurrentTime();
			if(Time.deltaTime(currentTime, po.getLatestETime()) < 6 * 3600) {
				ClientVO clientVO = userInfo.getClientInfo(po.getClientID());
				int changeValue = -(int)(po.getValue() / 2);
				int newCredit = clientVO.credit + changeValue;
				CreditVO creditVO = new CreditVO(po.getClientID(), currentTime, changeValue, newCredit,
						CreditChangeAction.RepealOrder, orderID);
				credit.creditUpdate(creditVO);
			}
			
			// 删除房间预订记录
			room.deleteRecord(orderID);
			
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage_Order.Net_Error;
		}
		
		return ResultMessage_Order.Cancel_Successful;
	}

	/**
	 * 执行订单
	 * 同时更新房间
	 * @param orderID
	 * @return ResultMessage
	 */
	public ResultMessage_Order executeOrder(String orderID) {
		try {
			orderPO = order_data_service.findById(orderID);
			// 错误：订单不存在
			if(orderPO == null)
				return ResultMessage_Order.Order_Not_Exist;
			// 错误：订单不是未执行状态，不可执行
			if(!orderPO.getOrderState().equals(OrderState.Unexecuted))
				return ResultMessage_Order.Order_State_Error;
			// 错误：未到预订入住时间或已超出预订入住时间
			if(!orderPO.getCheckInDate().equals(Time.getCurrentDate()))
				return ResultMessage_Order.Date_Error;

			// 执行订单
			ResultMessage_Order result = order_data_service.executeOrder(orderID);
			if(!result.equals(ResultMessage_Order.Execute_Successful))
				return result;
						
			// 信用值处理（增加等于订单总值的信用值）
			ClientVO clientVO = userInfo.getClientInfo(orderPO.getClientID());
			int changeValue = (int)orderPO.getValue();
			int newCredit = clientVO.credit + changeValue;
			CreditVO creditVO = new CreditVO(orderPO.getClientID(), Time.getCurrentTime(), changeValue, newCredit,
					CreditChangeAction.ExecuteOrder, orderID);
			credit.creditUpdate(creditVO);
			
			// 更新房间记录及房间状态
			for (String roomNumber : orderPO.getRoomNumberList()) {
				room.onlineCheckIn(orderPO.getHotelID(), roomNumber);
			}
			
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage_Order.Net_Error;
		}
		
		return ResultMessage_Order.Execute_Successful;
	}
	
	/**
	 * 完成订单
	 * @param orderID
	 * @return
	 */
	public ResultMessage_Order finishOrder(String orderID) {
		try {
			orderPO = order_data_service.findById(orderID);
			// 错误：订单不存在
			if (orderPO == null)
				return ResultMessage_Order.Order_Not_Exist;
			// 错误：订单不是执行状态，不可完成
			if (!orderPO.getOrderState().equals(OrderState.Execute))
				return ResultMessage_Order.Order_State_Error;
			
			// 完成订单
			ResultMessage_Order result = order_data_service.finishOrder(orderID);
			if(!result.equals(ResultMessage_Order.Finish_Successful))
				return result;
			
			// 更新房间记录及房间状态
			for (String roomNumber : orderPO.getRoomNumberList()) {
				room.onlineCheckOut(orderPO.getHotelID(), roomNumber);
			}
			
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage_Order.Net_Error;
		}
		
		return ResultMessage_Order.Finish_Successful;
	}

	/**
	 * 订单补登记执行
	 * @param orderID
	 * @return ResultMessage
	 */
	public ResultMessage_Order putUpOrder(String orderID) {
		try {
			orderPO = order_data_service.findById(orderID);
			// 错误：订单不存在
			if(orderPO == null)
				return ResultMessage_Order.Order_Not_Exist;
			// 错误：订单不为异常状态，不可补登记执行
			if(!orderPO.getOrderState().equals(OrderState.Exception))
				return ResultMessage_Order.Order_State_Error;
			// 错误：当前时间在订单预计离开时间之后
			if(orderPO.getEstimateCheckOutDate().compareTo(Time.getCurrentDate()) < 0)
				return ResultMessage_Order.Date_Error;
			// 错误：订单预订房间中有房间在此期间已被人预订
			String checkInDate = Time.getCurrentDate();
			String checkOutDate = orderPO.getEstimateCheckOutDate();
			for (String roomNumber : orderPO.getRoomNumberList()) {
				ArrayList<RoomRecordVO> roomRecordList = room.getOrderRecord(orderPO.getHotelID(), roomNumber);
				for (RoomRecordVO roomRecord : roomRecordList) {
					if(checkInDate.compareTo(roomRecord.estimateCheckOutDate) > 0 
							|| checkOutDate.compareTo(roomRecord.checkInDate) < 0)
						continue;
					return ResultMessage_Order.Room_Already_Ordered;
				}
			}
			
			// 更新房间记录及房间状态
			for (String roomNumber : orderPO.getRoomNumberList()) {
				// 添加新房间记录
				room.addRecord(new RoomRecordPO(orderPO.getHotelID(), roomNumber, orderID, checkInDate, checkOutDate));
				// 入住
				room.onlineCheckIn(orderPO.getHotelID(), roomNumber);
			}
			
			// 补登记执行
			order_data_service.putUpOrder(orderID);

			// 恢复扣除信用
			ClientVO clientVO = userInfo.getClientInfo(orderPO.getClientID());
			int changeValue = (int)orderPO.getValue();
			int newCredit = clientVO.credit + changeValue;
			CreditVO creditVO = new CreditVO(orderPO.getClientID(), Time.getCurrentTime(), changeValue, newCredit,
					CreditChangeAction.PutUpOrder, orderID);
			credit.creditUpdate(creditVO);
			
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage_Order.Net_Error;
		}
		
		return ResultMessage_Order.Put_Up_Successful;
	}

	/**
	 * 获得订单信息
	 * @param orderID
	 * @return
	 * @throws RemoteException
	 */
	public OrderVO queryOrderById(String orderID) throws RemoteException {
		orderPO = order_data_service.findById(orderID);
		return new OrderVO(orderPO);
	}

	/**
	 * 获得客户在某酒店的订单列表
	 * @param hotelID
	 * @param clientID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> queryOrderByHotel(String hotelID, String clientID) throws RemoteException {
		ArrayList<OrderVO> orderVOList = new ArrayList<OrderVO>();
		
		ArrayList<OrderPO> orderPOList = order_data_service.findUOByHotel(hotelID, clientID);
		
		for (OrderPO orderPO : orderPOList) {
			orderVOList.add(new OrderVO(orderPO));
		}
		
		return orderVOList;
	}

	/**
	 * 获得酒店房间的订单列表
	 * @param hotelID
	 * @param roomNumber
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> queryRoomOrder(String hotelID, String roomNumber) throws RemoteException {
		ArrayList<OrderVO> orderVOList = new ArrayList<OrderVO>();
		
		ArrayList<OrderPO> orderPOList = order_data_service.findByRoom(hotelID, roomNumber);
		
		for (OrderPO orderPO : orderPOList) {
			orderVOList.add(new OrderVO(orderPO));
		}
		
		return orderVOList;
	}

	/**
	 * 获得用户所有订单列表
	 * @param clientID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> queryUserOrder(String clientID) throws RemoteException {
		ArrayList<OrderVO> orderVOList = new ArrayList<OrderVO>();
		
		ArrayList<OrderPO> orderPOList = order_data_service.findByUser(clientID);
		
		for (OrderPO orderPO : orderPOList) {
			orderVOList.add(new OrderVO(orderPO));
		}
		
		return orderVOList;
	}
	
	public ArrayList<OrderVO> queryUnexecutedOrder(String date) throws RemoteException {
		ArrayList<OrderVO> orderVOList = new ArrayList<OrderVO>();
		
		ArrayList<OrderPO> orderPOList = order_data_service.findUnexecutedOrder(date);
		
		for (OrderPO orderPO : orderPOList) {
			orderVOList.add(new OrderVO(orderPO));
		}
		
		return orderVOList;
	}

	/**
	 * 获得酒店订单列表
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> queryHotelOrder(String hotelID) throws RemoteException {
		ArrayList<OrderVO> orderVOList = new ArrayList<OrderVO>();
		
		ArrayList<OrderPO> orderPOList = order_data_service.findHotelOrder(hotelID);
		
		for (OrderPO orderPO : orderPOList) {
			orderVOList.add(new OrderVO(orderPO));
		}
		
		return orderVOList;
	}

	/**
	 * 生成订单
	 * @param vo
	 * @return OrderVO
	 * @throws RemoteException 
	 */
	public OrderVO makeOrder(OrderMakeVO vo) throws RemoteException {
		// 错误：客户信用值为负
		ClientVO clientVO = userInfo.getClientInfo(vo.clientID);
		if(clientVO.credit < 0)
			return null;
		// TODO 更多错误信息
		
		OrderVO orderVO = new OrderVO(vo);
		orderVO.orderID = getOrderID();
		// TODO 可用促销策略获取
//		orderVO.promotionIDList = promotion.getPromotion();
		// TODO 订单价格计算
//		orderVO.value = 0.0;
		
		// 数据库记录订单信息
		OrderPO po = new OrderPO(orderVO);
		order_data_service.addOrder(po);
		
		return orderVO;
	}
	
	/**
	 * 订单号生成
	 * @return orderID
	 */
	private String getOrderID() {
		// TODO 生成订单号
		return null;
	}

}
