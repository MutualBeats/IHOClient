package bussinesslogic.usebl.staff;

import bussinesslogic.usebl.manager.entrust.Staff2Manager;
import bussinesslogicservice.userblservice.StaffBLService;
import util.ResultMessage;
import vo.StaffVO;

public class StaffController implements StaffBLService , Staff2Manager {
	
	private Staff staff;
	
	StaffController(){
		staff = new Staff();
	}
	
	@Override
	public ResultMessage Login(String ID, String password) {
		return staff.Login(ID, password);
	}

	@Override
	public StaffVO showData(String staffID) {
		return staff.showData(staffID);
	}
	
	@Override
	public ResultMessage changeData(StaffVO vo) {
		return staff.changeData(vo);
	}

	@Override
	public ResultMessage addStaff(StaffVO vo, String password) {
		return staff.addStaff(vo, password);
	}

}
