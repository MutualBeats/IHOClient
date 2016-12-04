package bussinesslogicservice.userblservice;

import java.rmi.RemoteException;

import vo.user.StaffVO;

public interface StaffBLService {
	public StaffVO showData (String staffID) throws RemoteException;
}
