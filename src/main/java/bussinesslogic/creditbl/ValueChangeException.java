package bussinesslogic.creditbl;
/**
 * @author Saltwater
 * If value of increase/decrease doesn't satisfy the standard
 * Increase : +
 * Decrease : -
 * Error Throw
 */
public class ValueChangeException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ValueChangeException() {
		super("Exception Appearance when change credit"+
				  "Check whether value of increase/decrease satisfies the standard"+
				  "Increase : +"+
				  "Decrease : -");
	}

}
