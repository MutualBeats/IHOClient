package bussinesslogic.userbl.client;

import java.util.ArrayList;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogic.creditbl.Notify;
import bussinesslogic.orderbl.ClientInfo;
import bussinesslogic.userbl.manager.entrust.ClientInfoGet;
import bussinesslogicservice.userblservice.ClientBLService;
import util.exception.NetException;
import util.resultmessage.ResultMessage_User;
import vo.user.ClientInfoChangeVO;
import vo.user.ClientRegistVO;
import vo.user.ClientVO;
import vo.user.MemberVO;

public class ClientController implements ClientBLService, ClientInfoGet, ClientInfo, Notify{
	
	private Client client;
	
	public ClientController() throws NetException {
		 client = new Client(ControllerFactory.getCreditRegister());
	}
	
	@Override
	public ClientVO getClientInfo(String clientID) throws NetException {
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

	@Override
	public ArrayList<ClientVO> getClientList() throws NetException {
		return client.getClientList();
	}

	@Override
	public ResultMessage_User regist(ClientRegistVO info) {
		return client.regist(info);
	}

	@Override
	public void notifyCreditChange(String clientID, int credit) {
		client.updateCacheCredit(clientID, credit);
	}
	


	
}
