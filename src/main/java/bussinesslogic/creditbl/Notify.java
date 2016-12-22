/**
 * @author huangxiao
 * @version 2016年12月22日
 */
package bussinesslogic.creditbl;

import util.exception.NetException;

public interface Notify {
	
	/**
	 * 更新客户Cache
	 * @param clientID
	 * @param credit
	 * @throws NetException 
	 */
	public void notifyCreditChange(String clientID, int credit) throws NetException;

}
