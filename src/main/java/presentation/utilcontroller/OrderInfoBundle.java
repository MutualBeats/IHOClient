package presentation.utilcontroller;

import java.util.Enumeration;
import java.util.ResourceBundle;

import vo.order.OrderVO;

public class OrderInfoBundle extends ResourceBundle {

	private OrderVO order_info;
	private final static String ORDER = "order_info";

	private String hotel_name;
	private final static String HOTEL = "hotel_name";

	public OrderInfoBundle(OrderVO order_info, String hotel_name) {
		super();
		this.order_info = order_info;
		this.hotel_name = hotel_name;
	}

	@Override
	protected Object handleGetObject(String key) {
		if (ORDER.equals(key)) {
			return order_info;
		} else if (HOTEL.equals(key)) {
			return hotel_name;
		}
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		return null;
	}

}
