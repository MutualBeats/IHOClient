package bussinesslogic.usebl.marketer;

import java.rmi.RemoteException;

import dataservice.userdataservice.MarketerDataService;
import factory.datahelper.DataHelperFactory;
import po.user.MarketerPO;
import util.LengthOfID;
import util.ResultMessage_For_User;
import vo.user.MarketerVO;

public class Marketer {

	private MarketerDataService marketerDataService;
	
	public Marketer(){
		try{
			marketerDataService = DataHelperFactory.getDataFactoryHelperInstance().getMarketerDatabase();
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}
	
	/*
	 * UserID Invalid
	 * 
	 * Account Not Exist
	 * Password Wrong
	 * */
	public ResultMessage_For_User Login(String marketerID, String password) {
		if(marketerID.length()!=LengthOfID.getUserID())
			return ResultMessage_For_User.UserID_Invalid;
		
		ResultMessage_For_User result = ResultMessage_For_User.LoginSuccess;
		try {
			result = marketerDataService.find(marketerID, password);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	/* 
	 * Return null:
	 * 	UserID Invalid
	 * 	Account Not Exist
	 * */
	public MarketerVO showData(String marketerID) {
		if(marketerID.length()!=LengthOfID.getUserID())
			return null;
		
		MarketerPO po = new MarketerPO();
		try {
			po = marketerDataService.findData(marketerID);
		} catch (RemoteException e) {
			System.out.println(ResultMessage_For_User.GetDataFail);
			e.printStackTrace();
		}
		
		if(po==null)
			return null;
		
		MarketerVO vo;
		vo = new MarketerVO(po.getMarketerID(), po.getMarketername(), po.getTel_number());
		System.out.println(ResultMessage_For_User.GetDataSuccess);
		return vo;
	}
		
	/*
	 * UserName Invalid
	 */
	public ResultMessage_For_User changeData(MarketerVO vo) {
		int len = vo.marketername.length();
		if(len<LengthOfID.getMinUserName()||len>LengthOfID.getMaxUserName())
			return ResultMessage_For_User.UserName_Invalid;
		
		ResultMessage_For_User result = ResultMessage_For_User.UpdateSuccess;
		MarketerPO po = new MarketerPO();
		po.setMarketerID(vo.marketerID);
		po.setMarketername(vo.marketername);
		po.setTel_number(vo.contactWay);
		try {
			result = marketerDataService.updateData(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * UserID Invalid
	 * UserName Invalid
	 * 
	 * Account Exist
	 */
	public ResultMessage_For_User addMarketer(MarketerVO vo, String password) {
		if(vo.marketerID.length()!=LengthOfID.getUserID())
			return ResultMessage_For_User.UserID_Invalid;
		
		int len = vo.marketername.length();
		if(len<LengthOfID.getMinUserName()||len>LengthOfID.getMaxUserName())
			return ResultMessage_For_User.UserName_Invalid;

		ResultMessage_For_User result = ResultMessage_For_User.UpdateSuccess;
		MarketerPO po = new MarketerPO();
		po.setMarketerID(vo.marketerID);
		po.setMarketername(vo.marketername);
		po.setTel_number(vo.contactWay);
		try {
			result = marketerDataService.insert(po, password);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
}
