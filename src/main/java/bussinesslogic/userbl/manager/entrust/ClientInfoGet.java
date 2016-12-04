package bussinesslogic.userbl.manager.entrust;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.user.ClientVO;

public interface ClientInfoGet {
	
	/**
	 * 获取用户信息
	 * 
	 * @param clientID
	 * @return
	 * @throws RemoteException
	 */
	public ClientVO getClientInfo(String clientID) throws RemoteException;
	
	/**
	 * 获取用户列表
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<ClientVO> getClientList() throws RemoteException;
	
}
