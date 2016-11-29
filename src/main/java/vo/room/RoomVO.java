/**
 * @author huangxiao
 * 2016年10月14日
 */
package vo.room;

import po.room.RoomPO;
import util.room.RoomState;
import util.room.RoomType;

public class RoomVO {
	/**
	 * 所属酒店id
	 */
	public String hotelID;
	/**
	 * 房间号
	 */
	public String roomNumber;
	/**
	 * 房间类型
	 */
	public RoomType type;
	/**
	 * 房间价格
	 */
	public int price;
	/**
	 * 当前状态
	 */
	public RoomState condition;
	
	/**
	 * @param hotelID
	 * @param roomNumber
	 * @param type
	 * @param price
	 * @param condition
	 */
	public RoomVO(String hotelID, String roomNumber, RoomType type, int price, RoomState condition) {
		super();
		this.hotelID = hotelID;
		this.roomNumber = roomNumber;
		this.type = type;
		this.price = price;
		this.condition = condition;
	}

	public RoomVO(RoomPO info) {
		this(info.getHotelID(), info.getRoomNumber(), info.getType(), info.getPrice(), info.getCondition());
	}
	
	
}
