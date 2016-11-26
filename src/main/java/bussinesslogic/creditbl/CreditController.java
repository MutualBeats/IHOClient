package bussinesslogic.creditbl;

import java.rmi.RemoteException;
import java.util.Iterator;

import bussinesslogic.orderbl.CreditUpdate;
import bussinesslogicservice.creditblservice.CreditBLService;
import dataservice.creditdataservice.ResultMessage_Credit;
import vo.credit.CreditVO;

public class CreditController implements CreditBLService, CreditUpdate{
	
	private Credit credit = new Credit();
	


	@Override
	public Iterator<CreditVO> checkCreditRecord(String clientID) throws RemoteException {
		return credit.checkCreditRecord(clientID);
	}



	@Override
	public ResultMessage_Credit creditUpdate(CreditVO updateVO) {
		return credit.creditUpdate(updateVO);
	}

	
}
