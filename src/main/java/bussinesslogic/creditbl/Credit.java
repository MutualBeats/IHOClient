package bussinesslogic.creditbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import factory.datahelper.CreditDataHelper;
import factory.datahelper.DataHelperFactory;
import po.CreditChangePO;
import util.Time;
import util.result_message.credit.ResultMessage_CreditBLService;
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
	public ResultMessage_CreditBLService increaseCredit(String clientID, int value) {
		if(value <= 0) {
			System.err.print("Error ! Value change of credit to increase must be positive !\r\n");
			return ResultMessage_CreditBLService.Credit_ChangeValue_Positive;
		}
		CreditChangePO change = new CreditChangePO(clientID, Time.getCurrentTime(), value);
		//TODO : May Need to Return According to the Specific Error
		return credit_data_service.increase(change);
	}

	public ResultMessage_CreditBLService decreaseCredit(String clientID, int value) {
		if(value >= 0) {
			System.err.print("Error ! Value change of credit to decrease must be negative !\r\n");
			return ResultMessage_CreditBLService.Credit_ChangeValue_Positive;
		}
		CreditChangePO change = new CreditChangePO(clientID, Time.getCurrentTime(), value);
		return credit_data_service.decrease(change);
	}

	public ArrayList<CreditVO> checkCreditRecord(String clientID) {
		return credit_data_service.find(clientID);
	}
	
	


}
