package presentation.bundle;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;

import vo.order.OrderVO;

/**
 * 
 * OrderList Bundle ： 用于查看订单列表
 * 
 * 包含： 总列表 已执行 未执行 已撤销 异常
 * 
 * @author heleninsa
 *
 */
public class OrderListBundle extends ResourceBundle {

	private ArrayList<OrderVO> total_list;
	private ArrayList<OrderVO> finish_list;
	private ArrayList<OrderVO> unexecute_list;
	private ArrayList<OrderVO> revoked_list;
	private ArrayList<OrderVO> exception_list;

	private final static String TOTAL = "total";
	private final static String FINISH = "finish";
	private final static String UN_EXE = "unexecute";
	private final static String REVOKE = "revoked";
	private final static String EXCEPTION = "exception";

	/**
	 * @param total_list
	 * @param finish_list
	 * @param unexecute_list
	 * @param revoked_list
	 * @param exception_list
	 */
	public OrderListBundle(ArrayList<OrderVO> total_list, ArrayList<OrderVO> finish_list,
			ArrayList<OrderVO> unexecute_list, ArrayList<OrderVO> revoked_list, ArrayList<OrderVO> exception_list) {
		super();
		this.total_list = total_list;
		this.finish_list = finish_list;
		this.unexecute_list = unexecute_list;
		this.revoked_list = revoked_list;
		this.exception_list = exception_list;
	}

	@Override
	protected Object handleGetObject(String key) {
		if (TOTAL.equals(key)) {
			return total_list;
		} else if (FINISH.equals(key)) {
			return finish_list;
		} else if (UN_EXE.equals(key)) {
			return unexecute_list;
		} else if (REVOKE.equals(key)) {
			return revoked_list;
		} else if (EXCEPTION.equals(key)) {
			return exception_list;
		}
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		return null;
	}

}
