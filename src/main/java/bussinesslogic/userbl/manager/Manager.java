package bussinesslogic.userbl.manager;

import java.util.ArrayList;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogic.userbl.manager.entrust.ClientInfoGet;
import bussinesslogic.userbl.manager.entrust.HotelAdd;
import bussinesslogic.userbl.manager.entrust.MarketerManage;
import bussinesslogic.userbl.manager.entrust.StaffManage;
import dataservice.userdataservice.ManagerDataService;
import factory.datahelper.DataHelperFactory;
import po.user.ManagerPO;
import util.resultmessage.ResultMessage_Hotel;
import util.resultmessage.ResultMessage_User;
import vo.hotel.HotelVO;
import vo.user.ClientVO;
import vo.user.ManagerVO;
import vo.user.MarketerVO;
import vo.user.StaffVO;

public class Manager {
	
	private ClientInfoGet client;
	private MarketerManage marketer;
	private StaffManage staff;
	private HotelAdd hotel;
	
	private ManagerDataService manager_service;
	
	public ManagerVO getManagerInfor() throws Exception {
		checkManageState();
		ManagerPO info = manager_service.getManagerInfo();
		return ManagerPO.transformPOToVO(info);
	}
	
	public ClientVO showClientData(String clientID) throws Exception {
		checkClient();
		return client.getClientInfo(clientID);
	}
	
	public ArrayList<ClientVO> getClientList() throws Exception {
		checkClient();
		return client.getClientList();
	}

	public StaffVO showStaffData(String staffID) throws Exception {
		checkStaff();
		return staff.showData(staffID);
	}

	public ResultMessage_User changeStaffData(StaffVO vo) {
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
	
	public ArrayList<StaffVO> getStaffList() throws Exception {
		checkStaff();
		return staff.getStaffList();
	}


	public MarketerVO showMarketerData(String marketerID) throws Exception {
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
	
	public ArrayList<MarketerVO> getMarketerList() throws Exception {
		checkMarketer();
		return marketer.getMarketerList();
	}
	
	public ResultMessage_Hotel addHotel(HotelVO vo) throws Exception{
		checkHotel();
		return hotel.addHotel(vo);
	}
	

	
	
	private void checkClient() throws Exception {
		if(client == null) {
				client = ControllerFactory.getClient2ManagerInstance();
		}
	}
	
	private void checkStaff() throws Exception {
		if(staff == null) {
				staff = ControllerFactory.getStaff2ManagerInstance();
		}
	}
	
	private void checkMarketer() throws Exception {
		if(marketer == null) {
			marketer = ControllerFactory.getMarketer2ManagerInstance();
		}
	}
	
	private void checkHotel() throws Exception {
		if(hotel == null) {
			hotel = ControllerFactory.getHotel2ManagerInstance();
		}
	}
	
	private void checkManageState() throws Exception {
		if(manager_service == null) {
			manager_service = DataHelperFactory.getDataFactoryHelperInstance().getManagerDatabase();
		}
	}
}

