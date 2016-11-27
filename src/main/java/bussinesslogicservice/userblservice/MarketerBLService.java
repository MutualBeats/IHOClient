package bussinesslogicservice.userblservice;

import java.rmi.RemoteException;

import util.ResultMessage_For_User;
import vo.user.MarketerVO;

public interface MarketerBLService {
	/*
	 * 登录
	 */
	public ResultMessage_For_User Login(String marketerID, String password) throws RemoteException;
	/*
	 * 获取网站营销人员信息
	 */
	public MarketerVO showData (String marketerID) throws RemoteException;
}
