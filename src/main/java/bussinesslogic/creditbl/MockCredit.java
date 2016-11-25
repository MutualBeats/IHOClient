package bussinesslogic.creditbl;

import bussinesslogic.orderbl.CreditUpdate;
import util.result_message.credit.ResultMessage_CreditBL;

public class MockCredit extends Credit implements CreditUpdate{
	
	@Override
	public ResultMessage_CreditBL increaseCredit(String clientID, int value) {
		return ResultMessage_CreditBL.Credit_Increase_Successful;
	}
	
	@Override
	public ResultMessage_CreditBL decreaseCredit(String clientID, int value) {
		return ResultMessage_CreditBL.Credit_Decrease_Successful;
	}
}
