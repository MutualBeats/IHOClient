package bussinesslogic.creditbl;

import java.util.ArrayList;

import bussinesslogic.orderbl.CreditUpdate;
import bussinesslogicservice.creditblservice.CreditBLService;
import util.ResultMessage;
import vo.CreditVO;

public class CreditController implements CreditBLService, CreditUpdate{

	private final static CreditController CREDIT_CONTROLLER = new CreditController(new Credit());
	
	public static CreditBLService getCreditBLServiceInstance() {
		return CREDIT_CONTROLLER;
	}
	
	public static CreditUpdate getCreditUpdateInstance() {
		return CREDIT_CONTROLLER;
	}
	
	private Credit credit;
	
	private CreditController(Credit credit) {
		this.credit = credit;
	}
	
	@Override
	public ResultMessage increaseCredit(String clientID, int value) {
		return credit.increaseCredit(clientID, value);
	}

	@Override
	public ResultMessage decreaseCredit(String clientID, int value) {
		return credit.decreaseCredit(clientID, value);
	}

	@Override
	public ArrayList<CreditVO> checkCreditRecord(String clientID) {
		return credit.checkCreditRecord(clientID);
	}
	
}
