package bussinesslogic.creditbl;

import bussinesslogic.orderbl.CreditUpdate;
import util.ResultMessage_For_Stub;

public class MockCredit extends Credit implements CreditUpdate{
	
	@Override
	public ResultMessage_For_Stub increaseCredit(String clientID, int value) {
		return ResultMessage_For_Stub.UpdateSucceed;
	}
	
	@Override
	public ResultMessage_For_Stub decreaseCredit(String clientID, int value) {
		return ResultMessage_For_Stub.UpdateSucceed;
	}
}
