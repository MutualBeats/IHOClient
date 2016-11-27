package bussinesslogic.userbl.client;

import java.rmi.RemoteException;

import bussinesslogic.userbl.manager.entrust.Client2Manager;
import bussinesslogicservice.userblservice.ClientBLService;
import util.ResultMessage_For_User;
import vo.user.ClientVO;
import vo.user.MemberVO;

public class ClientController implements ClientBLService , Client2Manager {
	
	private Client client;
	
	public ClientController() throws RemoteException{
		client = new Client();
	}

	@Override
	public ClientVO showData(String clientID) throws RemoteException {
		return client.showData(clientID);
	}

	@Override
	public ResultMessage_For_User changeData(String clientID, String clientName, String contactWay) throws RemoteException{
		return client.changeData(clientID, clientName, contactWay);
	}

	@Override
	public ResultMessage_For_User Login(String clientID, String password) throws RemoteException{
		return client.Login(clientID, password);
	}

	@Override
	public ResultMessage_For_User Signup(ClientVO vo,  String password) throws RemoteException {
		return client.Signup(vo, password);
	}

	@Override
	public ResultMessage_For_User memberRegister(MemberVO vo)  throws RemoteException{
		return client.memberRegister(vo);
	}

	@Override
	public MemberVO showMemberData(String clientID) throws RemoteException{
		return client.showMemberData(clientID);
	}

	@Override
	public ResultMessage_For_User changeMemberData(MemberVO vo) throws RemoteException{
		return client.changeMemberData(vo);
	}

	
}
