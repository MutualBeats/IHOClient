/**
 * @author huangxiao
 * 2016年10月14日
 */
package bussinesslogicservice.creditblservice;

import java.util.ArrayList;
import java.util.Iterator;

import util.result_message.credit.ResultMessage_CreditBL;
import vo.credit.CreditVO;

public interface CreditBLService {
	/**
	 * 增加信用
	 */
	public ResultMessage_CreditBL increaseCredit(String clientID, int value);
	/**
	 * 扣除信用
	 */
	public ResultMessage_CreditBL decreaseCredit(String clientID, int value);
	/**
	 * 获得某客户信用记录
	 */
	public Iterator<CreditVO> checkCreditRecord(String clientID);
	
}
