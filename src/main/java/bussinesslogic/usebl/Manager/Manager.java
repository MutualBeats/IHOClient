package bussinesslogic.usebl.manager;

import java.rmi.RemoteException;

import bussinesslogic.controllerfactory.ControllerFactory;
import dataservice.userdataservice.ManagerDataService;
import factory.datahelper.DataHelperFactory;
import util.ResultMessage_For_User;
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
		return ControllerFactory.getClient2ManagerIstance().showData(clientID);
	}

	public StaffVO showStaffData(String staffID) throws RemoteException {
		return ControllerFactory.getStaff2ManagerIstance().showData(staffID);
	}

	public ResultMessage_For_User changeStaffData(StaffVO vo) throws RemoteException {
		return ControllerFactory.getStaff2ManagerIstance().changeData(vo);
	}

	public ResultMessage_For_User addStaff(StaffVO vo, String password) throws RemoteException {
		return ControllerFactory.getStaff2ManagerIstance().addStaff(vo, password);
	}

	public MarketerVO showMarketerData(String marketerID) throws RemoteException {
		return ControllerFactory.getManager2ManagerIstance().showData(marketerID);
	}

	public ResultMessage_For_User changeMarketerData(MarketerVO vo) throws RemoteException {
		return ControllerFactory.getManager2ManagerIstance().changeData(vo);
	}

	public ResultMessage_For_User addMarketer(MarketerVO vo, String password) throws RemoteException {
		return ControllerFactory.getManager2ManagerIstance().addMarketer(vo, password);
	}
}
