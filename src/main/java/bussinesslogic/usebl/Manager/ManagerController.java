package bussinesslogic.usebl.manager;

import bussinesslogicservice.userblservice.ManagerBLService;
import util.ResultMessage_For_Stub;
import util.ResultMessage_For_User;
import vo.user.ClientVO;
import vo.user.MarketerVO;
import vo.user.StaffVO;

public class ManagerController implements ManagerBLService {
	
	private Manager manager = new Manager();


	@Override
	public ResultMessage_For_Stub Login(String ID, String password) {
		return manager.Login(ID, password);
	}

	@Override
	public ClientVO showClientData(String clientID) {
		return manager.showClientData(clientID);
	}

	@Override
	public StaffVO showStaffData(String staffID) {
		return manager.showStaffData(staffID);
	}

	@Override
	public ResultMessage_For_Stub changeStaffData(StaffVO vo) {
		return manager.changeStaffData(vo);
	}

	@Override
	public ResultMessage_For_Stub addStaff(StaffVO vo, String password) {
		return manager.addStaff(vo, password);
	}

	@Override
	public MarketerVO showMarketerData(String marketerID) {
		return manager.showMarketerData(marketerID);
	}

	@Override
	public ResultMessage_For_User changeMarketerData(MarketerVO vo) {
		return manager.changeMarketerData(vo);
	}

	@Override
	public ResultMessage_For_User addMarketer(MarketerVO vo, String password) {
		return manager.addMarketer(vo, password);
	}

}
