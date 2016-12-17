package presentation.bundle;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;

import vo.hotel.HotelVO;

public class HotelListBundle extends ResourceBundle{
	
	private ArrayList<HotelVO> hotel_list;
	
	private final static String HOTEL = "hotel_list";

	public HotelListBundle(ArrayList<HotelVO> hotel_list) {
		super();
		this.hotel_list = hotel_list;
	}

	@Override
	protected Object handleGetObject(String key) {
		if(HOTEL.equals(key)) {
			return hotel_list;
		}
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		return null;
	}

		
	
}
