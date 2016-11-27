package bussinesslogic.usebl.staff;

import java.rmi.RemoteException;

import bussinesslogic.usebl.manager.entrust.Staff2Manager;
import bussinesslogicservice.userblservice.StaffBLService;
import util.ResultMessage_For_User;
import vo.user.StaffVO;

public class StaffController implements StaffBLService , Staff2Manager {
	
	private Staff staff;
	
	public StaffController() throws RemoteException{
		staff = new Staff();
	}

	@Override
	public ResultMessage_For_User Login(String staffID, String password) throws RemoteException {
		return staff.Login(staffID, password);
	}

	@Override
	public StaffVO showData(String staffID) throws RemoteException {
		return staff.showData(staffID);
	}
	
	@Override
	public ResultMessage_For_User changeData(StaffVO vo) throws RemoteException {
		return staff.changeData(vo);
	}

	@Override
	public ResultMessage_For_User addStaff(StaffVO vo, String password) throws RemoteException {
		return staff.addStaff(vo, password);
	}

}
