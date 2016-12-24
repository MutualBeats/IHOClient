/**
 * @author huangxiao
 */
package dataservice.utildataservice;

import java.rmi.RemoteException;

import util.resultmessage.ResultMessage_Verify;

public class UtilDataService_Driver {
	
	public void drive(Identify identify) throws RemoteException {
		
		ResultMessage_Verify result;
		
		// log in
		result = identify.login("huangxiao", "testpassword");
		System.out.println("Log in result: " + result.toString());
		
		// check user name
		result = identify.checkUserName("TestUserName");
		System.out.println("Check user name result: " + result.toString());
		
		// check identity
		result = identify.checkIdentity("huangxiao");
		System.out.println("Check identity result: " + result.toString());
		
	}

}
