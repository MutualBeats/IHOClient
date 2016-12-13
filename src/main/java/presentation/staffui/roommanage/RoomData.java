/**
 * @author huangxiao
 * @version 2016年12月12日
 */
package presentation.staffui.roommanage;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import util.room.RoomState;
import util.room.RoomType;

public final class RoomData {
	
	private static final String[] ROOM_TYPE = {"单人间", "双人间", "三人间", "四人间"};
	
	private static final String[] ROOM_STATE = {"已预订", "未预订", "已入住"};
	
	private final StringProperty roomNumber = new SimpleStringProperty();
	
	private final StringProperty roomType = new SimpleStringProperty();
	
	private final IntegerProperty roomPrice = new SimpleIntegerProperty();
	
	private final StringProperty roomState = new SimpleStringProperty();
	
	public RoomData(String roomNumber, RoomType roomType, int roomPrice, RoomState roomState) {
		setRoomNumber(roomNumber);
		setRoomType(roomType);
		setRoomPrice(roomPrice);
		setRoomState(roomState);
	}
	
	public void setRoomNumber(String roomNumber) {
		this.roomNumber.set(roomNumber);
	}

	public String getRoomNumber() {
		return roomNumber.get();
	}
	
	public StringProperty roomNumberProperty() {
		return roomNumber;
	}
	
	public void setRoomType(RoomType roomType) {
		this.roomType.set(ROOM_TYPE[roomType.ordinal()]);
	}

	public String getRoomType() {
		return roomType.get();
	}
	
	public StringProperty roomTypeProperty() {
		return roomType;
	}
	
	public void setRoomPrice(int roomPrice) {
		this.roomPrice.set(roomPrice);
	}

	public int getRoomPrice() {
		return roomPrice.get();
	}
	
	public IntegerProperty roomPriceProperty() {
		return roomPrice;
	}
	
	public void setRoomState(RoomState roomState) {
		this.roomState.set(ROOM_STATE[roomState.ordinal()]);
	}

	public String getRoomState() {
		return roomState.get();
	}
	
	public StringProperty roomStateProperty() {
		return roomState;
	}

}
