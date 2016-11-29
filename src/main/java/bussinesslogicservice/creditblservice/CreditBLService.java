/**
 * @author huangxiao
 * 2016年10月14日
 */
package bussinesslogicservice.creditblservice;

import java.rmi.RemoteException;
import java.util.Iterator;

import util.resultmessage.ResultMessage_Credit;
import vo.credit.CreditVO;

public interface CreditBLService {

	/**
	 * Update the credit of current client;
	 * And make a credit record in credit
	 * 
	 * @param vo : the value of order
	 */
	public ResultMessage_Credit creditUpdate(CreditVO updateVO);
		
	/**
	 * 获得某客户信用记录
	 * @throws RemoteException 
	 */
	public Iterator<CreditVO> checkCreditRecord(String clientID) throws RemoteException;
	
}
