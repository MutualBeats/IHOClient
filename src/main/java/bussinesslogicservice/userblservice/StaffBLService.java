package bussinesslogicservice.userblservice;

import java.rmi.RemoteException;

import util.resultmessage.ResultMessage_User;
import vo.user.StaffVO;

public interface StaffBLService {
	/*
	 * 登录
	 */
	public ResultMessage_User Login(String staffID, String password);
	/*
	 * 获取酒店工作人员信息
	 */
	public StaffVO showData (String staffID) throws RemoteException;
}
