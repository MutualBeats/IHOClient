package bussinesslogic.userbl.manager;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogic.userbl.manager.entrust.ClientInfoGet;
import bussinesslogic.userbl.manager.entrust.HotelAdd;
import bussinesslogic.userbl.manager.entrust.MarketerManage;
import bussinesslogic.userbl.manager.entrust.StaffManage;
import util.resultmessage.ResultMessage_Hotel;
import util.resultmessage.ResultMessage_User;
import vo.hotel.HotelVO;
import vo.user.ClientVO;
import vo.user.MarketerVO;
import vo.user.StaffVO;

public class Manager {
	
	private ClientInfoGet client;
	private MarketerManage marketer;
	private StaffManage staff;
	private HotelAdd hotel;
	
	public ClientVO showClientData(String clientID) throws RemoteException {
		checkClient();
		return client.getClientInfo(clientID);
	}
	
	public ArrayList<ClientVO> getClientList() throws RemoteException {
		checkClient();
		return client.getClientList();
	}

	public StaffVO showStaffData(String staffID) throws RemoteException {
		checkStaff();
		return staff.showData(staffID);
	}

	public ResultMessage_User changeStaffData(StaffVO vo) {
		checkStaff();
		return staff.changeData(vo);
	}

	public ResultMessage_User addStaff(StaffVO registVO, String password) {
		checkStaff();
		return staff.addStaff(registVO, password);
	}
	
	public ArrayList<StaffVO> getStaffList() throws RemoteException {
		checkStaff();
		return staff.getStaffList();
	}


	public MarketerVO showMarketerData(String marketerID) throws RemoteException {
		checkMarketer();
		return marketer.showData(marketerID);
	}

	public ResultMessage_User changeMarketerData(MarketerVO vo)  {
		checkMarketer();
		return marketer.changeData(vo);
	}

	public ResultMessage_User addMarketer(MarketerVO vo, String password)  {
		checkMarketer();
		return marketer.addMarketer(vo, password);
	}
	
	public ArrayList<MarketerVO> getMarketerList() throws RemoteException {
		checkMarketer();
		return marketer.getMarketerList();
	}
	
	public ResultMessage_Hotel addHotel(HotelVO vo) throws RemoteException{
		checkHotel();
		return hotel.addHotel(vo);
	}
	

	
	
	private void checkClient() {
		if(client == null) {
			try {
				client = ControllerFactory.getClient2ManagerInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void checkStaff() {
		if(staff == null) {
			try {
				staff = ControllerFactory.getStaff2ManagerInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void checkMarketer() {
		if(marketer == null) {
			try {
				marketer = ControllerFactory.getMarketer2ManagerInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void checkHotel() {
		if(hotel == null) {
			try {
				hotel = ControllerFactory.getHotel2ManagerInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

