/**
 * @author huangxiao
 * @version 2016年12月22日
 */
package bussinesslogic.creditbl;

public interface Notify {
	
	/**
	 * 更新客户Cache
	 * @param clientID
	 * @param credit
	 */
	public void notifyCreditChange(String clientID, int credit);

}
