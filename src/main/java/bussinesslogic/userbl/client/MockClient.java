package bussinesslogic.userbl.client;

import java.rmi.RemoteException;

import bussinesslogic.orderbl.ClientInfo;
import vo.user.ClientVO;

public class MockClient extends Client implements ClientInfo {

	public MockClient() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see bussinesslogic.orderbl.ClientInfo#getClientInfo()
	 */
	@Override
	public ClientVO getClientInfo(String clientID) {
		// TODO Auto-generated method stub
		return null;
	}


}
