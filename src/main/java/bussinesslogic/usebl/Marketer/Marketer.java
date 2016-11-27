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
	
	public Marketer() throws RemoteException{
		marketerDataService = DataHelperFactory.getDataFactoryHelperInstance().getMarketerDatabase();
	}
	
	/*
	 * UserID Invalid
	 * 
	 * Account Not Exist
	 * Password Wrong
	 * */
	public ResultMessage_For_User Login(String marketerID, String password) throws RemoteException {
		if(marketerID.length()!=LengthOfID.getUserID())
			return ResultMessage_For_User.UserID_Invalid;
		
		ResultMessage_For_User result = ResultMessage_For_User.LoginSuccess;
		
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
	public ResultMessage_For_User changeData(MarketerVO vo) throws RemoteException {
		int len = vo.marketername.length();
		if(len<LengthOfID.getMinUserName()||len>LengthOfID.getMaxUserName())
			return ResultMessage_For_User.UserName_Invalid;
		
		ResultMessage_For_User result = ResultMessage_For_User.UpdateSuccess;
		MarketerPO po = new MarketerPO();
		po.setMarketerID(vo.marketerID);
		po.setMarketername(vo.marketername);
		po.setTel_number(vo.contactWay);

		result = marketerDataService.updateData(po);
		
		return result;
	}

	/*
	 * UserID Invalid
	 * UserName Invalid
	 * 
	 * Account Exist
	 */
	public ResultMessage_For_User addMarketer(MarketerVO vo, String password) throws RemoteException {
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

		result = marketerDataService.insert(po, password);

		return result;
	}
}
