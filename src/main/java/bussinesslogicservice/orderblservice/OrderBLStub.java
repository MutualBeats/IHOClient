package bussinesslogicservice.orderblservice;

import java.util.ArrayList;

import util.exception.NetException;
import util.exception.TimeConflictException;
import util.order.OrderState;
import util.resultmessage.ResultMessage_Order;
import util.room.RoomType;
import util.user.MemberType;
import vo.order.OrderMakeVO;
import vo.order.OrderVO;

public class OrderBLStub implements OrderBLService {

	String orderId = "0000000000000001";
	String userId = "test_client";
	String userName = "Huangxiao";
	String userPhone = "12345678900";
	MemberType memberType = MemberType.Not;
	OrderState orderState = OrderState.Unexecuted;
	String hotelId = "00000001";
	String hotelName = "Test_Hotel";
	String roomId = "346";
	double value = 20000.0;
	int creditChange = 2000000;
	String makeTime = "2016/11/16 23:00:00";
	String inTime = "2016/11/21";
	String outTime = "2016/12/01";
	String oInTime = "2016/11/23";
	String oOutTime = "2016/11/30";
	String finishTime = "2016/11/30 23:00:00";;
	RoomType roomType = RoomType.Single;
	String latestETime = "2016/11/16 23:59:59";;
	boolean children = false;
	int numOfPeople = 1;
	int numOfRoom = 1;

	@Override
	public String makeOrder(OrderVO vo) {
		if (vo.clientID.equals(orderId)) {
			return orderId;
		}
		return "";
	}

	@Override
	public ResultMessage_Order cancelOrder(String orderId) {
		if (orderId.equals(orderId)) {
			return ResultMessage_Order.Cancel_Successful;
		}
		return ResultMessage_Order.Cancel_Failed;
	}

	@Override
	public ResultMessage_Order executeOrder(String orderId) {
		if (orderId.equals(orderId)) {
			return ResultMessage_Order.Execute_Successful;
		}
		return ResultMessage_Order.Execute_Failed;
	}

	@Override
	public ResultMessage_Order putUpOrder(String orderId) {
		if (orderId.equals(orderId)) {
			return ResultMessage_Order.Put_Up_Failed;
		}
		return ResultMessage_Order.Put_Up_Successful;
	}

	@Override
	public OrderVO queryOrderById(String orderId) {
		if (orderId.equals(this.orderId)) {
			ArrayList<String> number = new ArrayList<>();
			number.add(roomId);
			return new OrderVO(orderId, orderState, userId, hotelId, number, new ArrayList<>(), value, orderId, inTime,
					orderId, orderId, inTime, outTime, oInTime, numOfPeople, children, false);
		} else {
			return null;
		}
	}

	@Override
	public ArrayList<OrderVO> queryOrderByHotel(String hotelId, String userId) {
		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
		if (hotelId.equals(this.hotelId)) {

			ArrayList<String> number = new ArrayList<>();
			number.add(roomId);
			list.add(new OrderVO(orderId, orderState, userId, hotelId, number, new ArrayList<>(), value, orderId,
					inTime, orderId, orderId, inTime, outTime, oInTime, numOfPeople, children, false));
		}
		return list;
	}

	// @Override
	// public ArrayList<OrderVO> queryRoomOrder(String hotelId, String roomId) {
	// ArrayList<OrderVO> list = new ArrayList<OrderVO>();
	// ArrayList<String> number = new ArrayList<>();
	// number.add(roomId);
	// list.add(new OrderVO(orderId, orderState, userId, hotelId, number, new
	// ArrayList<>(), value, orderId, inTime,
	// orderId, orderId, inTime, outTime, oInTime, numOfPeople, children,
	// false));
	// return list;
	//
	// }

	@Override
	public ArrayList<OrderVO> queryUserOrder(String userId, OrderState state) {
		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
		ArrayList<String> number = new ArrayList<>();
		number.add(roomId);
		list.add(new OrderVO(orderId, orderState, userId, hotelId, number, new ArrayList<>(), value, orderId, inTime,
				orderId, orderId, inTime, outTime, oInTime, numOfPeople, children, false));
		return list;
	}

	@Override
	public ArrayList<OrderVO> queryHotelOrder(String hotelId, OrderState state) {
		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
		if (state == orderState) {
			ArrayList<String> number = new ArrayList<>();
			number.add(roomId);
			list.add(new OrderVO(orderId, orderState, userId, hotelId, number, new ArrayList<>(), value, orderId,
					inTime, orderId, orderId, inTime, outTime, oInTime, numOfPeople, children, false));
		}
		return list;
	}

	@Override
	public OrderVO getOrderVOBeforeMake(OrderMakeVO vo) throws NetException, TimeConflictException {
		ArrayList<String> number = new ArrayList<>();
		number.add(roomId);
		return new OrderVO(orderId, orderState, userId, hotelId, number, new ArrayList<>(), value, orderId, inTime,
				orderId, orderId, inTime, outTime, oInTime, numOfPeople, children, false);
	}

	@Override
	public ResultMessage_Order appeal(String orderID, boolean all) {
		if(orderID.equals(orderId)) {
			return ResultMessage_Order.Appeal_Successful;
		} else {
			return ResultMessage_Order.Appeal_Failed;
		}
	}

	@Override
	public ResultMessage_Order finishOrder(String orderID) {
		if(orderID.equals(orderId) ) {
			return ResultMessage_Order.Finish_Successful;
		} else {
			return ResultMessage_Order.Finish_Failed;
		}
	}

	@Override
	public ArrayList<OrderVO> queryUnexecutedOrder(String date) throws NetException {
		return new ArrayList<>();
	}

	@Override
	public ArrayList<OrderVO> queryAbnormalOrder() throws NetException {
		return new ArrayList<>();
	}

}
