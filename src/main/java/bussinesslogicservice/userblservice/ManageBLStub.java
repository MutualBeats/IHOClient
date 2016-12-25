package bussinesslogicservice.userblservice;

import java.util.ArrayList;

import util.exception.NetException;
import util.resultmessage.ResultMessage_User;
import util.user.MemberType;
import vo.hotel.HotelVO;
import vo.user.ClientInfoChangeVO;
import vo.user.ClientVO;
import vo.user.ManagerVO;
import vo.user.MarketerVO;
import vo.user.StaffChangeVO;
import vo.user.StaffVO;

public class ManageBLStub implements ManagerBLService{

	@Override
	public ManagerVO getManagerInfor() throws NetException {
		return new ManagerVO("manager_ac", "Manager", "110");
	}

	@Override
	public ResultMessage_User changeManagerInfo(ManagerVO vo) {
		return ResultMessage_User.UpdateSuccess;
	}

	@Override
	public ClientVO showClientData(String clientID) throws NetException {
		return new ClientVO("test_client", "Test", "12345678900", 0, MemberType.Not, 0, "");
	}

	@Override
	public ArrayList<ClientVO> getClientList() throws NetException {
		ArrayList<ClientVO> clientVOs = new ArrayList<>();
		clientVOs.add(new ClientVO("test_client", "Test", "12345678900", 0, MemberType.Not, 0, ""));
		return clientVOs;
	}

	@Override
	public ResultMessage_User changeClientInfo(ClientInfoChangeVO vo) {
		return ResultMessage_User.UpdateSuccess;
	}

	@Override
	public StaffVO showStaffData(String staffID) throws NetException {
		return new StaffVO("test_staff", "Test", "12345678900", "00000001");
	}

	@Override
	public ResultMessage_User changeStaffData(StaffChangeVO vo) {
		return ResultMessage_User.UpdateSuccess;
	}

	@Override
	public ResultMessage_User addStaff(StaffVO registVO, String password) {
		return ResultMessage_User.Account_Exist;
	}

	@Override
	public ArrayList<StaffVO> getStaffList() throws NetException {
		ArrayList<StaffVO> staffVOs = new ArrayList<>();
		staffVOs.add(new StaffVO("test_staff", "Test", "12345678900", "00000001"));
		return staffVOs;
	}

	@Override
	public MarketerVO showMarketerData(String marketerID) throws NetException {
		return new MarketerVO("testmarketer", "Test", "12345678900");
	}

	@Override
	public ResultMessage_User changeMarketerData(MarketerVO vo) {
		return ResultMessage_User.UpdateSuccess;
	}

	@Override
	public ResultMessage_User addMarketer(MarketerVO vo, String password) {
		return ResultMessage_User.PEOPLE_ADD_SUCCESS;
	}

	@Override
	public ArrayList<MarketerVO> getMarketerList() throws NetException {
		ArrayList<MarketerVO> marketerVOs = new ArrayList<>();
		marketerVOs.add(new MarketerVO("testmarketer", "Test", "12345678900"));
		return marketerVOs;
	}

	@Override
	public String addHotel(HotelVO vo) throws NetException {
		return "00000001";
	}

}
