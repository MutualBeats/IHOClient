package bussinesslogic.userbl.manager;

import java.rmi.RemoteException;

import bussinesslogic.controllerfactory.ControllerFactory;
import dataservice.userdataservice.ManagerDataService;
import factory.datahelper.DataHelperFactory;
import util.resultmessage.ResultMessage_Hotel;
import util.resultmessage.ResultMessage_User;
import vo.hotel.HotelVO;
import vo.user.ClientVO;
import vo.user.MarketerVO;
import vo.user.StaffVO;

public class Manager {
	
	private ManagerDataService managerDataService;
	
	public Manager() {
		try {
			managerDataService = DataHelperFactory.getDataFactoryHelperInstance().getManagerDatabase();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/*
	 * -UserID Invalid
	 * 
	 * Account Not Exist
	 * Password Wrong
	 * */
	public ResultMessage_User Login(String managerID, String password) {
//		int len = managerID.length();
//		if(len<8||len>16)
//			return ResultMessage_User.UserID_Invalid;
		
		ResultMessage_User result = ResultMessage_User.LoginSuccess;

		try {
			result = managerDataService.find(managerID, password);
		} catch (RemoteException e) {
			return ResultMessage_User.Net_Error;
		}
		
		return result;
	}
	
	public ClientVO showClientData(String clientID) throws RemoteException {
		return ControllerFactory.getClient2ManagerInstance().showData(clientID);
	}

	public StaffVO showStaffData(String staffID) throws RemoteException {
		return ControllerFactory.getStaff2ManagerInstance().showData(staffID);
	}

	public ResultMessage_User changeStaffData(StaffVO vo) {
		return ControllerFactory.getStaff2ManagerInstance().changeData(vo);
	}

	public ResultMessage_User addStaff(String staffName, String hotelID, String password) {
		return ControllerFactory.getStaff2ManagerInstance().addStaff(staffName, hotelID, password);
	}

	public MarketerVO showMarketerData(String marketerID) throws RemoteException {
		return ControllerFactory.getMarketer2ManagerInstance().showData(marketerID);
	}

	public ResultMessage_User changeMarketerData(MarketerVO vo)  {
		return ControllerFactory.getMarketer2ManagerInstance().changeData(vo);
	}

	public ResultMessage_User addMarketer(MarketerVO vo, String password)  {
		return ControllerFactory.getMarketer2ManagerInstance().addMarketer(vo, password);
	}
	
	public ResultMessage_Hotel addHotel(HotelVO vo) throws RemoteException{
		return ControllerFactory.getHotel2ManagerInstance().addHotel(vo);
	}
}
