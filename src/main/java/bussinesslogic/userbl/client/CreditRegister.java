/**
 * @author huangxiao
 * @version 2016年12月5日
 */
package bussinesslogic.userbl.client;

import util.resultmessage.ResultMessage_Credit;

public interface CreditRegister {
	
	public ResultMessage_Credit addCreditRegister(String clientID);

}
