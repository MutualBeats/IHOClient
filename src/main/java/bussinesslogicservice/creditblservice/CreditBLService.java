/**
 * @author huangxiao
 * 2016年10月14日
 */
package bussinesslogicservice.creditblservice;

import java.util.ArrayList;

import util.ResultMessage;
import vo.CreditVO;

public interface CreditBLService {
	/**
	 * 增加信用
	 */
	public ResultMessage increaseCredit(String clientID, int value);
	/**
	 * 扣除信用
	 */
	public ResultMessage decreaseCredit(String clientID, int value);
	/**
	 * 获得某客户信用记录
	 */
	public ArrayList<CreditVO> checkCreditRecord(String clientID);
	
}
