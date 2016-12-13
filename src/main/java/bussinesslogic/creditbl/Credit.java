package bussinesslogic.creditbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import factory.datahelper.CreditDataHelper;
import factory.datahelper.DataHelperFactory;
import util.Time;
import util.credit.CreditChangeAction;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Credit;
import vo.credit.CreditVO;

/**
 * 客户端逻辑具体实现
 * 
 * @author Saltwater
 */
public class Credit{
	
	private CreditDataHelper credit_data_service;
	
	public Credit() throws NetException {
	
		credit_data_service = DataHelperFactory.getDataFactoryHelperInstance().getCreditDatabase();
		
	}
	
	public ResultMessage_Credit creditUpdate(CreditVO updateVO) {
		return credit_data_service.creditUpdate(updateVO);
	}

	/**
	 * Get user's credit record
	 * 
	 * @param clientID
	 * @return Iterator of Credit Record
	 * @throws RemoteException 
	 */
	public ArrayList<CreditVO> checkCreditRecord(String clientID) throws NetException {
		return credit_data_service.find(clientID);
	}
	
	
	public ResultMessage_Credit addCreditRegister(String clientID) {
		CreditVO vo = new CreditVO(clientID, Time.getCurrentTime(), 0, 0, CreditChangeAction.Register, "");
		return credit_data_service.creditRegist(vo);
	}
	

}
