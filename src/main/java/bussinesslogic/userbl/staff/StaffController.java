package bussinesslogic.userbl.staff;

import java.rmi.RemoteException;

import bussinesslogic.userbl.manager.entrust.Staff2Manager;
import bussinesslogicservice.userblservice.StaffBLService;
import util.resultmessage.ResultMessage_User;
import vo.user.StaffVO;

public class StaffController implements StaffBLService , Staff2Manager {
	
	private Staff staff;
	
	public StaffController() throws RemoteException{
		staff = new Staff();
	}

	@Override
	public ResultMessage_User Login(String staffID, String password) throws RemoteException {
		return staff.Login(staffID, password);
	}

	@Override
	public StaffVO showData(String staffID) throws RemoteException {
		return staff.showData(staffID);
	}
	
	@Override
	public ResultMessage_User changeData(StaffVO vo) throws RemoteException {
		return staff.changeData(vo);
	}

	@Override
	public ResultMessage_User addStaff(String staffName, String hotelID, String password) throws RemoteException {
		return staff.addStaff(staffName, hotelID, password);
	}

}
