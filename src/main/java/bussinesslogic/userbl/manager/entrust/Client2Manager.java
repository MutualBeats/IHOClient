package bussinesslogic.userbl.manager.entrust;

import java.rmi.RemoteException;

import vo.user.ClientVO;

public interface Client2Manager {
	/*
	 *获取用户信息 
	 */
	public ClientVO showData(String clientID) throws RemoteException;
}
