package bussinesslogicservice.userblservice;

import java.rmi.RemoteException;

import util.ResultMessage_For_User;
import vo.user.StaffVO;

public interface StaffBLService {
	/*
	 * 登录
	 */
	public ResultMessage_For_User Login(String staffID, String password) throws RemoteException;
	/*
	 * 获取酒店工作人员信息
	 */
	public StaffVO showData (String staffID) throws RemoteException;
}
