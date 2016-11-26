package po.credit;

import util.CreditChangeAction;

public class CreditChangePO {
	
	/**
	 * 客户id
	 */
	private String clientID;
	
	/**
	 * 信用改变时间
	 */
	private String changeTime;
	
	/**
	 * 信用改变值
	 */
	private int changeValue;
	
	/**
	 * 信用改变动作
	 */
	private CreditChangeAction action;

	/**
	 * 订单号（当改变动作为充值信用时可为空）
	 */
	private String orderID;

	/**
	 * @param clientID
	 * @param changeTime
	 * @param changeValue
	 * @param action
	 * @param orderID
	 */
	public CreditChangePO(String clientID, String changeTime, int changeValue, CreditChangeAction action,
			String orderID) {
		super();
		this.clientID = clientID;
		this.changeTime = changeTime;
		this.changeValue = changeValue;
		this.action = action;
		this.orderID = orderID;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(String changeTime) {
		this.changeTime = changeTime;
	}

	public int getChangeValue() {
		return changeValue;
	}

	public void setChangeValue(int changeValue) {
		this.changeValue = changeValue;
	}

	public CreditChangeAction getAction() {
		return action;
	}

	public void setAction(CreditChangeAction action) {
		this.action = action;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	
}
