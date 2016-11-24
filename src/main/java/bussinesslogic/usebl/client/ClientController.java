package bussinesslogic.usebl.client;

import bussinesslogic.usebl.manager.entrust.Client2Manager;
import bussinesslogicservice.userblservice.ClientBLService;
import util.ResultMessage_For_User;
import vo.user.ClientVO;
import vo.user.MemberVO;

public class ClientController implements ClientBLService , Client2Manager {
	
	private Client client = new Client();

	@Override
	public ClientVO showData(String clientID) {
		return client.showData(clientID);
	}

	@Override
	public ResultMessage_For_User changeData(String clientID, String clientName, String contactWay) {
		return client.changeData(clientID, clientName, contactWay);
	}

	@Override
	public ResultMessage_For_User Login(String clientID, String password) {
		return client.Login(clientID, password);
	}

	@Override
	public ResultMessage_For_User Signup(ClientVO vo,  String password) {
		return client.Signup(vo, password);
	}

	@Override
	public ResultMessage_For_User memberRegister(MemberVO vo) {
		return client.memberRegister(vo);
	}

	@Override
	public MemberVO showMemberData(String clientID) {
		return client.showMemberData(clientID);
	}

	@Override
	public ResultMessage_For_User changeMemberData(MemberVO vo) {
		return client.changeMemberData(vo);
	}

	
}
