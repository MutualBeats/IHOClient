package bussinesslogic.usebl.client;

import java.rmi.RemoteException;

import dataservice.userdataservice.ClientDataService;
import po.ClientPO;
import po.MemberPO;
import util.ResultMessage_For_User;
import vo.user.ClientVO;
import vo.user.MemberVO;

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
		vo = new ClientVO(po.getClientID(), po.getClientName(), po.getContactWay(), po.getCredit(), 
				po.getMemberType(), po.getLevel(), po.getMemberMessage());
		System.out.println(ResultMessage_For_User.GetDataSuccess);
		return vo;
	}

	public ResultMessage_For_User changeData(String clientID, String clientName, String contactWay) {
		ResultMessage_For_User result = ResultMessage_For_User.UpdateSuccess;
		try {
			result = clientDataService.updateData(clientID,clientName,contactWay);
		} catch (RemoteException e) {
			System.out.println(ResultMessage_For_User.UpdateFail);
			e.printStackTrace();
		}
		return result;
	}

	public ResultMessage_For_User Login(String clientID, String password) {
		ResultMessage_For_User result = ResultMessage_For_User.LoginSuccess;
		try {
			result = clientDataService.find(clientID, password);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ResultMessage_For_User Signup(ClientVO vo, String password) {
		ResultMessage_For_User result = ResultMessage_For_User.AddSucccess;
		ClientPO po = new ClientPO();
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

	public ResultMessage_For_User memberRegister(MemberVO vo) {
		ResultMessage_For_User result = ResultMessage_For_User.BusinessRegisterSuccess;
		MemberPO po = new MemberPO();
		po.setClientID(vo.clientID);
		po.setMemberType(vo.memberType);
		po.setLevel(vo.level);
		po.setMemberMessage(vo.memberMessage);
		try {
			result = clientDataService.insertMember(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}


	public MemberVO showMemberData(String clientID) {
		MemberPO po = new MemberPO();
		try {
			po = clientDataService.findMemberData(clientID);
		} catch (RemoteException e) {
			System.out.println(ResultMessage_For_User.GetDataFail);
			e.printStackTrace();
		}
		MemberVO vo;
		vo = new MemberVO(po.getClientID(),po.getMemberType(),po.getLevel(),po.getMemberMessage());
		System.out.println(ResultMessage_For_User.GetDataSuccess);
		return vo;
	}

	public ResultMessage_For_User changeMemberData(MemberVO vo) {
		ResultMessage_For_User result = ResultMessage_For_User.BusinessRegisterSuccess;
		MemberPO po = new MemberPO();
		po.setClientID(vo.clientID);
		po.setMemberType(vo.memberType);
		po.setLevel(vo.level);
		po.setMemberMessage(vo.memberMessage);
		try {
			result = clientDataService.updateMemberData(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

}
