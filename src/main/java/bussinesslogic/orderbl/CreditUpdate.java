package bussinesslogic.orderbl;

import bussinesslogic.creditbl.ValueChangeException;
import util.ResultMessage_For_Stub;

public interface CreditUpdate {
	
	/**
	 * Update the credit of current client;
	 * And make a credit record in credit
	 * 
	 * @param value : the value of order
	 */
	public ResultMessage_For_Stub increaseCredit(String clientID, int value) throws ValueChangeException;

	public ResultMessage_For_Stub decreaseCredit(String clientID, int value);
	
}
