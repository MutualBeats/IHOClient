package bussinesslogic.orderbl;

import util.resultmessage.ResultMessage_Credit;
import vo.credit.CreditVO;

public interface CreditUpdate {
	
	/**
	 * Update the credit of current client;
	 * And make a credit record in credit
	 * 
	 * @param vo : the value of order
	 */
	public ResultMessage_Credit creditUpdate(CreditVO updateVO);
	
}
