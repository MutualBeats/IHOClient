/**
 * @author huangxiao
 */
package dataservice.userdataservice;

import java.rmi.RemoteException;

import po.user.ManagerPO;
import util.resultmessage.ResultMessage_User;

public class ManagerDataService_Driver {
	
	public void driver(ManagerDataService managerDataService) throws RemoteException {
		
		ManagerPO manager = managerDataService.getManagerInfo();
		System.out.println(manager.getManagerName() + " " + manager.getContactWay());

		manager.setContactWay("98765432100");
		ResultMessage_User result = managerDataService.changeManagerInfo(manager);
		System.out.println(result);
		
	}

}
