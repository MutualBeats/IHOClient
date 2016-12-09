package bussinesslogic.userbl.manager;

import java.util.ArrayList;

import bussinesslogicservice.userblservice.ManagerBLService;
import util.exception.NetException;
import util.resultmessage.ResultMessage_User;
import vo.hotel.HotelVO;
import vo.user.ClientInfoChangeVO;
import vo.user.ClientVO;
import vo.user.ManagerVO;
import vo.user.MarketerVO;
import vo.user.StaffChangeVO;
import vo.user.StaffVO;

public class ManagerController implements ManagerBLService {
	
	private Manager manager = new Manager();

	@Override
	public ClientVO showClientData(String clientID) throws NetException {
		return manager.showClientData(clientID);
	}

	@Override
	public StaffVO showStaffData(String staffID) throws NetException {
		return manager.showStaffData(staffID);
	}

	@Override
	public ResultMessage_User changeStaffData(StaffChangeVO vo)  {
		return manager.changeStaffData(vo);
	}

	@Override
	public ResultMessage_User addStaff(StaffVO registVO, String password)  {
		return manager.addStaff(registVO, password);
	}

	@Override
	public MarketerVO showMarketerData(String marketerID) throws NetException {
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
	public String addHotel(HotelVO vo) throws NetException   {
		return manager.addHotel(vo);
	}

	@Override
	public ArrayList<ClientVO> getClientList() throws NetException {
		return manager.getClientList();
	}

	@Override
	public ArrayList<StaffVO> getStaffList() throws NetException {
		return manager.getStaffList();
	}

	@Override
	public ArrayList<MarketerVO> getMarketerList() throws NetException {
		return manager.getMarketerList();
	}

	@Override
	public ManagerVO getManagerInfor() throws NetException {
		return manager.getManagerInfor();
	}

	@Override
	public ResultMessage_User changeManagerInfo(ManagerVO vo) {
		return manager.changeManagerInfo(vo);
	}

	@Override
	public ResultMessage_User changeClientInfo(ClientInfoChangeVO vo) {
		return manager.changeClientInfo(vo);
	}

}
