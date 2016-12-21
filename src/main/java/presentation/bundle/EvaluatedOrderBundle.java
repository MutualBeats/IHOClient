package presentation.bundle;

import java.util.Enumeration;
import java.util.ResourceBundle;

import vo.order.OrderVO;

public class EvaluatedOrderBundle extends ResourceBundle {
	
	private OrderVO order;
	private final static String INFO = "order_info";

	public EvaluatedOrderBundle(OrderVO order) {
		super();
		this.order = order;
	}

	@Override
	protected Object handleGetObject(String key) {
		if(INFO.equals(key)) {
			return order;
		}
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		return null;
	}

}
