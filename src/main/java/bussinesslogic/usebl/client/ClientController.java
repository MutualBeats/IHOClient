package bussinesslogic.usebl.client;

import bussinesslogic.usebl.manager.entrust.Client2Manager;
import bussinesslogicservice.userblservice.ClientBLService;
import util.ResultMessage;
import vo.ClientVO;

public class ClientController implements ClientBLService , Client2Manager {
	
	private Client client;
	
	ClientController(){
		client = new Client();
	}

	@Override
	public ClientVO showData(String clientID) {
		return client.showData(clientID);
	}

	@Override
	public ResultMessage changeData(ClientVO vo) {
		return client.changeData(vo);
	}

	@Override
	public ResultMessage Login(String ID, String password) {
		return client.Login(ID, password);
	}

	@Override
	public ResultMessage Signup(ClientVO vo,  String password) {
		return client.Signup(vo, password);
	}

}
