package bussinesslogic.creditbl;

import java.rmi.RemoteException;
import java.util.Iterator;

import dataservice.creditdataservice.ResultMessage_Credit;
import factory.datahelper.CreditDataHelper;
import factory.datahelper.DataHelperFactory;
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
	public Iterator<CreditVO> checkCreditRecord(String clientID) throws RemoteException {
		return credit_data_service.find(clientID);
	}
		


}
