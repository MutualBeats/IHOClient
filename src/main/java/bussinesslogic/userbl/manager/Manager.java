package bussinesslogic.userbl.manager;

import java.rmi.RemoteException;

import bussinesslogic.controllerfactory.ControllerFactory;
import dataservice.hoteldataservice.ResultMessage_Hotel;
import dataservice.userdataservice.ManagerDataService;
import factory.datahelper.DataHelperFactory;
import util.ResultMessage_For_User;
import vo.hotel.HotelVO;
import vo.user.ClientVO;
import vo.user.MarketerVO;
import vo.user.StaffVO;

public class Manager {
	
	private ManagerDataService managerDataService;
	
	public Manager() throws RemoteException{
		managerDataService = DataHelperFactory.getDataFactoryHelperInstance().getManagerDatabase();
	}

	/*
	 * UserID Invalid
	 * 
	 * Account Not Exist
	 * Password Wrong
	 * */
	public ResultMessage_For_User Login(String managerID, String password) throws RemoteException {
		int len = managerID.length();
		if(len<8||len>16)
			return ResultMessage_For_User.UserID_Invalid;
		
		ResultMessage_For_User result = ResultMessage_For_User.LoginSuccess;

		result = managerDataService.find(managerID, password);
		
		return result;
	}
	
	public ClientVO showClientData(String clientID) throws RemoteException {
		return ControllerFactory.getClient2ManagerInstance().showData(clientID);
	}

	public StaffVO showStaffData(String staffID) throws RemoteException {
		return ControllerFactory.getStaff2ManagerInstance().showData(staffID);
	}

	public ResultMessage_For_User changeStaffData(StaffVO vo) throws RemoteException {
		return ControllerFactory.getStaff2ManagerInstance().changeData(vo);
	}

	public ResultMessage_For_User addStaff(String staffName, String hotelID, String password) throws RemoteException {
		return ControllerFactory.getStaff2ManagerInstance().addStaff(staffName, hotelID, password);
	}

	public MarketerVO showMarketerData(String marketerID) throws RemoteException {
		return ControllerFactory.getMarketer2ManagerInstance().showData(marketerID);
	}

	public ResultMessage_For_User changeMarketerData(MarketerVO vo) throws RemoteException {
		return ControllerFactory.getMarketer2ManagerInstance().changeData(vo);
	}

	public ResultMessage_For_User addMarketer(String marketerName, String contactWay, String password) throws RemoteException {
		return ControllerFactory.getMarketer2ManagerInstance().addMarketer(marketerName, contactWay, password);
	}
	
	public ResultMessage_Hotel addHotel(HotelVO vo) throws RemoteException{
		return ControllerFactory.getHotel2ManagerInstance().addHotel(vo);
	}
}
