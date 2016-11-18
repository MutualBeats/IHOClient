package bussinesslogic.creditbl;

import bussinesslogic.orderbl.CreditUpdate;
import util.ResultMessage;

public class MockCredit extends Credit implements CreditUpdate{
	
	@Override
	public ResultMessage increaseCredit(String clientID, int value) {
		return ResultMessage.UpdateSucceed;
	}
	
	@Override
	public ResultMessage decreaseCredit(String clientID, int value) {
		return ResultMessage.UpdateSucceed;
	}
}
