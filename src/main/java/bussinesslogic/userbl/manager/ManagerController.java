package bussinesslogic.userbl.manager;

import java.util.ArrayList;

import bussinesslogicservice.userblservice.ManagerBLService;
import util.resultmessage.ResultMessage_Hotel;
import util.resultmessage.ResultMessage_User;
import vo.hotel.HotelVO;
import vo.user.ClientVO;
import vo.user.MarketerVO;
import vo.user.StaffVO;

public class ManagerController implements ManagerBLService {
	
	private Manager manager = new Manager();

	@Override
	public ClientVO showClientData(String clientID) throws Exception {
		return manager.showClientData(clientID);
	}

	@Override
	public StaffVO showStaffData(String staffID) throws Exception {
		return manager.showStaffData(staffID);
	}

	@Override
	public ResultMessage_User changeStaffData(StaffVO vo)  {
		return manager.changeStaffData(vo);
	}

	@Override
	public ResultMessage_User addStaff(StaffVO registVO, String password)  {
		return manager.addStaff(registVO, password);
	}

	@Override
	public MarketerVO showMarketerData(String marketerID) throws Exception {
		return manager.showMarketerData(marketerID);
	}

	@Override
	public ResultMessage_User changeMarketerData(MarketerVO vo) {
		return manager.changeMarketerData(vo);
	}

	@Override
	public ResultMessage_User addMarketer(MarketerVO vo, String password){
		return manager.addMarketer(vo, password);
	}

	@Override
	public ResultMessage_Hotel addHotel(HotelVO vo) throws Exception   {
		return manager.addHotel(vo);
	}

	@Override
	public ArrayList<ClientVO> getClientList() throws Exception {
		return manager.getClientList();
	}

	@Override
	public ArrayList<StaffVO> getStaffList() throws Exception {
		return manager.getStaffList();
	}

	@Override
	public ArrayList<MarketerVO> getMarketerList() throws Exception {
		return manager.getMarketerList();
	}

}
