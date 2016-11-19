package bussinesslogic.creditbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import factory.datahelper.CreditDataHelper;
import factory.datahelper.DataHelperFactory;
import po.CreditChangePO;
import po.CreditPO;
import util.ResultMessage;
import util.Time;
import vo.CreditVO;

public class Credit{
	
	private CreditPO creditPO = null;
	private CreditDataHelper credit_data_service;
	
	public Credit() {
		try {
			credit_data_service = DataHelperFactory.getDataFactoryHelperInstance().getCreditDatabase();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
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
		// TODO Auto-generated method stub
		return null;
	}
	
	


}
