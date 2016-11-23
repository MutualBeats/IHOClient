package bussinesslogic.creditbl;

import java.util.ArrayList;

import bussinesslogic.orderbl.CreditUpdate;
import bussinesslogicservice.creditblservice.CreditBLService;
import util.result_message.credit.ResultMessage_Credit;
import vo.credit.CreditVO;

public class CreditController implements CreditBLService, CreditUpdate{
	
	private Credit credit = new Credit();
	
	@Override
	public ResultMessage_Credit increaseCredit(String clientID, int value) {
		return credit.increaseCredit(clientID, value);
	}

	@Override
	public ResultMessage_Credit decreaseCredit(String clientID, int value) {
		return credit.decreaseCredit(clientID, value);
	}

	@Override
	public ArrayList<CreditVO> checkCreditRecord(String clientID) {
		return credit.checkCreditRecord(clientID);
	}
	
}
