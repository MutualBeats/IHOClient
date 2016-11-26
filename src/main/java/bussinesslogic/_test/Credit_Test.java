package bussinesslogic._test;

import java.util.ArrayList;
import java.util.Iterator;

import factory.datahelper.CreditDataHelper;
import po.credit.CreditChangePO;
import po.credit.CreditPO;
import util.ResultMessage_For_Stub;
import util.Time;
import vo.credit.CreditVO;

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
	public ResultMessage_For_Stub increaseCredit(String clientID, int value) {
		if(value <= 0) {
			System.err.println("Error ! Value change of credit to increase must be positive !");
			return ResultMessage_For_Stub.CreditIncreaseFailed;
		}
		CreditChangePO change = new CreditChangePO(clientID, Time.getCurrentTime(), value);
		credit_data_service.increase(change);
		return ResultMessage_For_Stub.CreditIncreaseSuccess;
	}

	public ResultMessage_For_Stub decreaseCredit(String clientID, int value) {
		if(value >= 0) {
			System.err.println("Error ! Value change of credit to decrease must be negative !");
			return ResultMessage_For_Stub.CreditDecreaseFailed;
		}
		CreditChangePO change = new CreditChangePO(clientID, Time.getCurrentTime(), value);
		credit_data_service.decrease(change);
		return ResultMessage_For_Stub.CreditDecreaseSuccess;
	}

	public Iterator<CreditVO> checkCreditRecord(String clientID) {
		return credit_data_service.find(clientID);
	}
	
	


}
