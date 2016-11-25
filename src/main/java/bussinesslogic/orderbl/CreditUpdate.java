package bussinesslogic.orderbl;

import bussinesslogic.creditbl.ValueChangeException;
import util.result_message.credit.ResultMessage_CreditBL;

public interface CreditUpdate {
	
	/**
	 * Update the credit of current client;
	 * And make a credit record in credit
	 * 
	 * @param value : the value of order
	 */
	public ResultMessage_CreditBL increaseCredit(String clientID, int value) throws ValueChangeException;

	public ResultMessage_CreditBL decreaseCredit(String clientID, int value);
	
}
