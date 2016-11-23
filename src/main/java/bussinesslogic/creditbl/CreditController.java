package bussinesslogic.creditbl;

import java.util.ArrayList;

import bussinesslogic.orderbl.CreditUpdate;
import bussinesslogicservice.creditblservice.CreditBLService;
import util.ResultMessage_For_Stub;
import vo.CreditVO;

public class CreditController implements CreditBLService, CreditUpdate{
	
	private Credit credit = new Credit();
	
	@Override
	public ResultMessage_For_Stub increaseCredit(String clientID, int value) {
		return credit.increaseCredit(clientID, value);
	}

	@Override
	public ResultMessage_For_Stub decreaseCredit(String clientID, int value) {
		return credit.decreaseCredit(clientID, value);
	}

	@Override
	public ArrayList<CreditVO> checkCreditRecord(String clientID) {
		return credit.checkCreditRecord(clientID);
	}
	
}
