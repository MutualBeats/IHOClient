/**
 * @author huangxiao
 * 2016年10月14日
 */
package vo.credit;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import po.credit.CreditPO;
import util.credit.CreditChangeAction;

public class CreditVO {
	private final static String[] resons = new String[]{"用户注册初始化", "订单执行","订单异常", "撤销订单", "延迟入住", "信用充值"};
	
	private StringProperty time_property;
	private StringProperty reson_property;
	private SimpleIntegerProperty change_property;
	private IntegerProperty after_property;
	
	public StringProperty getTime_property() {
		return time_property;
	}

	public StringProperty getReson_property() {
		return reson_property;
	}

	public SimpleIntegerProperty getChange_property() {
		return change_property;
	}

	public IntegerProperty getAfter_property() {
		return after_property;
	}

	/**
	 * 客户id
	 */
	public String clientID;

	/**
	 * 信用改变时间
	 */
	public String changeTime;

	/**
	 * 信用改变值
	 */
	public int changeValue;

	/**
	 * 改变后信用值
	 */
	public int credit;

	/**
	 * 信用改变动作
	 */
	public CreditChangeAction action;

	/**
	 * 订单号（当改变动作为充值信用时可为空）
	 */
	public String orderID;

	/**
	 * @param clientID
	 * @param changeTime
	 * @param changeValue
	 * @param credit
	 * @param action
	 * @param orderID
	 */
	public CreditVO(String clientID, String changeTime, int changeValue, int credit, CreditChangeAction action,
			String orderID) {
		super();
		this.clientID = clientID;
		this.changeTime = changeTime;
		this.changeValue = changeValue;
		this.credit = credit;
		this.action = action;
		this.orderID = orderID;
		
		time_property = new SimpleStringProperty(changeTime);
		reson_property = new SimpleStringProperty(resons[action.ordinal()]);
		change_property = new SimpleIntegerProperty(changeValue);
		after_property = new SimpleIntegerProperty(credit);
	}

	public CreditVO(CreditPO po) {
		this(po.getClientID(), po.getChangeTime(), po.getChangeValue(), po.getCredit(), po.getAction(),
				po.getOrderID());
	}
}
