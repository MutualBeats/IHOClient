package bussinesslogic.orderbl;

import java.rmi.RemoteException;

import vo.user.ClientVO;

public interface ClientInfo {
	
	public ClientVO getClientInfo(String clientID) throws RemoteException;
	
}
