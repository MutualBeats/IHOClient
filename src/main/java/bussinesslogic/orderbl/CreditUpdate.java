package bussinesslogic.orderbl;

import bussinesslogic.creditbl.ValueChangeException;
import util.ResultMessage;

public interface CreditUpdate {
	
	/**
	 * Update the credit of current client;
	 * And make a credit record in credit
	 * 
	 * @param value : the value of order
	 */
	public ResultMessage increaseCredit(String clientID, int value) throws ValueChangeException;

	public ResultMessage decreaseCredit(String clientID, int value);
	
}
