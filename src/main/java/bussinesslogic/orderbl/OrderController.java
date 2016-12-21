package bussinesslogic.orderbl;

import java.util.ArrayList;

import bussinesslogic.hotelbl.OrderUpdate;
import bussinesslogicservice.orderblservice.OrderBLService;
import util.exception.NetException;
import util.exception.TimeConflictException;
import util.order.OrderState;
import util.resultmessage.ResultMessage_Order;
import vo.order.OrderMakeVO;
import vo.order.OrderVO;

public class OrderController implements OrderBLService, OrderUpdate {
	
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
	public ResultMessage_Order appeal(String orderID, boolean all) {
		return order.appealOrder(orderID, all);
	}

	@Override
	public OrderVO queryOrderById(String orderID) throws NetException {
		return order.queryOrderById(orderID);
	}

	@Override
	public ArrayList<OrderVO> queryOrderByHotel(String hotelID, String clientID) throws NetException {
		return order.queryOrderByHotel(hotelID, clientID);
	}

	@Override
	public ArrayList<OrderVO> queryRoomOrder(String hotelID, String roomNumber) throws NetException {
		return order.queryRoomOrder(hotelID, roomNumber);
	}

	@Override
	public ArrayList<OrderVO> queryUserOrder(String clientID, OrderState state) throws NetException {
		return order.queryUserOrder(clientID, state);
	}

	@Override
	public ArrayList<OrderVO> queryHotelOrder(String hotelID, OrderState state) throws NetException {
		return order.queryHotelOrder(hotelID, state);
	}

	@Override
	public ArrayList<OrderVO> queryUnexecutedOrder(String date) throws NetException {
		return order.queryUnexecutedOrder(date);
	}

	@Override
	public ResultMessage_Order orderEvaluate(String orderID) {
		return order.orderEvaluate(orderID);
	}

	@Override
	public ArrayList<OrderVO> queryAbnormalOrder() throws NetException {
		return order.queryAbnormalOrder();
	}

	@Override
	public OrderVO getOrderVOBeforeMake(OrderMakeVO vo) throws NetException, TimeConflictException {
		return order.getOrderVOBeforeMake(vo);
	}

	/* (non-Javadoc)
	 * @see bussinesslogicservice.orderblservice.OrderBLService#makeOrder(vo.order.OrderVO)
	 */
	@Override
	public String makeOrder(OrderVO vo) throws NetException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
