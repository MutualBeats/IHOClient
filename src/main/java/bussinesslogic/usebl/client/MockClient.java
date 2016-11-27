package bussinesslogic.usebl.client;

import java.rmi.RemoteException;

import bussinesslogic.orderbl.ClientInfo;
import vo.user.ClientVO;

public class MockClient extends Client implements ClientInfo {

	public MockClient() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ClientVO getUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
