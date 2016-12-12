package presentation.clientui.browseorder;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;

import vo.order.OrderVO;

public class OrderListBundle extends ResourceBundle {

	private ArrayList<OrderVO> total_list;
	private ArrayList<OrderVO> executed_list;
	private ArrayList<OrderVO> unexecute_list;
	private ArrayList<OrderVO> revoked_list;
	private ArrayList<OrderVO> exception_list;
	
	private final static String TOTAL = "total";
	private final static String EXE = "execute";
	
	

	public OrderListBundle(ArrayList<OrderVO> total_list, ArrayList<OrderVO> executed_list,
			ArrayList<OrderVO> unexecute_list, ArrayList<OrderVO> revoked_list, ArrayList<OrderVO> exception_list) {
		super();
		this.total_list = total_list;
		this.executed_list = executed_list;
		this.unexecute_list = unexecute_list;
		this.revoked_list = revoked_list;
		this.exception_list = exception_list;
	}

	@Override
	protected Object handleGetObject(String key) {
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
