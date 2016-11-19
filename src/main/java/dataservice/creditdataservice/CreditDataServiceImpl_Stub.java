/**
 * @author huangxiao
 * 2016年10月15日
 */
package dataservice.creditdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CreditPO;

public class CreditDataServiceImpl_Stub implements CreditDataService {

	@Override
	public void insert(CreditPO po) throws RemoteException {
		System.out.println("Insert Succeed!");
	}

	@Override
	public ArrayList<CreditPO> find(String clientID) throws RemoteException {
		System.out.println("Find Succeed!");
		ArrayList<CreditPO> creditList = new ArrayList<CreditPO>();
		creditList.add(new CreditPO(clientID, "2016/10/16 11:30:24", 100, 300));
		creditList.add(new CreditPO(clientID, "2016/10/14 6:20:30", 100, 200));
		return creditList;
	}

}
