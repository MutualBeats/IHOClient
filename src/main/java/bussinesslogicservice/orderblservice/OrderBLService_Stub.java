//package bussinesslogicservice.orderblservice;
//
//import java.util.ArrayList;
//
//import util.MemberType;
//import util.OrderState;
//import util.ResultMessage_For_Stub;
//import util.RoomType;
//import vo.order.OrderMakeVO;
//import vo.order.OrderVO;
//
//public class OrderBLService_Stub implements OrderBLService{
//	
//	String orderId;
//	String userId;
//	String userName;
//	String userPhone;
//	MemberType memberType;
//	OrderState orderState;
//	String hotelId;
//	String hotelName;
//	String roomId;
//	double value;
//	int creditChange;
//	String makeTime;
//	String inTime;
//	String outTime;
//	String oInTime;
//	String oOutTime;
//	String finishTime;
//	RoomType roomType;
//	String latestETime;
//	boolean children;
//	int numOfPeople;
//	int numOfRoom;
//	
//
//	/**
//	 * @param orderId
//	 * @param userId
//	 * @param userName
//	 * @param userPhone
//	 * @param memberType
//	 * @param orderState
//	 * @param hotelId
//	 * @param hotelName
//	 * @param roomId
//	 * @param value
//	 * @param creditChange
//	 * @param makeTime
//	 * @param inTime
//	 * @param outTime
//	 * @param oInTime
//	 * @param oOutTime
//	 * @param finishTime
//	 * @param roomType
//	 * @param latestETime
//	 * @param children
//	 * @param numOfPeople
//	 * @param numOfRoom
//	 */
//	public OrderBLService_Stub(String orderId, String userId, String userName, String userPhone, MemberType memberType,
//			OrderState orderState, String hotelId, String hotelName, String roomId, double value, int creditChange,
//			String makeTime, String inTime, String outTime, String oInTime, String oOutTime, String finishTime,
//			RoomType roomType, String latestETime, boolean children, int numOfPeople, int numOfRoom) {
//		super();
//		this.orderId = orderId;
//		this.userId = userId;
//		this.userName = userName;
//		this.userPhone = userPhone;
//		this.memberType = memberType;
//		this.orderState = orderState;
//		this.hotelId = hotelId;
//		this.hotelName = hotelName;
//		this.roomId = roomId;
//		this.value = value;
//		this.creditChange = creditChange;
//		this.makeTime = makeTime;
//		this.inTime = inTime;
//		this.outTime = outTime;
//		this.oInTime = oInTime;
//		this.oOutTime = oOutTime;
//		this.finishTime = finishTime;
//		this.roomType = roomType;
//		this.latestETime = latestETime;
//		this.children = children;
//		this.numOfPeople = numOfPeople;
//		this.numOfRoom = numOfRoom;
//	}
//
//	@Override
//	public OrderVO makeOrder(OrderMakeVO vo) {
//		if(vo.userId.equals(userId)) {
//			return null;
//		}
//		return null;
//	}
//
//	@Override
//	public ResultMessage_For_Stub cancelOrder(String orderId) {
//		if(orderId.equals(orderId)) {
//			return ResultMessage_For_Stub.CancelSucceed;
//		}
//		return ResultMessage_For_Stub.CancelFailed;
//	}
//
//	@Override
//	public ResultMessage_For_Stub excuteOrder(String orderId) {
//		if (orderId.equals(orderId)) {
//			return ResultMessage_For_Stub.ExcuteSucceed;
//		}
//		return ResultMessage_For_Stub.ExcuteFailed;
//	}
//
//	@Override
//	public ResultMessage_For_Stub putUpOrder(String orderId) {
//		if(orderId.equals(orderId)) {
//			return ResultMessage_For_Stub.PutUpSucceed;
//		}
//		return ResultMessage_For_Stub.PutUpFailed;
//	}
//
//	@Override
//	public OrderVO queryOrderById(String orderId) {
//		return new OrderVO(orderId, userId, userName, userPhone, memberType, orderState, hotelId, hotelName, roomId, roomType, numOfRoom, value, creditChange, makeTime, inTime, oOutTime, oInTime, oOutTime, finishTime, latestETime, numOfPeople, children);
//
//	}
//	
//	@Override
//	public ArrayList<OrderVO> queryOrderByHotel(String hotelId, String userId) {
//		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
//		list.add(new OrderVO(orderId, userId, userName, userPhone, memberType, orderState, hotelId, hotelName, roomId, roomType, numOfRoom, value, creditChange, makeTime, inTime, oOutTime, oInTime, oOutTime, finishTime, latestETime, numOfPeople, children));
//		return list;
//	}
//
//	@Override
//	public ArrayList<OrderVO> queryRoomOrder(String hotelId, String roomId) {
//		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
//		list.add(new OrderVO(orderId, userId, userName, userPhone, memberType, orderState, hotelId, hotelName, roomId, roomType, numOfRoom, value, creditChange, makeTime, inTime, oOutTime, oInTime, oOutTime, finishTime, latestETime, numOfPeople, children));
//		return list;
//
//	}
//
//	@Override
//	public ArrayList<OrderVO> queryUserOrder(String userId) {
//		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
//		list.add(new OrderVO(orderId, userId, userName, userPhone, memberType, orderState, hotelId, hotelName, roomId, roomType, numOfRoom, value, creditChange, makeTime, inTime, oOutTime, oInTime, oOutTime, finishTime, latestETime, numOfPeople, children));
//		return list;
//	}
//
//	@Override
//	public ArrayList<OrderVO> queryHotelOrder(String hotelId) {
//		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
//		list.add(new OrderVO(orderId, userId, userName, userPhone, memberType, orderState, hotelId, hotelName, roomId, roomType, numOfRoom, value, creditChange, makeTime, inTime, oOutTime, oInTime, oOutTime, finishTime, latestETime, numOfPeople, children));
//		return list;
//	}
//
//
//}
