/**
 * @author huangxiao
 * 2016年10月14日
 */
package bussinesslogicservice.creditblservice;

import java.util.ArrayList;

import util.result_message.credit.ResultMessage_Credit;
import vo.credit.CreditVO;

public interface CreditBLService {
	/**
	 * 增加信用
	 */
	public ResultMessage_Credit increaseCredit(String clientID, int value);
	/**
	 * 扣除信用
	 */
	public ResultMessage_Credit decreaseCredit(String clientID, int value);
	/**
	 * 获得某客户信用记录
	 */
	public ArrayList<CreditVO> checkCreditRecord(String clientID);
	
}
