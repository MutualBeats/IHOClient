package bussinesslogic.userbl.manager;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogic.userbl.manager.entrust.ClientInfoGet;
import bussinesslogic.userbl.manager.entrust.HotelAdd;
import bussinesslogic.userbl.manager.entrust.MarketerManage;
import bussinesslogic.userbl.manager.entrust.StaffManage;
import dataservice.userdataservice.ManagerDataService;
import factory.datahelper.DataHelperFactory;
import po.user.ManagerPO;
import util.exception.NetException;
import util.resultmessage.ResultMessage_User;
import vo.hotel.HotelVO;
import vo.user.ClientInfoChangeVO;
import vo.user.ClientVO;
import vo.user.ManagerVO;
import vo.user.MarketerVO;
import vo.user.StaffChangeVO;
import vo.user.StaffVO;

public class Manager {
	
	private ClientInfoGet client;
	private MarketerManage marketer;
	private StaffManage staff;
	private HotelAdd hotel;
	
	private ManagerDataService manager_service;
	
	public ManagerVO getManagerInfor() throws NetException {
		checkManageState();
		ManagerPO info;
		try {
			info = manager_service.getManagerInfo();
		} catch (RemoteException e) {
			e.printStackTrace();
			throw new NetException();
		}
		return ManagerPO.transformPOToVO(info);
	}
	
	public ClientVO showClientData(String clientID) throws NetException {
		checkClient();
		return client.getClientInfo(clientID);
	}
	
	public ArrayList<ClientVO> getClientList() throws NetException {
		checkClient();
		return client.getClientList();
	}

	public StaffVO showStaffData(String staffID) throws NetException {
		checkStaff();
		return staff.showData(staffID);
	}

	public ResultMessage_User changeStaffData(StaffChangeVO vo) {
		try {
			checkStaff();
		} catch (Exception e) {
			return ResultMessage_User.Net_Error;
		}
		return staff.changeData(vo);
	}

	public ResultMessage_User addStaff(StaffVO registVO, String password) {
		try {
			checkStaff();
		} catch (Exception e) {
			return ResultMessage_User.Net_Error;
		}
		return staff.addStaff(registVO, password);
	}
	
	public ArrayList<StaffVO> getStaffList() throws NetException {
		checkStaff();
		return staff.getStaffList();
	}


	public MarketerVO showMarketerData(String marketerID) throws NetException {
		checkMarketer();
		return marketer.showData(marketerID);
	}

	public ResultMessage_User changeMarketerData(MarketerVO vo)  {
		try {
			checkMarketer();
		} catch (Exception e) {
			return ResultMessage_User.Net_Error;
		}
		return marketer.changeData(vo);
	}

	public ResultMessage_User addMarketer(MarketerVO vo, String password)  {
		try {
			checkMarketer();
		} catch (Exception e) {
			return ResultMessage_User.Net_Error;
		}
		return marketer.addMarketer(vo, password);
	}
	
	public ArrayList<MarketerVO> getMarketerList() throws NetException {
		checkMarketer();
		return marketer.getMarketerList();
	}
	
	public String addHotel(HotelVO vo) throws NetException {
		checkHotel();
		return hotel.addHotel(vo);
	}
	

	
	
	private void checkClient() throws NetException {
		if(client == null) {
				client = ControllerFactory.getClient2ManagerInstance();
		}
	}
	
	private void checkStaff() throws NetException {
		if(staff == null) {
				staff = ControllerFactory.getStaff2ManagerInstance();
		}
	}
	
	private void checkMarketer() throws NetException {
		if(marketer == null) {
			marketer = ControllerFactory.getMarketer2ManagerInstance();
		}
	}
	
	private void checkHotel() throws NetException {
		if(hotel == null) {
			hotel = ControllerFactory.getHotel2ManagerInstance();
		}
	}
	
	private void checkManageState() throws NetException {
		if(manager_service == null) {
			manager_service = DataHelperFactory.getDataFactoryHelperInstance().getManagerDatabase();
		}
	}

	public ResultMessage_User changeManagerInfo(ManagerVO vo) {
		ResultMessage_User result = ResultMessage_User.UpdateSuccess;
		try {
			checkManageState();
			result = manager_service.changeManagerInfo(ManagerVO.transformVOToPO(vo));
		} catch (Exception e) {
			return ResultMessage_User.Net_Error;
		}
		return result;
	}

	public ResultMessage_User changeClientInfo(ClientInfoChangeVO vo) {
		try {
			checkClient();
			return client.changeClientInfo(vo);
		} catch (Exception e) {
			return ResultMessage_User.Net_Error;
		}
		
	}
}

