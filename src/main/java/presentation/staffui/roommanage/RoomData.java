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
		String type;
		switch (roomType) {
		case Single:
			type = "单人房";
			break;
		case Double:
			type = "双人房";
			break;
		case Triple:
			type = "三人房";
			break;
		case Four:
			type = "四人房";
			break;
		default:
			type = "";
		}
		this.roomType.set(type);
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
		String state;
		switch (roomState) {
		case NotReserved:
			state = "未预订";
			break;
		case Occupied:
			state = "已入住";
			break;
		case Reserved:
			state = "已预订";
			break;
		default:
			state = "";
			break;
		}
		this.roomState.set(state);
	}

	public String getRoomState() {
		return roomState.get();
	}
	
	public StringProperty roomStateProperty() {
		return roomState;
	}

}
