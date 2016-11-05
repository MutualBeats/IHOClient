package vo;

import util.MemberType;
import util.OrderState;
import util.RoomType;

public class OrderVO {
	/**
	 * @param orderId
	 * @param userId
	 * @param userName
	 * @param userPhone
	 * @param memberType
	 * @param orderState
	 * @param hotelId
	 * @param hotelName
	 * @param roomId
	 * @param value
	 * @param creditChange
	 * @param makeTime
	 * @param inTime
	 * @param outTime
	 * @param oInTime
	 * @param oOutTime
	 * @param finishTime
	 */
	public OrderVO(String orderId, String userId, String userName, String userPhone, MemberType memberType,
			OrderState orderState, String hotelId, String hotelName, String roomId,RoomType roomType, int numOfRoom, double value, int creditChange,
			String makeTime, String inTime, String outTime, String oInTime, String oOutTime, String finishTime, String latestETime, int numOfPeople, boolean children) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
		this.memberType = memberType;
		this.orderState = orderState;
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.roomId = roomId;
		this.value = value;
		this.creditChange = creditChange;
		this.makeTime = makeTime;
		this.inTime = inTime;
		this.outTime = outTime;
		this.oInTime = oInTime;
		this.oOutTime = oOutTime;
		this.finishTime = finishTime;
		this.latestETime = latestETime;
		this.children = children;
		this.numOfPeople = numOfPeople;
		this.numOfRoom = numOfRoom;
	}
	
	/*
	 * 订单id
	 */
	public String orderId;
	/*
	 * 用户id 
	 */
	public String userId;
	/*
	 * 用户名称
	 */
	public String userName;
	/*
	 * 用户联系方式
	 */
	public String userPhone;
	/*
	 * 会员类型
	 */
	public MemberType memberType;
	/*
	 * 订单状态
	 */
	public OrderState orderState;
	/*
	 * 酒店id
	 */
	public String hotelId;
	/*
	 * 酒店名称
	 */
	public String hotelName;
	/*
	 * 房间Id
	 */
	public String roomId;
	/*
	 * 房间类型
	 */
	public RoomType roomType;
	/*
	 * 订单价格
	 */
	public double value;
	/*
	 * 信用值变化
	 */
	public int creditChange;
	/*
	 * 订单生成时间
	 */
	public String makeTime;
	
	/*
	 * 订单执行时间
	 */
	public String inTime;
	/*
	 * 订单执行完毕时间
	 */
	public String outTime;
	/*
	 * 预订入住时间
	 */
	public String oInTime;
	/*
	 * 预订离开时间
	 */
	public String oOutTime;
	/*
	 * 订单完成时间
	 */
	public String finishTime;
	/*
	 * 房间数量
	 */
	public int numOfRoom;
	/*
	 * 最晚订单执行时间
	 */
	public String latestETime;
	/*
	 * 预计入住人数
	 */
	public int numOfPeople;
	/*
	 * 有无儿童
	 */
	public boolean children;
}
