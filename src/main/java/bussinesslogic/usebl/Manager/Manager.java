package bussinesslogic.usebl.manager;

import bussinesslogic.controllerfactory.ControllerFactory;
import util.ResultMessage_For_Stub;
import vo.ClientVO;
import vo.MarketerVO;
import vo.StaffVO;

public class Manager {
	

	public ResultMessage_For_Stub Login(String ID, String password) {
		//TODO 
		return null;
	}
	
	public ClientVO showClientData(String clientID) {
		return ControllerFactory.getClient2ManagerIstance().showData(clientID);
	}

	public StaffVO showStaffData(String staffID) {
		return ControllerFactory.getStaff2ManagerIstance().showData(staffID);
	}

	public ResultMessage_For_Stub changeStaffData(StaffVO vo) {
		return ControllerFactory.getStaff2ManagerIstance().changeData(vo);
	}

	public ResultMessage_For_Stub addStaff(StaffVO vo, String password) {
		return ControllerFactory.getStaff2ManagerIstance().addStaff(vo, password);
	}

	public MarketerVO showMarketerData(String marketerID) {
		return ControllerFactory.getManager2ManagerIstance().showData(marketerID);
	}

	public ResultMessage_For_Stub changeMarketerData(MarketerVO vo) {
		return ControllerFactory.getManager2ManagerIstance().changeData(vo);
	}

	public ResultMessage_For_Stub addMarketer(MarketerVO vo, String password) {
		return ControllerFactory.getManager2ManagerIstance().addMarketer(vo, password);
	}
}
