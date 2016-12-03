package bussinesslogicservice.userblservice;

import java.rmi.RemoteException;

import util.resultmessage.ResultMessage_User;
import vo.user.MarketerVO;

public interface MarketerBLService {
	/*
	 * 登录
	 */
	public ResultMessage_User Login(String marketerID, String password);
	/*
	 * 获取网站营销人员信息
	 */
	public MarketerVO showData (String marketerID) throws RemoteException;
}
