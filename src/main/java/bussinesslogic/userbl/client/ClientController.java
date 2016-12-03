package bussinesslogic.userbl.client;

import java.rmi.RemoteException;

import bussinesslogic.userbl.manager.entrust.Client2Manager;
import bussinesslogicservice.userblservice.ClientBLService;
import util.resultmessage.ResultMessage_User;
import vo.user.ClientVO;
import vo.user.MemberVO;

public class ClientController implements ClientBLService , Client2Manager {
	
	private Client client = new Client();

	@Override
	public ClientVO showData(String clientID) throws RemoteException {
		return client.showData(clientID);
	}

	@Override
	public ResultMessage_User changeData(String clientID, String clientName, String contactWay){
		return client.changeData(clientID, clientName, contactWay);
	}

	@Override
	public ResultMessage_User Login(String clientID, String password) {
		return client.Login(clientID, password);
	}

	@Override
	public ResultMessage_User Signup(String clientID, String clientName, String contactWay,  String password){
		return client.Signup(clientID, clientName, contactWay, password);
	}

	@Override
	public ResultMessage_User memberRegister(MemberVO vo) throws RemoteException {
		return client.memberRegister(vo);
	}

	@Override
	public MemberVO showMemberData(String clientID) throws RemoteException{
		return client.showMemberData(clientID);
	}

	@Override
	public ResultMessage_User changeMemberData(MemberVO vo){
		return client.changeMemberData(vo);
	}

	
}
