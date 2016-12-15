package presentation.clientui.browseorder;

import java.util.Enumeration;
import java.util.ResourceBundle;

import vo.order.OrderVO;

public class EvaluationBundle extends ResourceBundle {
	
	private OrderVO order;
	private final static String INFO = "order_info";

	public EvaluationBundle(OrderVO order) {
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
