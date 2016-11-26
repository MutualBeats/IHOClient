package bussinesslogic.creditbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import factory.datahelper.CreditDataHelper;
import factory.datahelper.DataHelperFactory;
import po.credit.CreditChangePO;
import util.Time;
import util.result_message.credit.ResultMessage_CreditBL;
import vo.credit.CreditVO;

/**
 * 客户端逻辑具体实现
 * 
 * @author Saltwater
 */
public class Credit{
	
	private CreditDataHelper credit_data_service;
	
	public Credit() {
		try {
			credit_data_service = DataHelperFactory.getDataFactoryHelperInstance().getCreditDatabase();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Increase Credit
	 * 
	 * @param clientID
	 * @param value : Credit Value to Increase
	 * @return 
	 */
	public ResultMessage_CreditBL increaseCredit(String clientID, int value) {
		if(value <= 0) {
			System.err.print("Error ! Value change of credit to increase must be positive !\r\n");
			return ResultMessage_CreditBL.Credit_ChangeValue_Positive;
		}
		CreditChangePO change = new CreditChangePO(clientID, Time.getCurrentTime(), value);
		
		return credit_data_service.increase(change);
	}

	/**
	 * Decrease Credit
	 * 
	 * @param clientID
	 * @param value : Credit Value to Decrease
	 * @return
	 */
	public ResultMessage_CreditBL decreaseCredit(String clientID, int value) {
		if(value >= 0) {
			System.err.print("Error ! Value change of credit to decrease must be negative !\r\n");
			return ResultMessage_CreditBL.Credit_ChangeValue_Positive;
		}
		CreditChangePO change = new CreditChangePO(clientID, Time.getCurrentTime(), value);
		return credit_data_service.decrease(change);
	}

	/**
	 * Get user's credit record
	 * 
	 * @param clientID
	 * @return Iterator of Credit Record
	 */
	public Iterator<CreditVO> checkCreditRecord(String clientID) {
		return credit_data_service.find(clientID);
	}
	
	


}
