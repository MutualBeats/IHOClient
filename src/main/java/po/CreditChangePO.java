package po;

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
	 * @param clientID
	 * @param changeTime
	 * @param changeValue
	 */
	public CreditChangePO(String clientID, String changeTime, int changeValue) {
		super();
		this.clientID = clientID;
		this.changeTime = changeTime;
		this.changeValue = changeValue;
	}

	public String getClientID() {
		return clientID;
	}

	public String getChangeTime() {
		return changeTime;
	}

	public int getChangeValue() {
		return changeValue;
	}
	
	
}
