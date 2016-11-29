package bussinesslogic.userbl.marketer;

import java.rmi.RemoteException;

import dataservice.userdataservice.MarketerDataService;
import factory.datahelper.DataHelperFactory;
import po.user.MarketerPO;
import util.LengthOfID;
import util.resultmessage.ResultMessage_User;
import vo.user.MarketerVO;

public class Marketer {

	private MarketerDataService marketerDataService;
	
	public Marketer() throws RemoteException{
		marketerDataService = DataHelperFactory.getDataFactoryHelperInstance().getMarketerDatabase();
	}
	
	/*
	 * UserID Invalid
	 * 
	 * Account Not Exist
	 * Password Wrong
	 * */
	public ResultMessage_User Login(String marketerID, String password) throws RemoteException {
		if(marketerID.length()!=LengthOfID.getUserID())
			return ResultMessage_User.UserID_Invalid;
		
		ResultMessage_User result = ResultMessage_User.LoginSuccess;
		
		result = marketerDataService.find(marketerID, password);

		return result;
	}

	/* 
	 * Return null:
	 * 	UserID Invalid
	 * 	Account Not Exist
	 * */
	public MarketerVO showData(String marketerID) throws RemoteException {
		if(marketerID.length()!=LengthOfID.getUserID())
			return null;
		
		MarketerPO po = new MarketerPO();

		po = marketerDataService.findData(marketerID);
		
		if(po==null)
			return null;
		
		MarketerVO vo;
		vo = new MarketerVO(po.getMarketerID(), po.getMarketername(), po.getTel_number());
		return vo;
	}
		
	/*
	 * UserName Invalid
	 */
	public ResultMessage_User changeData(MarketerVO vo) throws RemoteException {
		int len = vo.marketerName.length();
		if(len<LengthOfID.getMinUserName()||len>LengthOfID.getMaxUserName())
			return ResultMessage_User.UserName_Invalid;
		
		ResultMessage_User result = ResultMessage_User.UpdateSuccess;
		MarketerPO po = new MarketerPO();
		po.setMarketerID(vo.marketerID);
		po.setMarketername(vo.marketerName);
		po.setTel_number(vo.contactWay);

		result = marketerDataService.updateData(po);
		
		return result;
	}

	/*
	 * UserName Invalid
	 */
	public ResultMessage_User addMarketer(String marketerName, String contactWay, String password) throws RemoteException {
		int len = marketerName.length();
		if(len<LengthOfID.getMinUserName()||len>LengthOfID.getMaxUserName())
			return ResultMessage_User.UserName_Invalid;
		
		//TODO get ID
		String ID = null;

		ResultMessage_User result = ResultMessage_User.UpdateSuccess;
		MarketerPO po = new MarketerPO();
		//TODO
		po.setMarketerID("");
		po.setMarketername(marketerName);
		po.setTel_number(contactWay);

		result = marketerDataService.insert(po, password);

		return result;
	}
}
