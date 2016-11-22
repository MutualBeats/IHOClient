package bussinesslogic.usebl.client;

import java.util.ArrayList;

import bussinesslogic.usebl.manager.entrust.Client2Manager;
import bussinesslogicservice.userblservice.ClientBLService;
import util.ResultMessage;
import vo.ClientVO;

public class ClientController implements ClientBLService , Client2Manager {
	
	private Client client = new Client();

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

	@Override
	public ResultMessage businessRegister(ClientVO vo) {
		return client.businessRegister(vo);
	}

	@Override
	public ResultMessage originalRegister(ClientVO vo) {
		return client.originalRegister(vo);
	}

	@Override
	public ClientVO get(String memberID) {
		return client.get(memberID);
	}

	@Override
	public ResultMessage levelUpdate(ArrayList<Integer> levelList, int level) {
		return client.levelUpdate(levelList, level);
	}

	@Override
	public ResultMessage update(String memberID, ClientVO vo) {
		return client.update(memberID, vo);
	}

	
}
