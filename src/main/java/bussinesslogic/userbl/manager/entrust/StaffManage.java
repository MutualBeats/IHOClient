package bussinesslogic.userbl.manager.entrust;

import java.rmi.RemoteException;

import util.resultmessage.ResultMessage_User;
import vo.user.StaffVO;

public interface StaffManage {
	/*
	 * 获取酒店工作人员信息
	 */
	public StaffVO showData (String staffID) throws RemoteException;
	/*
	 * 修改酒店工作人员信息
	 */
	public ResultMessage_User changeData (StaffVO vo) ;
	/*
	 * 添加酒店工作人员
	 */
	public ResultMessage_User addStaff(String staffName, String hotelID, String password) ;
}
