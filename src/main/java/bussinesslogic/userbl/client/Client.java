package bussinesslogic.userbl.client;

import java.rmi.RemoteException;

import dataservice.userdataservice.ClientDataService;
import factory.datahelper.DataHelperFactory;
import po.user.ClientPO;
import po.user.MemberPO;
import util.MemberType;
import util.ResultMessage_For_User;
import vo.user.ClientVO;
import vo.user.MemberVO;

public class Client {

	private ClientDataService clientDataService;
	
	public Client() throws RemoteException{
		clientDataService = DataHelperFactory.getDataFactoryHelperInstance().getClientDatabase();
	}

	/*
	 * 
	 */
	public ClientVO showData(String clientID) throws RemoteException {
		ClientPO po = new ClientPO();

		po = clientDataService.findData(clientID);

		ClientVO vo;
		vo = new ClientVO(po.getClientID(), po.getClientName(), po.getContactWay(), po.getCredit(), 
				po.getMemberType(), po.getLevel(), po.getMemberMessage());
		System.out.println(ResultMessage_For_User.GetDataSuccess);
		return vo;
	}

	public ResultMessage_For_User changeData(String clientID, String clientName, String contactWay) throws RemoteException {
		ResultMessage_For_User result = ResultMessage_For_User.UpdateSuccess;

		result = clientDataService.updateData(clientID,clientName,contactWay);

		return result;
	}

	public ResultMessage_For_User Login(String clientID, String password) throws RemoteException {
		ResultMessage_For_User result = ResultMessage_For_User.LoginSuccess;

		result = clientDataService.find(clientID, password);

		return result;
	}

	public ResultMessage_For_User Signup(ClientVO vo, String password) throws RemoteException {
		ResultMessage_For_User result = ResultMessage_For_User.AddSucccess;
		ClientPO po = new ClientPO();
		po.setClientID(vo.clientID);
		po.setClientName(vo.clientName);
		po.setContactWay(vo.contactWay);
		po.setCredit(vo.credit);
		po.setMemberType(vo.memberType);
		po.setLevel(vo.level);
		po.setMemberMessage(vo.memberMessage);
		
		result = clientDataService.insert(po, password);

		return result;
	}

	public ResultMessage_For_User memberRegister(MemberVO vo) throws RemoteException {
		ResultMessage_For_User result = ResultMessage_For_User.BusinessRegisterSuccess;
		
		//是否已存在会员
		MemberType type = vo.memberType;
		MemberType existType = new Client().showMemberData(vo.clientID).memberType;
		if(existType!=MemberType.Not)
			if(existType==MemberType.Enterprise)
				return ResultMessage_For_User.BusinessMember_Exist;		
			else
				return ResultMessage_For_User.OriginalMember_Exist;	
		
		MemberPO po = new MemberPO();
		po.setClientID(vo.clientID);
		po.setMemberType(vo.memberType);
		po.setLevel(vo.level);
		po.setMemberMessage(vo.memberMessage);

		result = clientDataService.insertMember(po);

		return result;
	}


	public MemberVO showMemberData(String clientID) throws RemoteException {
		MemberPO po = new MemberPO();

		po = clientDataService.findMemberData(clientID);

		MemberVO vo;
		vo = new MemberVO(po.getClientID(),po.getMemberType(),po.getLevel(),po.getMemberMessage());
		System.out.println(ResultMessage_For_User.GetDataSuccess);
		return vo;
	}

	public ResultMessage_For_User changeMemberData(MemberVO vo) throws RemoteException {
		ResultMessage_For_User result = ResultMessage_For_User.BusinessRegisterSuccess;
		MemberPO po = new MemberPO();
		po.setClientID(vo.clientID);
		po.setMemberType(vo.memberType);
		po.setLevel(vo.level);
		po.setMemberMessage(vo.memberMessage);

		result = clientDataService.updateMemberData(po);

		return result;
	}

}
