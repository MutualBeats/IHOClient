package bussinesslogic.usebl.staff;

import bussinesslogic.usebl.manager.entrust.Staff2Manager;
import bussinesslogicservice.userblservice.StaffBLService;
import util.ResultMessage_For_User;
import vo.user.StaffVO;

public class StaffController implements StaffBLService , Staff2Manager {
	
	private Staff staff = new Staff();

	@Override
	public ResultMessage_For_User Login(String staffID, String password) {
		return staff.Login(staffID, password);
	}

	@Override
	public StaffVO showData(String staffID) {
		return staff.showData(staffID);
	}
	
	@Override
	public ResultMessage_For_User changeData(StaffVO vo) {
		return staff.changeData(vo);
	}

	@Override
	public ResultMessage_For_User addStaff(StaffVO vo, String password) {
		return staff.addStaff(vo, password);
	}

}
