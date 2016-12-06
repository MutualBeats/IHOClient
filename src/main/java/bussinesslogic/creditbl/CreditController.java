package bussinesslogic.creditbl;

import java.rmi.RemoteException;
import java.util.Iterator;

import bussinesslogic.orderbl.CreditUpdate;
import bussinesslogic.userbl.client.CreditRegister;
import bussinesslogicservice.creditblservice.CreditBLService;
import util.resultmessage.ResultMessage_Credit;
import vo.credit.CreditVO;

public class CreditController implements CreditBLService, CreditUpdate, CreditRegister{
	
	private Credit credit = new Credit();
	
	public CreditController() throws Exception{	}

	@Override
	public Iterator<CreditVO> checkCreditRecord(String clientID) throws RemoteException {
		return credit.checkCreditRecord(clientID);
	}



	@Override
	public ResultMessage_Credit creditUpdate(CreditVO updateVO) {
		return credit.creditUpdate(updateVO);
	}


	@Override
	public ResultMessage_Credit addCreditRegister(String clientID) {
		return credit.addCreditRegister(clientID);
	}

	
}
