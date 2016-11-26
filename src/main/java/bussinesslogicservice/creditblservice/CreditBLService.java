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
	 * 更新信用记录
	 * @param updateVO
	 * @return
	 */
	public ResultMessage_Credit creditUpdate(CreditVO updateVO);
	/**
	 * 获得某客户信用记录
	 * @throws RemoteException 
	 */
	public Iterator<CreditVO> checkCreditRecord(String clientID) throws RemoteException;
	
}
