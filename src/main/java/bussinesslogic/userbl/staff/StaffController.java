package bussinesslogic.userbl.staff;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogic.userbl.manager.entrust.StaffManage;
import bussinesslogicservice.userblservice.StaffBLService;
import util.resultmessage.ResultMessage_User;
import vo.user.StaffChangeVO;
import vo.user.StaffVO;

public class StaffController implements StaffBLService , StaffManage {
	
	private Staff staff ;
	
	public StaffController() throws Exception{
		staff = new Staff();
	}

	@Override
	public StaffVO showData(String staffID) throws RemoteException {
		return staff.showData(staffID);
	}
	
	@Override
	public ResultMessage_User changeData(StaffChangeVO vo){
		return staff.changeData(vo);
	}

	@Override
	public ResultMessage_User addStaff(StaffVO registVO, String password)  {
		return staff.addStaff(registVO, password);
	}

	@Override
	public ArrayList<StaffVO> getStaffList() throws RemoteException {
		return staff.getStaffList();
	}


}
