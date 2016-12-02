package bussinesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.orderblservice.OrderBLService;
import dataservice.orderdataservice.OrderDataService;
import factory.test_helper.DataFactoryHelper;
import po.order.OrderPO;
import util.Time;
import util.credit.CreditChangeAction;
import util.order.OrderState;
import util.resultmessage.ResultMessage_Order;
import vo.credit.CreditVO;
import vo.order.OrderMakeVO;
import vo.order.OrderVO;
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
			this.order_data_service = DataFactoryHelper.getDataFactoryInstance().getOrderDatabase();
		} catch (RemoteException e) {
			e.printStackTrace();
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
			ResultMessage_Order result_order = order_data_service.cancelOrder(orderID);
			if(!result_order.equals(ResultMessage_Order.Cancel_Successful))
				return result_order;
			
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
	public ResultMessage_Order excuteOrder(String orderID) {
		try {
			OrderPO po = order_data_service.findById(orderID);
			// 错误：订单不存在
			if(po == null)
				return ResultMessage_Order.Order_Not_Exist;
			// 错误：订单不是未执行状态，不可执行
			if(!po.getOrderState().equals(OrderState.Unexecuted))
				return ResultMessage_Order.Order_State_Error;

			// 执行订单
			ResultMessage_Order result_order = order_data_service.executeOrder(orderID);
			if(!result_order.equals(ResultMessage_Order.Execute_Successful))
				return result_order;
						
			// 信用值处理（增加等于订单总值的信用值）
			ClientVO clientVO = userInfo.getClientInfo(po.getClientID());
			int changeValue = (int)po.getValue();
			int newCredit = clientVO.credit + changeValue;
			CreditVO creditVO = new CreditVO(po.getClientID(), Time.getCurrentTime(), changeValue, newCredit,
					CreditChangeAction.ExecuteOrder, orderID);
			credit.creditUpdate(creditVO);
			
			// 更新房间记录及房间状态
			for (String roomNumber : po.getRoomNumberList()) {
				room.checkIn(po.getHotelID(), roomNumber);
			}
			
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage_Order.Net_Error;
		}
		
		return ResultMessage_Order.Execute_Successful;
	}

	/**
	 * 订单补登记执行
	 * @param orderID
	 * @return ResultMessage
	 */
	public ResultMessage_Order putUpOrder(String orderID) {
		ResultMessage_Order result_order;
		try {
			OrderPO po = order_data_service.findById(orderID);
			// 错误：订单不存在
			if(po == null)
				return ResultMessage_Order.Order_Not_Exist;
			// 错误：订单不为异常状态，不可补登记执行
			if(!po.getOrderState().equals(OrderState.Exception))
				return ResultMessage_Order.Order_State_Error;
			// 错误：当前时间在订单预计离开时间之后
			if(po.getEstimateCheckOutDate().compareTo(Time.getCurrentDate()) < 0)
				return ResultMessage_Order.Date_Error;
			// TODO 条件判断：能否补登记执行
			
			
			// 补登记执行
			result_order = order_data_service.putUpOrder(orderID);
			if(!result_order.equals(ResultMessage_Order.Put_Up_Successful))
				return result_order;
			
			// 恢复扣除信用
			ClientVO clientVO = userInfo.getClientInfo(po.getClientID());				
			int changeValue = (int)(po.getValue() / 2);
			int newCredit = clientVO.credit + changeValue;
			CreditVO creditVO = new CreditVO(po.getClientID(), Time.getCurrentTime(), changeValue, newCredit,
					CreditChangeAction.PutUpOrder, orderID);
			credit.creditUpdate(creditVO);
			
			// 更新房间记录及房间状态
			for (String roomNumber : po.getRoomNumberList()) {
				room.checkIn(po.getHotelID(), roomNumber);
			}
			
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
		OrderPO po = order_data_service.findById(orderID);
		return new OrderVO(po);
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
	 * @return
	 */
	private String getOrderID() {
		// TODO 生成订单号
		return null;
	}

}
