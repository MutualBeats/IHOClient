package bussinesslogic.usebl.client;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.userdataservice.ClientDataService;
import po.ClientPO;
import util.ResultMessage_For_Stub;
import util.ResultMessage_For_User;
import vo.user.ClientVO;

public class Client {
	
	private ClientDataService clientDataService;

	public ClientVO showData(String clientID) {
		ClientPO po = new ClientPO();
		try {
			po = clientDataService.findData(clientID);
		} catch (RemoteException e) {
			System.out.println(ResultMessage_For_User.GetDataFail);
			e.printStackTrace();
		}
		ClientVO vo;
		vo = new ClientVO(po.getClientID(),po.getClientName(),po.getContactWay(),po.getCredit(),
				po.getMemberType(),po.getLevel(),po.getMemberMessage());
		System.out.println(ResultMessage_For_User.GetDataSuccess);
		return vo;
	}

	public ResultMessage_For_User changeData(ClientVO vo) {
		ClientPO po;
		po = new ClientPO();
		po.setClientID(vo.clientID);
		po.setClientName(vo.clientName);
		po.setContactWay(vo.contactWay);
		po.setCredit(vo.credit);
		po.setMemberType(vo.memberType);
		po.setLevel(vo.level);
		po.setMemberMessage(vo.memberMessage);
		
		ResultMessage_For_User result = ResultMessage_For_User.UpdateSuccess;
		try {
			result = clientDataService.updateData(po);
		} catch (RemoteException e) {
			System.out.println(ResultMessage_For_User.UpdateFail);
			e.printStackTrace();
		}
		System.out.println(ResultMessage_For_User.UpdateSuccess);
		return result;
	}

	public ResultMessage_For_User Login(String ID, String password) {
		ResultMessage_For_User result = ResultMessage_For_User.LoginSuccess;
		try {
			result = clientDataService.find(ID, password);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ResultMessage_For_User Signup(ClientVO vo, String password) {
		ResultMessage_For_User result = ResultMessage_For_User.AddSucccess;
		ClientPO po;
		po = new ClientPO();
		po.setClientID(vo.clientID);
		po.setClientName(vo.clientName);
		po.setContactWay(vo.contactWay);
		po.setCredit(vo.credit);
		po.setMemberType(vo.memberType);
		po.setLevel(vo.level);
		po.setMemberMessage(vo.memberMessage);
		try {
			result = clientDataService.insert(po, password);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ResultMessage_For_User businessRegister(ClientVO vo) {
		ResultMessage_For_User result = ResultMessage_For_User.BusinessRegisterSuccess;
		ClientPO po;
		po = new ClientPO();
		po.setClientID(vo.clientID);
		po.setClientName(vo.clientName);
		po.setContactWay(vo.contactWay);
		po.setCredit(vo.credit);
		po.setMemberType(vo.memberType);
		po.setLevel(vo.level);
		po.setMemberMessage(vo.memberMessage);
		try {
			result = clientDataService.businessRegister(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ResultMessage_For_User originalRegister(ClientVO vo) {
		ResultMessage_For_User result = ResultMessage_For_User.OriginalRegisterSuccess;
		ClientPO po;
		po = new ClientPO();
		po.setClientID(vo.clientID);
		po.setClientName(vo.clientName);
		po.setContactWay(vo.contactWay);
		po.setCredit(vo.credit);
		po.setMemberType(vo.memberType);
		po.setLevel(vo.level);
		po.setMemberMessage(vo.memberMessage);
		try {
			result = clientDataService.originalRegister(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ClientVO get(String memberID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage_For_User levelUpdate(ArrayList<Integer> levelList, int level) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage_For_User update(String memberID, ClientVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
