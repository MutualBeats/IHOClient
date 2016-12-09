package bussinesslogicservice.userblservice;

import java.util.ArrayList;

import util.exception.NetException;
import util.resultmessage.ResultMessage_User;
import vo.hotel.HotelVO;
import vo.user.ClientInfoChangeVO;
import vo.user.ClientVO;
import vo.user.ManagerVO;
import vo.user.MarketerVO;
import vo.user.StaffChangeVO;
import vo.user.StaffVO;

/**
 * 
 * Manage BL Service
 * 
 * @author heleninsa
 *
 */
public interface ManagerBLService {
	
	public ManagerVO getManagerInfor() throws NetException;
	
	public ResultMessage_User changeManagerInfo(ManagerVO vo);
	
	public ClientVO showClientData (String clientID)throws NetException;
	
	public ArrayList<ClientVO> getClientList() throws NetException;
	
	public ResultMessage_User changeClientInfo (ClientInfoChangeVO vo);
	
	public StaffVO showStaffData (String staffID) throws NetException;
	
	public ResultMessage_User changeStaffData (StaffChangeVO vo) ;
	
	public ResultMessage_User addStaff(StaffVO registVO,  String password) ;
	
	public ArrayList<StaffVO> getStaffList() throws NetException;
	
	public MarketerVO showMarketerData (String marketerID) throws NetException;
	
	public ResultMessage_User changeMarketerData (MarketerVO vo) ;
	
	public ResultMessage_User addMarketer(MarketerVO vo, String password);
	
	public ArrayList<MarketerVO> getMarketerList() throws NetException;
	
	public String addHotel(HotelVO vo) throws NetException;
}
