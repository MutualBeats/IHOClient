package bussinesslogic.creditbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import factory.datahelper.CreditDataHelper;
import factory.datahelper.DataHelperFactory;
import po.CreditChangePO;
import util.ResultMessage;
import util.Time;
import vo.CreditVO;

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
	 * Increasee of Credit
	 * 
	 * @param clientID
	 * @param value
	 * @return 
	 */
	public ResultMessage increaseCredit(String clientID, int value) {
		if(value <= 0) {
			System.err.print("Error ! Value change of credit to increase must be positive !\r\n");
			return ResultMessage.CreditIncreaseFailed;
		}
		CreditChangePO change = new CreditChangePO(clientID, Time.getCurrentTime(), value);
		//TODO : May Need to Return According to the Specific Error
		if(credit_data_service.increase(change).equals(ResultMessage.InsertSucceed)){
			return ResultMessage.CreditIncreaseSuccess;
		} else {
			return ResultMessage.CreditIncreaseFailed;
		}
	}

	public ResultMessage decreaseCredit(String clientID, int value) {
		if(value >= 0) {
			System.err.print("Error ! Value change of credit to decrease must be negative !\r\n");
			return ResultMessage.CreditDecreaseFailed;
		}
		CreditChangePO change = new CreditChangePO(clientID, Time.getCurrentTime(), value);
		if(credit_data_service.decrease(change).equals(ResultMessage.InsertSucceed)){
			return ResultMessage.CreditDecreaseSuccess;
		} else {
			return ResultMessage.CreditDecreaseFailed;
		}
	}

	public ArrayList<CreditVO> checkCreditRecord(String clientID) {
		return credit_data_service.find(clientID);
	}
	
	


}
