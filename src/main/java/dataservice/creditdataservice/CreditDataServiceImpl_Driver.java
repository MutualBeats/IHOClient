/**
 * @author huangxiao
 * 2016年10月15日
 */
package dataservice.creditdataservice;

import java.rmi.RemoteException;

import po.CreditPO;
import util.CreditChangeAction;

public class CreditDataServiceImpl_Driver {
	
	public void drive(CreditDataService creditDataService) throws RemoteException {
		CreditPO po = new CreditPO("0000000001", "2016/10/14", CreditChangeAction.Deposit, "0002354698", 100, 200);
		
		creditDataService.insert(po);
		creditDataService.find("0000000001");
	}

}
