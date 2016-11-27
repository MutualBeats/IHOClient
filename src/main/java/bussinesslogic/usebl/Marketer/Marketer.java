package bussinesslogic.usebl.marketer;

import java.rmi.RemoteException;

import dataservice.userdataservice.MarketerDataService;
import factory.datahelper.DataHelperFactory;
import po.MarketerPO;
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
		int len = marketerID.length();
		if(len<8||len>16)
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
		int len = marketerID.length();
		if(len<8||len>16)
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
	 * Tel Invalid
	 */
	public ResultMessage_For_User changeData(MarketerVO vo) {
		int len = vo.marketername.length();
		if(len<8||len>16)
			return ResultMessage_For_User.UserName_Invalid;
		
		if(vo.tel_number.length()!=11)
			return ResultMessage_For_User.Tel_Invalid;
		
		ResultMessage_For_User result = ResultMessage_For_User.UpdateSuccess;
		MarketerPO po = new MarketerPO();
		po.setMarketerID(vo.marketerID);
		po.setMarketername(vo.marketername);
		po.setTel_number(vo.tel_number);
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
	 * Tel Invalid
	 * 
	 * Account Exist
	 */
	public ResultMessage_For_User addMarketer(MarketerVO vo, String password) {
		int lenOfID = vo.marketerID.length();
		if(lenOfID<8||lenOfID>16)
			return ResultMessage_For_User.UserID_Invalid;
		
		int lenOfName = vo.marketername.length();
		if(lenOfName<8||lenOfName>16)
			return ResultMessage_For_User.UserName_Invalid;
		
		if(vo.tel_number.length()!=11)
			return ResultMessage_For_User.Tel_Invalid;
		
		ResultMessage_For_User result = ResultMessage_For_User.UpdateSuccess;
		MarketerPO po = new MarketerPO();
		po.setMarketerID(vo.marketerID);
		po.setMarketername(vo.marketername);
		po.setTel_number(vo.tel_number);
		try {
			result = marketerDataService.insert(po, password);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
}
