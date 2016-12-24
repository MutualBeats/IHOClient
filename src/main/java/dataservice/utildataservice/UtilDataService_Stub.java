/**
 * @author huangxiao
 */
package dataservice.utildataservice;

import java.rmi.RemoteException;

import util.resultmessage.ResultMessage_Verify;

public class UtilDataService_Stub implements Identify {

	@Override
	public ResultMessage_Verify login(String user_name, String password) throws RemoteException {
		return ResultMessage_Verify.CLIENT;
	}

	@Override
	public ResultMessage_Verify checkUserName(String user_name) throws RemoteException {
		return ResultMessage_Verify.USER_NOT_EXIST;
	}

	@Override
	public ResultMessage_Verify checkIdentity(String user_name) throws RemoteException {
		return ResultMessage_Verify.CLIENT;
	}

}
