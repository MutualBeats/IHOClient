package bussinesslogic.userbl.marketer;

import java.rmi.RemoteException;

import dataservice.userdataservice.MarketerDataService;
import factory.datahelper.DataHelperFactory;
import po.user.MarketerPO;
import util.resultmessage.ResultMessage_User;
import vo.user.MarketerVO;

public class Marketer {

	private MarketerDataService marketerDataService;
	
	public Marketer(){
		try {
			marketerDataService = DataHelperFactory.getDataFactoryHelperInstance().getMarketerDatabase();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * -UserID Invalid
	 * 
	 * Account Not Exist
	 * Password Wrong
	 * */
	public ResultMessage_User Login(String marketerID, String password){
//		if(marketerID.length()!=LengthOfID.getUserID())
//			return ResultMessage_User.UserID_Invalid;
		
		ResultMessage_User result = ResultMessage_User.LoginSuccess;
		
		try {
			result = marketerDataService.find(marketerID, password);
		} catch (RemoteException e) {
			return ResultMessage_User.Net_Error;
		}

		return result;
	}

	/* 
	 * Return null:
	 * 	-UserID Invalid
	 * 	Account Not Exist
	 * */
	public MarketerVO showData(String marketerID) throws RemoteException {
//		if(marketerID.length()!=LengthOfID.getUserID())
//			return null;
		
		MarketerPO po = new MarketerPO();

		po = marketerDataService.findData(marketerID);
		
		if(po==null)
			return null;
		
		MarketerVO vo;
		vo = new MarketerVO(po.getMarketerID(), po.getMarketername(), po.getTel_number());
		return vo;
	}
		
	/*
	 * -UserName Invalid
	 */
	public ResultMessage_User changeData(MarketerVO vo) {
//		int len = vo.marketerName.length();
//		if(len<LengthOfID.getMinUserName()||len>LengthOfID.getMaxUserName())
//			return ResultMessage_User.UserName_Invalid;
		
		ResultMessage_User result = ResultMessage_User.UpdateSuccess;
		MarketerPO po = new MarketerPO();
		po.setMarketerID(vo.marketerID);
		po.setMarketername(vo.marketerName);
		po.setTel_number(vo.contactWay);

		try {
			result = marketerDataService.updateData(po);
		} catch (RemoteException e) {
			return ResultMessage_User.Net_Error;
		}
		
		return result;
	}

	/*
	 * -UserName Invalid
	 */
	public ResultMessage_User addMarketer(MarketerVO vo, String password) {
//		int len = vo.marketerName.length();
//		if(len<LengthOfID.getMinUserName()||len>LengthOfID.getMaxUserName())
//			return ResultMessage_User.UserName_Invalid;

		ResultMessage_User result = ResultMessage_User.AddSucccess;
		MarketerPO po = new MarketerPO();
		po.setMarketerID(vo.marketerID);
		po.setMarketername(vo.marketerName);
		po.setTel_number(vo.contactWay);

		try {
			result = marketerDataService.insert(po, password);
		} catch (RemoteException e) {
			return ResultMessage_User.Net_Error;
		}

		return result;
	}
}
