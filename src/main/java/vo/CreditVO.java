/**
 * @author huangxiao
 * 2016年10月14日
 */
package vo;

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
	 * 构造方法
	 * @param clientID
	 * @param changeTime
	 * @param changeValue
	 * @param credit
	 */
	public CreditVO(String clientID, String changeTime, int changeValue, int credit) {
		this.clientID = clientID;
		this.changeTime = changeTime;
		this.changeValue = changeValue;
		this.credit = credit;
	}
}
