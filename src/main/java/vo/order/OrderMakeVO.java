package vo.order;

import util.RoomType;

/**
 * VO sent when make order
 */
public class OrderMakeVO {
	
	/**
	 * @param userId
	 * @param hotelId
	 * @param hotelName
	 * @param roomId
	 * @param roomType
	 * @param value
	 * @param makeTime
	 * @param oInTime
	 * @param oOutTime
	 * @param numOfRoom
	 * @param numOfPeople
	 * @param children
	 */
	public OrderMakeVO(String userId, String hotelId, String hotelName, String roomId, RoomType roomType, double value,
			String makeTime, String oInTime, String oOutTime, int numOfRoom, int numOfPeople, boolean children) {
		super();
		this.userId = userId;
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.roomId = roomId;
		this.roomType = roomType;
		this.value = value;
		this.makeTime = makeTime;
		this.oInTime = oInTime;
		this.oOutTime = oOutTime;
		this.numOfRoom = numOfRoom;
		this.numOfPeople = numOfPeople;
		this.children = children;
	}
	/*
	 * 用户id 
	 */
	public String userId;
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
	 * 订单生成时间
	 */
	public String makeTime;
	/*
	 * 预订入住时间
	 */
	public String oInTime;
	/*
	 * 预订离开时间
	 */
	public String oOutTime;
	/*
	 * 房间数量
	 */
	public int numOfRoom;
	/*
	 * 预计入住人数
	 */
	public int numOfPeople;
	/*
	 * 有无儿童
	 */
	public boolean children;
}
