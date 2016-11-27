package bussinesslogic.usebl.manager;

import java.rmi.RemoteException;

import bussinesslogicservice.userblservice.ManagerBLService;
import util.ResultMessage_For_User;
import vo.user.ClientVO;
import vo.user.MarketerVO;
import vo.user.StaffVO;

public class ManagerController implements ManagerBLService {
	
	private Manager manager;

	public ManagerController() throws RemoteException{
		manager = new Manager();
	}

	@Override
	public ResultMessage_For_User Login(String managerID, String password) throws RemoteException {
		return manager.Login(managerID, password);
	}

	@Override
	public ClientVO showClientData(String clientID) throws RemoteException {
		return manager.showClientData(clientID);
	}

	@Override
	public StaffVO showStaffData(String staffID) throws RemoteException {
		return manager.showStaffData(staffID);
	}

	@Override
	public ResultMessage_For_User changeStaffData(StaffVO vo) throws RemoteException {
		return manager.changeStaffData(vo);
	}

	@Override
	public ResultMessage_For_User addStaff(StaffVO vo, String password) throws RemoteException {
		return manager.addStaff(vo, password);
	}

	@Override
	public MarketerVO showMarketerData(String marketerID) throws RemoteException {
		return manager.showMarketerData(marketerID);
	}

	@Override
	public ResultMessage_For_User changeMarketerData(MarketerVO vo) throws RemoteException {
		return manager.changeMarketerData(vo);
	}

	@Override
	public ResultMessage_For_User addMarketer(MarketerVO vo, String password) throws RemoteException {
		return manager.addMarketer(vo, password);
	}

}
