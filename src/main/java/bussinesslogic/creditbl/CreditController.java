package bussinesslogic.creditbl;

import java.util.Iterator;

import bussinesslogic.orderbl.CreditUpdate;
import bussinesslogicservice.creditblservice.CreditBLService;
import util.result_message.credit.ResultMessage_CreditBL;
import vo.credit.CreditVO;

public class CreditController implements CreditBLService, CreditUpdate{
	
	private Credit credit = new Credit();
	
	@Override
	public ResultMessage_CreditBL increaseCredit(String clientID, int value) {
		return credit.increaseCredit(clientID, value);
	}

	@Override
	public ResultMessage_CreditBL decreaseCredit(String clientID, int value) {
		return credit.decreaseCredit(clientID, value);
	}

	@Override
	public Iterator<CreditVO> checkCreditRecord(String clientID) {
		return credit.checkCreditRecord(clientID);
	}
	
}
