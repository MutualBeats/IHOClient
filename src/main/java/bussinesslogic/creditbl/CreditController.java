package bussinesslogic.creditbl;

import java.util.ArrayList;

import bussinesslogicservice.creditblservice.CreditBLService;
import util.ResultMessage;
import vo.CreditVO;

public class CreditController implements CreditBLService{

	@Override
	public ResultMessage increaseCredit(String clientID, int value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage decreaseCredit(String clientID, int value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CreditVO> checkCreditRecord(String clientID) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
