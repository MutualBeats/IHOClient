package bussinesslogic.usebl.marketer;

import java.rmi.RemoteException;

import dataservice.userdataservice.MarketerDataService;
import util.ResultMessage_For_User;
import vo.user.MarketerVO;

public class Marketer {
	
	private MarketerDataService marketerDataService;
	
	public ResultMessage_For_User Login(String ID, String password) {
		ResultMessage_For_User result = ResultMessage_For_User.LoginSuccess;
		try {
			result = marketerDataService.find(ID, password);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public MarketerVO showData(String marketerID) {
		// TODO Auto-generated method stub
		return null;
	}
	public ResultMessage_For_User changeData(MarketerVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	public ResultMessage_For_User addMarketer(MarketerVO vo, String password) {
		// TODO Auto-generated method stub
		return null;
	}
}
