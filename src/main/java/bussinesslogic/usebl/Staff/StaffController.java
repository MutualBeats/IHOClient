package bussinesslogic.usebl.Staff;

import bussinesslogic.usebl.Manager.Entrust.Staff2Manager;
import bussinesslogicservice.userblservice.StaffBLService;
import util.ResultMessage;
import vo.StaffVO;

public class StaffController implements StaffBLService , Staff2Manager {
	
	@Override
	public ResultMessage Login(String ID, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StaffVO showData(String staffID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ResultMessage changeData(StaffVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addStaff(StaffVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
