package bussinesslogicservice.userblservice;

import java.rmi.RemoteException;

import dataservice.hoteldataservice.ResultMessage_Hotel;
import util.ResultMessage_For_User;
import vo.hotel.HotelVO;
import vo.user.ClientVO;
import vo.user.MarketerVO;
import vo.user.StaffVO;

public interface ManagerBLService {
	/*
	 * 登录
	 */
	public ResultMessage_For_User Login(String managerID, String password) throws RemoteException;
	/*
	 * 获取用户信息
	 */
	public ClientVO showClientData (String clientID)throws RemoteException;
	/*
	 * 获取酒店工作人员信息
	 */
	public StaffVO showStaffData (String staffID) throws RemoteException;
	/*
	 * 修改酒店工作人员信息
	 */
	public ResultMessage_For_User changeStaffData (StaffVO vo) throws RemoteException;
	/*
	 * 添加酒店工作人员
	 */
	public ResultMessage_For_User addStaff(String staffName, String hotelID,  String password) throws RemoteException;
	/*
	 * 获取网站营销人员信息
	 */
	public MarketerVO showMarketerData (String marketerID) throws RemoteException;
	/*
	 * 修改网站营销人员信息
	 */
	public ResultMessage_For_User changeMarketerData (MarketerVO vo) throws RemoteException;
	/*
	 * 添加网站营销人员
	 */
	public ResultMessage_For_User addMarketer(String marketerName, String contactWay, String password) throws RemoteException;
	/*
	 * 添加酒店
	 */
	public ResultMessage_Hotel addHotel(HotelVO vo) throws RemoteException;
}
