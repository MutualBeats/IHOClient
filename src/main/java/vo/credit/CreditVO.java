/**
 * @author huangxiao
 * 2016年10月14日
 */
package vo.credit;

import po.credit.CreditPO;
import util.CreditChangeAction;

public class CreditVO {
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
	}

	public CreditVO(CreditPO po) {
		this(po.getClientID(), po.getChangeTime(), po.getChangeValue(), po.getCredit(), po.getAction(),
				po.getOrderID());
	}
}
