package bussinesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.orderblservice.OrderBLService;
import dataservice.orderdataservice.OrderDataService;
import factory.test_helper.DataFactoryHelper;
import po.order.OrderPO;
import util.resultmessage.ResultMessage_Order;
import util.resultmessage.ResultMessage_Room;
import vo.order.OrderMakeVO;
import vo.order.OrderVO;

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
	 * 撤销订单的同时删除房间预订记录
	 * @param orderID
	 * @return ResultMessage
	 */
	public ResultMessage_Order cancelOrder(String orderID) {
		ResultMessage_Room res_room = room.deleteRecord(orderID);
		// TODO ResultMessage_Room 统一完善
//		if(res_room.equals())
		
		ResultMessage_Order res_order;
		try {
			res_order = order_data_service.cancelOrder(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage_Order.Net_Error;
		}
		return res_order;
		
	}

	public ResultMessage_Order excuteOrder(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage_Order putUpOrder(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderVO queryOrderById(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderVO> queryOrderByHotel(String hotelID, String clientID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderVO> queryRoomOrder(String hotelID, String roomNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderVO> queryUserOrder(String clientID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderVO> queryHotelOrder(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderVO makeOrder(OrderMakeVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
