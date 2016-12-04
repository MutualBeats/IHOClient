package bussinesslogicservice.userblservice;

import java.rmi.RemoteException;

import vo.user.StaffVO;

public interface StaffBLService {
	/*
	 * 获取酒店工作人员信息
	 */
	public StaffVO showData (String staffID) throws RemoteException;
}
