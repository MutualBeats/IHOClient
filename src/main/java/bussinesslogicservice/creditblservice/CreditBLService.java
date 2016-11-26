/**
 * @author huangxiao
 * 2016年10月14日
 */
package bussinesslogicservice.creditblservice;

import java.rmi.RemoteException;
import java.util.Iterator;

import dataservice.creditdataservice.ResultMessage_Credit;
import vo.credit.CreditVO;

public interface CreditBLService {

	/**
	 * 获得某客户信用记录
	 * @throws RemoteException 
	 */
	public Iterator<CreditVO> checkCreditRecord(String clientID) throws RemoteException;
	
}
