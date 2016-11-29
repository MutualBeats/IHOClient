package bussinesslogic.orderbl;

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
	public ResultMessage_Order cancelOrder(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage_Order excuteOrder(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage_Order putUpOrder(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVO queryOrderById(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> queryOrderByHotel(String hotelId, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> queryRoomOrder(String hotelId, String roomId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> queryUserOrder(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> queryHotelOrder(String hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVO makeOrder(OrderMakeVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
