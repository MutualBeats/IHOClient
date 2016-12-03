package bussinesslogic.userbl.client;

import java.rmi.RemoteException;

import dataservice.userdataservice.ClientDataService;
import factory.datahelper.DataHelperFactory;
import po.user.ClientPO;
import po.user.MemberPO;
import util.resultmessage.ResultMessage_User;
import util.user.MemberType;
import vo.user.ClientVO;
import vo.user.MemberVO;

public class Client {

	private ClientDataService clientDataService;
	
	public Client() {
		try {
			clientDataService = DataHelperFactory.getDataFactoryHelperInstance().getClientDatabase();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/* 
	 * Return null:
	 * 	-UserID Invalid
	 * 	Account Not Exist
	 * */
	public ClientVO showData(String clientID) throws RemoteException {
//		if(clientID.length()!=LengthOfID.getUserID())
//			return null;
	
		ClientPO po = new ClientPO();

		po = clientDataService.findData(clientID);
		
		if(po==null)
			return null;

		ClientVO vo;
		vo = new ClientVO(po.getClientID(), po.getClientName(), po.getContactWay(), po.getCredit(), 
				po.getMemberType(), po.getLevel(), po.getMemberMessage());
		System.out.println(ResultMessage_User.GetDataSuccess);
		return vo;
	}

	/*
	 * -userName Invalid
	 */
	public ResultMessage_User changeData(String clientID, String clientName, String contactWay)  {
//		int len = clientName.length();
//		if(len<LengthOfID.getMinUserName()||len>LengthOfID.getMaxUserName())
//			return ResultMessage_User.UserName_Invalid;
		
		ResultMessage_User result = ResultMessage_User.UpdateSuccess;

		try {
			result = clientDataService.updateData(clientID,clientName,contactWay);
		} catch (RemoteException e) {
			return ResultMessage_User.Net_Error;
		}

		return result;
	}

	/*
	 *-UserID Invalid
	 * 
	 * Account Not Exist
	 * Password Wrong
	 * */
	public ResultMessage_User Login(String clientID, String password){
//		if(clientID.length()!=LengthOfID.getUserID())
//			return ResultMessage_User.UserID_Invalid;
		
		ResultMessage_User result = ResultMessage_User.LoginSuccess;

		try {
			result = clientDataService.find(clientID, password);
		} catch (RemoteException e) {
			return ResultMessage_User.Net_Error;
		}

		return result;
	}

	/*
	 *-UserID Invalid
	 * -UserName Invalid
	 * 
	 * Account Exist
	 */
	public ResultMessage_User Signup(String clientID, String clientName, String contactWay, String password)  {
//		if(clientID.length()!=LengthOfID.getUserID())
//			return ResultMessage_User.UserID_Invalid;
//		
//		int len = clientName.length();
//		if(len<LengthOfID.getMinUserName()||len>LengthOfID.getMaxUserName())
//			return ResultMessage_User.UserName_Invalid;
		
		ResultMessage_User result = ResultMessage_User.AddSucccess;
		
		ClientPO po = new ClientPO();
		po.setClientID(clientID);
		po.setClientName(clientName);
		po.setContactWay(contactWay);
	
		po.setCredit(100);
		po.setMemberType(MemberType.Not);
		po.setLevel(0);
		po.setMemberMessage(null);
		
		try {
			result = clientDataService.insert(po, password);
		} catch (RemoteException e) {
			return ResultMessage_User.Net_Error;
		}

		return result;
	}

	/*
	 * Member Exist
	 */
	public ResultMessage_User memberRegister(MemberVO vo) throws RemoteException {
		ResultMessage_User result = ResultMessage_User.BusinessRegisterSuccess;
		
		MemberType existType = new Client().showMemberData(vo.clientID).memberType;
		if(existType!=MemberType.Not)
			if(existType==MemberType.Enterprise)
				return ResultMessage_User.BusinessMember_Exist;		
			else
				return ResultMessage_User.OriginalMember_Exist;	
		
		MemberPO po = new MemberPO();
		
		po.setClientID(vo.clientID);
		po.setMemberType(vo.memberType);
		po.setLevel(vo.level);
		po.setMemberMessage(vo.memberMessage);

		try {
			result = clientDataService.insertMember(po);
		} catch (RemoteException e) {
			return ResultMessage_User.Net_Error;
		}

		return result;
	}

	/*
	 *------NO Exception-----
	 */
	public MemberVO showMemberData(String clientID) throws RemoteException {
		MemberPO po = new MemberPO();

		po = clientDataService.findMemberData(clientID);

		MemberVO vo;
		vo = new MemberVO(po.getClientID(),po.getMemberType(),po.getLevel(),po.getMemberMessage());
		return vo;
	}

	/*
	 *------NO Exception------
	 */
	public ResultMessage_User changeMemberData(MemberVO vo){
		ResultMessage_User result = ResultMessage_User.UpdateSuccess;
		MemberPO po = new MemberPO();
		po.setClientID(vo.clientID);
		po.setMemberType(vo.memberType);
		po.setLevel(vo.level);
		po.setMemberMessage(vo.memberMessage);

		try {
			result = clientDataService.updateMemberData(po);
		} catch (RemoteException e) {
			return ResultMessage_User.Net_Error;
		}

		return result;
	}

}
