package presentation.bundle;

import java.util.Enumeration;
import java.util.ResourceBundle;

import presentation.clientui.browseorder.UpdateEvaluation;
import vo.order.OrderVO;

public class EvaluatedOrderBundle extends ResourceBundle {
	
	private UpdateEvaluation update;
	private final static String UPDATE = "update";
	
	private OrderVO order;
	private final static String INFO = "order_info";

	public EvaluatedOrderBundle(UpdateEvaluation update, OrderVO order) {
		super();
		this.update = update;
		this.order = order;
	}

	@Override
	protected Object handleGetObject(String key) {
		if(INFO.equals(key)) {
			return order;
		} else if(UPDATE.equals(key)) {
			return update;
		}
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		return null;
	}

}
