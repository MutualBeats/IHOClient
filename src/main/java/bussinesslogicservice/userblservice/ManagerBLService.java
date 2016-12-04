package bussinesslogicservice.userblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.resultmessage.ResultMessage_Hotel;
import util.resultmessage.ResultMessage_User;
import vo.hotel.HotelVO;
import vo.user.ClientVO;
import vo.user.MarketerVO;
import vo.user.StaffVO;

/**
 * 
 * Manage BL Service
 * 
 * @author heleninsa
 *
 */
public interface ManagerBLService {
	
	public ClientVO showClientData (String clientID)throws RemoteException;
	
	public ArrayList<ClientVO> getClientList() throws RemoteException;
	
	public StaffVO showStaffData (String staffID) throws RemoteException;
	
	public ResultMessage_User changeStaffData (StaffVO vo) ;
	
	public ResultMessage_User addStaff(StaffVO registVO,  String password) ;
	
	public ArrayList<StaffVO> getStaffList() throws RemoteException;
	
	public MarketerVO showMarketerData (String marketerID) throws RemoteException;
	
	public ResultMessage_User changeMarketerData (MarketerVO vo) ;
	
	public ResultMessage_User addMarketer(MarketerVO vo, String password);
	
	public ArrayList<MarketerVO> getMarketerList() throws RemoteException;
	
	public ResultMessage_Hotel addHotel(HotelVO vo) throws RemoteException;
}
