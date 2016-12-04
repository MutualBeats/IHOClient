package bussinesslogic.userbl.client;

import java.rmi.RemoteException;

import bussinesslogic.userbl.manager.entrust.ClientInfoGet;
import bussinesslogicservice.userblservice.ClientBLService;
import util.resultmessage.ResultMessage_User;
import vo.user.ClientInfoChangeVO;
import vo.user.ClientVO;
import vo.user.MemberVO;

public class ClientController implements ClientBLService , ClientInfoGet {
	
	private Client client = new Client();

	@Override
	public ClientVO getClientInfo(String clientID) throws RemoteException {
		return client.getClientInfo(clientID);
	}

	@Override
	public ResultMessage_User changeClientInfo(ClientInfoChangeVO vo) {
		return client.changeClientInfo(vo);
	}


	@Override
	public ResultMessage_User registerMember(MemberVO vo) {
		return client.memberRegister(vo);
	}


	
}
