package bussinesslogic.test;

import java.util.ArrayList;

import factory.datahelper.CreditDataHelper;
import po.CreditChangePO;
import po.CreditPO;
import util.ResultMessage;
import util.Time;
import vo.CreditVO;

/**
 * @author Saltwater
 * 测试用Credit。
 * 只更改了Credit 中部分方法可见性和构造函数
 */
public class Credit_Test{
	
	private CreditPO creditPO = null;
	private CreditDataHelper credit_data_service;
	
	/*----------测试用构造函数-----------*/
	public Credit_Test(CreditDataHelper credit_data_service) {
		this.credit_data_service = credit_data_service;
	}
	/*------------------------------------------*/
	
	/**
	 * Increasee of Credit
	 * 
	 * @param clientID
	 * @param value
	 * @return
	 */
	public ResultMessage increaseCredit(String clientID, int value) {
		if(value <= 0) {
			System.err.println("Error ! Value change of credit to increase must be positive !");
			return ResultMessage.CreditIncreaseFailed;
		}
		CreditChangePO change = new CreditChangePO(clientID, Time.getCurrentTime(), value);
		credit_data_service.increase(change);
		return ResultMessage.CreditIncreaseSuccess;
	}

	public ResultMessage decreaseCredit(String clientID, int value) {
		if(value >= 0) {
			System.err.println("Error ! Value change of credit to decrease must be negative !");
			return ResultMessage.CreditDecreaseFailed;
		}
		CreditChangePO change = new CreditChangePO(clientID, Time.getCurrentTime(), value);
		credit_data_service.decrease(change);
		return ResultMessage.CreditDecreaseSuccess;
	}

	public ArrayList<CreditVO> checkCreditRecord(String clientID) {
		return credit_data_service.find(clientID);
	}
	
	


}
