package bussinesslogic.userbl.manager.entrust;

import java.rmi.RemoteException;

import vo.user.ClientVO;

public interface Client2Manager {
	
	/**
	 * 获取用户信息
	 * 
	 * @param clientID
	 * @return
	 * @throws RemoteException
	 */
	public ClientVO getClientInfo(String clientID) throws RemoteException;
	
}
