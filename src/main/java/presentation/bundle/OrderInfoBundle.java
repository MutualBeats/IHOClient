package presentation.bundle;

import java.util.Enumeration;
import java.util.ResourceBundle;

import vo.order.OrderVO;

public class OrderInfoBundle extends ResourceBundle {

	private OrderVO order_info;
	private final static String ORDER = "order_info";

	private String hotel_name;
	private final static String HOTEL = "hotel_name";
	
	private String promotion_name;
	private final static String PROMOTION = "promotion_name";

	public OrderInfoBundle(OrderVO order_info, String hotel_name, String promotion_name) {
		super();
		this.order_info = order_info;
		this.hotel_name = hotel_name;
		this.promotion_name = promotion_name;
	}

	@Override
	protected Object handleGetObject(String key) {
		if (ORDER.equals(key)) {
			return order_info;
		} else if (HOTEL.equals(key)) {
			return hotel_name;
		} else if(PROMOTION.equals(key)) {
			return promotion_name;
		}
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		return null;
	}

}
