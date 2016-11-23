package bussinesslogic.creditbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import factory.datahelper.CreditDataHelper;
import factory.datahelper.DataHelperFactory;
import po.CreditChangePO;
import util.ResultMessage_For_Stub;
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
	public ResultMessage_For_Stub increaseCredit(String clientID, int value) {
		if(value <= 0) {
			System.err.print("Error ! Value change of credit to increase must be positive !\r\n");
			return ResultMessage_For_Stub.CreditIncreaseFailed;
		}
		CreditChangePO change = new CreditChangePO(clientID, Time.getCurrentTime(), value);
		//TODO : May Need to Return According to the Specific Error
		if(credit_data_service.increase(change).equals(ResultMessage_For_Stub.InsertSucceed)){
			return ResultMessage_For_Stub.CreditIncreaseSuccess;
		} else {
			return ResultMessage_For_Stub.CreditIncreaseFailed;
		}
	}

	public ResultMessage_For_Stub decreaseCredit(String clientID, int value) {
		if(value >= 0) {
			System.err.print("Error ! Value change of credit to decrease must be negative !\r\n");
			return ResultMessage_For_Stub.CreditDecreaseFailed;
		}
		CreditChangePO change = new CreditChangePO(clientID, Time.getCurrentTime(), value);
		if(credit_data_service.decrease(change).equals(ResultMessage_For_Stub.InsertSucceed)){
			return ResultMessage_For_Stub.CreditDecreaseSuccess;
		} else {
			return ResultMessage_For_Stub.CreditDecreaseFailed;
		}
	}

	public ArrayList<CreditVO> checkCreditRecord(String clientID) {
		return credit_data_service.find(clientID);
	}
	
	


}
