package bussinesslogic.orderbl;

import java.util.ArrayList;

import bussinesslogicservice.orderblservice.OrderBLService;
import util.ResultMessage;
import vo.OrderVO;

public class OrderController implements OrderBLService{

	@Override
	public ResultMessage makeOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage cancelOrder(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage excuteOrder(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage putUpOrder(String orderId) {
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

	
}
