package bussinesslogic.usebl.manager;

import java.rmi.RemoteException;

import bussinesslogic.controllerfactory.ControllerFactory;
import dataservice.userdataservice.ManagerDataService;
import util.ResultMessage_For_User;
import vo.user.ClientVO;
import vo.user.MarketerVO;
import vo.user.StaffVO;

public class Manager {
	
	private ManagerDataService managerDataService;

	public ResultMessage_For_User Login(String managerID, String password) {
		ResultMessage_For_User result = ResultMessage_For_User.LoginSuccess;
		try {
			result = managerDataService.find(managerID, password);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ClientVO showClientData(String clientID) {
		return ControllerFactory.getClient2ManagerIstance().showData(clientID);
	}

	public StaffVO showStaffData(String staffID) {
		return ControllerFactory.getStaff2ManagerIstance().showData(staffID);
	}

	public ResultMessage_For_User changeStaffData(StaffVO vo) {
		return ControllerFactory.getStaff2ManagerIstance().changeData(vo);
	}

	public ResultMessage_For_User addStaff(StaffVO vo, String password) {
		return ControllerFactory.getStaff2ManagerIstance().addStaff(vo, password);
	}

	public MarketerVO showMarketerData(String marketerID) {
		return ControllerFactory.getManager2ManagerIstance().showData(marketerID);
	}

	public ResultMessage_For_User changeMarketerData(MarketerVO vo) {
		return ControllerFactory.getManager2ManagerIstance().changeData(vo);
	}

	public ResultMessage_For_User addMarketer(MarketerVO vo, String password) {
		return ControllerFactory.getManager2ManagerIstance().addMarketer(vo, password);
	}
}
