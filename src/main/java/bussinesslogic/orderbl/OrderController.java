package bussinesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogicservice.orderblservice.OrderBLService;
import util.resultmessage.ResultMessage_Order;
import vo.order.OrderMakeVO;
import vo.order.OrderVO;

public class OrderController implements OrderBLService{
	
	private Order order = new Order(ControllerFactory.getClientInfoInstance(), 
			ControllerFactory.getCreditUpdateInstance(), 
			ControllerFactory.getPromotionGetInstance(), 
			ControllerFactory.getRoomUpdateInstance());

	@Override
	public ResultMessage_Order cancelOrder(String orderID) {
		return order.cancelOrder(orderID);
	}

	@Override
	public ResultMessage_Order excuteOrder(String orderID) {
		return order.excuteOrder(orderID);
	}

	@Override
	public ResultMessage_Order putUpOrder(String orderID) {
		return order.putUpOrder(orderID);
	}

	@Override
	public OrderVO queryOrderById(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> queryOrderByHotel(String hotelID, String clientID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> queryRoomOrder(String hotelID, String roomNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> queryUserOrder(String clientID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> queryHotelOrder(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVO makeOrder(OrderMakeVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
