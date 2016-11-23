package bussinesslogic.creditbl;

import bussinesslogic.orderbl.CreditUpdate;
import util.result_message.credit.ResultMessage_Credit;

public class MockCredit extends Credit implements CreditUpdate{
	
	@Override
	public ResultMessage_Credit increaseCredit(String clientID, int value) {
		return ResultMessage_Credit.Credit_Increase_Successful;
	}
	
	@Override
	public ResultMessage_Credit decreaseCredit(String clientID, int value) {
		return ResultMessage_Credit.Credit_Decrease_Successful;
	}
}
