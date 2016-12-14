/**
 * @author huangxiao
 * @version 2016年12月14日
 */
package bussinesslogic.hotelbl;

import util.resultmessage.ResultMessage_Order;

public interface OrderUpdate {
	
	public ResultMessage_Order orderEvaluate(String orderID);

}
