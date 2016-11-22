package bussinesslogic.usebl.client;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.userdataservice.ClientDataService;
import po.ClientPO;
import util.ResultMessage;
import vo.ClientVO;

public class Client {
	
	private ClientDataService clientDataService;

	public ClientVO showData(String clientID) {
		ClientPO po;
		try {
			po = clientDataService.findData(clientID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
//		ClientVO vo = new ClientVO(po.getClientID(),po.getClientname(),po.getTel_number(),po.getCredit(),po.getMember());
		return null;
	}

	public ResultMessage changeData(ClientVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage Login(String ID, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage Signup(ClientVO vo, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ResultMessage businessRegister(ClientVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage originalRegister(ClientVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ClientVO get(String memberID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage levelUpdate(ArrayList<Integer> levelList, int level) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage update(String memberID, ClientVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
