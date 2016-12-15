/**
 * @author huangxiao
 * 2016年10月14日
 */
package vo.room;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import po.room.RoomPO;
import util.room.RoomState;
import util.room.RoomType;

public class RoomVO {
	
	private static final String[] ROOM_TYPE = {"单人间", "双人间", "三人间", "四人间"};
	private static final String[] ROOM_STATE = {"已预订", "未预订", "已入住"};
	
	private final StringProperty roomNumberProperty = new SimpleStringProperty();
	private final StringProperty roomTypeProperty = new SimpleStringProperty();
	private final IntegerProperty roomPriceProperty = new SimpleIntegerProperty();
	private final StringProperty roomStateProperty = new SimpleStringProperty();
	
	public void setRoomNumber(String roomNumber) {
		this.roomNumberProperty.set(roomNumber);
	}
	
	public String getRoomNumber() {
		return roomNumberProperty.get();
	}
	
	public StringProperty roomNumberProperty() {
		return roomNumberProperty;
	}
	
	public void setRoomType(RoomType roomType) {
		this.roomTypeProperty.set(ROOM_TYPE[roomType.ordinal()]);
	}
	
	public String getRoomType() {
		return roomTypeProperty.get();
	}
	
	public StringProperty roomTypeProperty() {
		return roomTypeProperty;
	}
	
	public void setRoomPrice(int roomPrice) {
		this.roomPriceProperty.set(roomPrice);
	}
	
	public IntegerProperty roomPriceProperty() {
		return roomPriceProperty;
	}
	
	public int getRoomPrice() {
		return roomPriceProperty.get();
	}
	
	public void setRoomState(RoomState roomState) {
		this.roomStateProperty.set(ROOM_STATE[roomState.ordinal()]);
	}
	
	public StringProperty roomStateProperty() {
		return roomStateProperty;
	}
	
	public String getRoomState() {
		return roomStateProperty.get();
	}
	
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
