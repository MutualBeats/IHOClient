package presentation.bundle;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;

import vo.hotel.HotelVO;
import vo.order.OrderVO;

public class HotelInfoBundle extends ResourceBundle {

	private HotelVO hotel;
	
	private ArrayList<OrderVO> order_list;

	private final static String HOTEL = "hotel";
	
	private final static String ORDER_LIST = "order_list";
	
	public HotelInfoBundle(HotelVO hotel, ArrayList<OrderVO> order_list) {
		super();
		this.hotel = hotel;
		this.order_list = order_list;
	}

	@Override
	protected Object handleGetObject(String key) {
		if (HOTEL.equals(key)) {
			return hotel;
		} else if(ORDER_LIST.equals(key)) {
			return order_list;
		}
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		return null;
	}
	
	

}
