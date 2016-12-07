package bussinesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import bussinesslogic.controllerfactory.ControllerFactory;
import dataservice.orderdataservice.OrderDataService;
import factory.datahelper.DataHelperFactory;
import po.order.OrderPO;
import po.room.RoomRecordPO;
import util.Time;
import util.credit.CreditChangeAction;
import util.order.OrderState;
import util.resultmessage.ResultMessage_Order;
import util.user.MemberType;
import vo.credit.CreditVO;
import vo.order.OrderMakeVO;
import vo.order.OrderVO;
import vo.promotion.DistrictPromotionVO;
import vo.promotion.EnterprisePromotionVO;
import vo.promotion.PromotionVO;
import vo.room.RoomRecordVO;
import vo.user.ClientVO;

public class Order {
	private static final int PROMOTION_ROOM_NUMBER = 3;
	
	private OrderDataService order_data_service;
	
	private ClientInfo client;
	private CreditUpdate credit;
	private PromotionGet promotion;
	private HotelInfo hotel;
	private RoomUpdate room;
	private OrderPO orderPO;
	
	/**
	 * @param userInfo
	 * @param credit
	 * @param promotion
	 * @param room
	 */
	public Order() {
		try {
			this.order_data_service = DataHelperFactory.getDataFactoryHelperInstance().getOrderDatabase();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
				checkClient();
				ClientVO clientVO = client.getClientInfo(po.getClientID());
				
				int changeValue = -(int)(po.getValue() / 2);
				int newCredit = clientVO.credit + changeValue;
				CreditVO creditVO = new CreditVO(po.getClientID(), currentTime, changeValue, newCredit,
						CreditChangeAction.RepealOrder, orderID);
				
				checkCredit();
				credit.creditUpdate(creditVO);
			}
			
			// 删除房间预订记录
			checkRoom();
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
			checkClient();
			ClientVO clientVO = client.getClientInfo(orderPO.getClientID());
			
			int changeValue = (int)orderPO.getValue();
			int newCredit = clientVO.credit + changeValue;
			CreditVO creditVO = new CreditVO(orderPO.getClientID(), Time.getCurrentTime(), changeValue, newCredit,
					CreditChangeAction.ExecuteOrder, orderID);
			
			checkCredit();
			credit.creditUpdate(creditVO);
			
			// 更新房间记录及房间状态
			checkRoom();
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
			checkRoom();
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
			checkRoom();
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
			checkClient();
			ClientVO clientVO = client.getClientInfo(orderPO.getClientID());
			
			int changeValue = (int)orderPO.getValue();
			int newCredit = clientVO.credit + changeValue;
			CreditVO creditVO = new CreditVO(orderPO.getClientID(), Time.getCurrentTime(), changeValue, newCredit,
					CreditChangeAction.PutUpOrder, orderID);
			
			checkCredit();
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
	 * 检查可用促销策略
	 * @param iterator
	 * @return
	 * @throws RemoteException 
	 */
	private ArrayList<PromotionVO> getAvailablePromotion(Iterator<PromotionVO> iterator, OrderMakeVO order, ClientVO client) throws RemoteException {
		ArrayList<PromotionVO> avaiPromotionList = new ArrayList<>();
		while(iterator.hasNext()) {
			PromotionVO vo = iterator.next();
			switch (vo.type) {
			// 生日促销策略
			case Birthday:
				if (client.memberType.equals(MemberType.Ordinary)) {
					// 生日在住宿期间
					String birthday = client.memberMessage.substring(5);
					String checkIn = order.checkInDate.substring(5);
					String checkOut = order.estimateCheckOutDate.substring(5);
					if (birthday.compareTo(checkIn) >= 0 && birthday.compareTo(checkOut) <= 0)
						avaiPromotionList.add(vo);
				}
				break;
			// 企业促销策略
			case Enterprise:
				EnterprisePromotionVO enterpriseVO = (EnterprisePromotionVO) vo;
				// 所在企业在促销策略涉及企业中
				if (client.memberType.equals(MemberType.Enterprise)) {
					for (String enterpriseName : enterpriseVO.enterpriseList) {
						if (enterpriseName.equals(client.memberMessage)) {
							avaiPromotionList.add(enterpriseVO);
							break;
						}
					}
				}
				break;
			// 商圈促销策略
			case BusinessDistrict:
				DistrictPromotionVO districtVO = (DistrictPromotionVO) vo;
				checkHotel();
				String hotelDistrict = hotel.getBusinessDistrict(order.hotelID);
				for (String distrcit : districtVO.districtList) {
					if (hotelDistrict.equals(distrcit)) {
						avaiPromotionList.add(districtVO);
						break;
					}
				}
				break;
			// 房间促销策略
			case Room:
				if (order.roomNumberList.size() >= PROMOTION_ROOM_NUMBER)
					avaiPromotionList.add(vo);
				break;
			// 节假日促销策略
			case Holiday:
				avaiPromotionList.add(vo);
			}
		}
		return avaiPromotionList;
	}

	/**
	 * 生成订单
	 * @param vo
	 * @return OrderVO
	 * @throws RemoteException 
	 */
	public OrderVO makeOrder(OrderMakeVO vo) throws RemoteException {
		// 错误：客户信用值为负
		checkClient();
		ClientVO clientVO = client.getClientInfo(vo.clientID);
		if(clientVO.credit < 0)
			return null;
		// TODO 更多错误信息
		
		OrderVO orderVO = new OrderVO(vo);
		
		// 可用促销策略获取
		int vipLevel = clientVO.level;
		checkPromotion();
		Iterator<PromotionVO> underwayPromotion = promotion.getUnderwayPromotion(vo.hotelID);
		ArrayList<PromotionVO> availablePromotion = getAvailablePromotion(underwayPromotion, vo, clientVO);
		// 所有符合条件促销策略按照该客户会员等级享受折扣排序
		Comparator<PromotionVO> comparator = new Comparator<PromotionVO>() {
			@Override
			public int compare(PromotionVO o1, PromotionVO o2) {
				double temp = o1.discount.get(vipLevel) - o2.discount.get(vipLevel);
				return (int)temp;
			}
		};
		Collections.sort(availablePromotion, comparator);
		// 促销策略id获取
		ArrayList<String> promotionIDList = new ArrayList<>();
		for (PromotionVO promotionVO : availablePromotion) {
			promotionIDList.add(promotionVO.promotionID);
		}
		orderVO.promotionIDList = promotionIDList;
		// 订单价格计算
		double value = 0;
		int days = Time.deltaDate(vo.checkInDate, vo.estimateCheckOutDate);
		checkRoom();
		for (String roomNumber : vo.roomNumberList) {
			value += room.getRoomPrice(vo.hotelID, roomNumber) * days;
		}
		// 促销策略折扣
		double promotionDiscount = 10;
		if(availablePromotion.size() > 0)
			promotionDiscount = availablePromotion.get(0).discount.get(vipLevel);
		// 会员等级折扣
		double memberDiscount = promotion.getDiscount(vipLevel);
		// 折扣后价格计算
		orderVO.value = value * (promotionDiscount * 0.1) * (memberDiscount * 0.1);
		
		// 数据库记录订单信息，获取订单号
		OrderPO po = new OrderPO(orderVO);
		String orderID = order_data_service.addOrder(po);
		orderVO.orderID = orderID;
		
		return orderVO;
	}
	
	private void checkClient() {
		if(client == null) {
			try {
				client = ControllerFactory.getClientInfoInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private void checkCredit() {
		if(credit == null) {
			try {
				credit = ControllerFactory.getCreditUpdateInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void checkPromotion() {
		if(promotion == null) {
			try {
				promotion = ControllerFactory.getPromotionGetInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void checkRoom() {
		if(room == null) {
			try {
				room = ControllerFactory.getRoomUpdateInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void checkHotel() {
		if(hotel == null) {
			try {
				hotel = ControllerFactory.getHotelInfoInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
