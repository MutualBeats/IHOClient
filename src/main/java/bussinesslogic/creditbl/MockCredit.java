package bussinesslogic.creditbl;

import bussinesslogic.orderbl.CreditUpdate;
import util.result_message.credit.ResultMessage_CreditBLService;

public class MockCredit extends Credit implements CreditUpdate{
	
	@Override
	public ResultMessage_CreditBLService increaseCredit(String clientID, int value) {
		return ResultMessage_CreditBLService.Credit_Increase_Successful;
	}
	
	@Override
	public ResultMessage_CreditBLService decreaseCredit(String clientID, int value) {
		return ResultMessage_CreditBLService.Credit_Decrease_Successful;
	}
}
