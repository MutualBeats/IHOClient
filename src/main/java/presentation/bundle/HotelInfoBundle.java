package presentation.bundle;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;

import vo.hotel.HotelVO;

public class HotelInfoBundle extends ResourceBundle {

	private HotelVO hotel;

	private final static String HOTEL = "hotel";

	public HotelInfoBundle(HotelVO hotel) {
		super();
		this.hotel = hotel;
	}

	@Override
	protected Object handleGetObject(String key) {
		if (HOTEL.equals(key)) {
			return hotel;
		}
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		return null;
	}
	
	

}
