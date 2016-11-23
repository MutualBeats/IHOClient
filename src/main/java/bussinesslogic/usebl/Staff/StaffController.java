package bussinesslogic.usebl.staff;

import bussinesslogic.usebl.manager.entrust.Staff2Manager;
import bussinesslogicservice.userblservice.StaffBLService;
import util.ResultMessage_For_Stub;
import vo.StaffVO;

public class StaffController implements StaffBLService , Staff2Manager {
	
	private Staff staff = new Staff();

	@Override
	public ResultMessage_For_Stub Login(String ID, String password) {
		return staff.Login(ID, password);
	}

	@Override
	public StaffVO showData(String staffID) {
		return staff.showData(staffID);
	}
	
	@Override
	public ResultMessage_For_Stub changeData(StaffVO vo) {
		return staff.changeData(vo);
	}

	@Override
	public ResultMessage_For_Stub addStaff(StaffVO vo, String password) {
		return staff.addStaff(vo, password);
	}

}
