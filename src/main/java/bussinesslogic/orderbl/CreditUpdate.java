package bussinesslogic.orderbl;

public interface CreditUpdate {
	
	/**
	 * Update the credit of current client;
	 * And make a credit record in credit
	 * 
	 * @param value : the value of order, positive means add, negative means sub.
	 */
	public void update (int value);
	
}
