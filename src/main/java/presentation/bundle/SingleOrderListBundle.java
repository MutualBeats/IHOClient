package presentation.bundle;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;
import vo.order.OrderVO;

public class SingleOrderListBundle extends ResourceBundle{
	
	private ArrayList<OrderVO> order_list;

	public SingleOrderListBundle(ArrayList<OrderVO> order_list) {
		this.order_list=order_list;
	}
	
	@Override
	protected Object handleGetObject(String key) {
		// TODO Auto-generated method stub
		return order_list;
	}

	@Override
	public Enumeration<String> getKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
