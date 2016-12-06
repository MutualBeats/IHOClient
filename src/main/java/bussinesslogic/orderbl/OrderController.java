package bussinesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.orderblservice.OrderBLService;
import util.resultmessage.ResultMessage_Order;
import vo.order.OrderMakeVO;
import vo.order.OrderVO;

public class OrderController implements OrderBLService{
	
	private Order order = new Order();

	@Override
	public ResultMessage_Order cancelOrder(String orderID) {
		return order.cancelOrder(orderID);
	}

	@Override
	public ResultMessage_Order executeOrder(String orderID) {
		return order.executeOrder(orderID);
	}
	
	@Override
	public ResultMessage_Order finishOrder(String orderID) {
		return order.finishOrder(orderID);
	}

	@Override
	public ResultMessage_Order putUpOrder(String orderID) {
		return order.putUpOrder(orderID);
	}

	@Override
	public OrderVO queryOrderById(String orderID) throws RemoteException {
		return order.queryOrderById(orderID);
	}

	@Override
	public ArrayList<OrderVO> queryOrderByHotel(String hotelID, String clientID) throws RemoteException {
		return order.queryOrderByHotel(hotelID, clientID);
	}

	@Override
	public ArrayList<OrderVO> queryRoomOrder(String hotelID, String roomNumber) throws RemoteException {
		return order.queryRoomOrder(hotelID, roomNumber);
	}

	@Override
	public ArrayList<OrderVO> queryUserOrder(String clientID) throws RemoteException {
		return order.queryUserOrder(clientID);
	}

	@Override
	public ArrayList<OrderVO> queryHotelOrder(String hotelID) throws RemoteException {
		return order.queryHotelOrder(hotelID);
	}

	@Override
	public OrderVO makeOrder(OrderMakeVO vo) throws RemoteException {
		return order.makeOrder(vo);
	}

	@Override
	public ArrayList<OrderVO> queryUnexecutedOrder(String date) throws RemoteException {
		return order.queryUnexecutedOrder(date);
	}

	
}
