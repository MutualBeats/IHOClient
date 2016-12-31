package presentation.bundle;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;

import vo.order.OrderVO;

public class SingleOrderListBundle extends ResourceBundle {

	private ArrayList<OrderVO> order_list;
	private static final String ORDER_LIST = "order_list";

	public SingleOrderListBundle(ArrayList<OrderVO> order_list) {
		super();
		this.order_list = order_list;
	}

	@Override
	protected Object handleGetObject(String key) {
		if (ORDER_LIST.equals(key))
			return order_list;
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		return null;
	}

}
