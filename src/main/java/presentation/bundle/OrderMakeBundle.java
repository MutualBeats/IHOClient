package presentation.bundle;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;

import vo.hotel.HotelVO;
import vo.room.RoomVO;
import vo.user.ClientVO;

public class OrderMakeBundle extends ResourceBundle {

	private HotelVO hotel_info;
	private final static String HOTEL_INFO = "hotel_info";

	private ClientVO client_info;
	private final static String CLIENT_INFO = "client_info";

	private ArrayList<RoomVO> rooms;
	private final static String ROOMS = "room_list";

	public OrderMakeBundle(HotelVO hotel_info, ArrayList<RoomVO> rooms) {
		super();
		this.hotel_info = hotel_info;
		this.rooms = rooms;
	}

	@Override
	protected Object handleGetObject(String key) {
		if (HOTEL_INFO.equals(key)) {
			return hotel_info;
		} else if (CLIENT_INFO.equals(key)) {
			return client_info;
		} else if (ROOMS.equals(key)) {
			return rooms;
		}
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		return null;
	}

}
