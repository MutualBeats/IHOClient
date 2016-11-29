package bussinesslogic.userbl.manager;

import java.rmi.RemoteException;

import bussinesslogicservice.userblservice.ManagerBLService;
import util.resultmessage.ResultMessage_Hotel;
import util.resultmessage.ResultMessage_User;
import vo.hotel.HotelVO;
import vo.user.ClientVO;
import vo.user.MarketerVO;
import vo.user.StaffVO;

public class ManagerController implements ManagerBLService {
	
	private Manager manager;

	public ManagerController() throws RemoteException{
		manager = new Manager();
	}

	@Override
	public ResultMessage_User Login(String managerID, String password) throws RemoteException {
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
	public ResultMessage_User changeStaffData(StaffVO vo) throws RemoteException {
		return manager.changeStaffData(vo);
	}

	@Override
	public ResultMessage_User addStaff(String staffName, String hotelID, String password) throws RemoteException {
		return manager.addStaff(staffName, hotelID, password);
	}

	@Override
	public MarketerVO showMarketerData(String marketerID) throws RemoteException {
		return manager.showMarketerData(marketerID);
	}

	@Override
	public ResultMessage_User changeMarketerData(MarketerVO vo) throws RemoteException {
		return manager.changeMarketerData(vo);
	}

	@Override
	public ResultMessage_User addMarketer(String marketerName, String contactWay, String password) throws RemoteException {
		return manager.addMarketer(marketerName, contactWay, password);
	}

	@Override
	public ResultMessage_Hotel addHotel(HotelVO vo) throws RemoteException {
		return manager.addHotel(vo);
	}

}
