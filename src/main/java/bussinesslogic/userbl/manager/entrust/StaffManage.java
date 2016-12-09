package bussinesslogic.userbl.manager.entrust;

import java.util.ArrayList;

import util.exception.NetException;
import util.resultmessage.ResultMessage_User;
import vo.user.StaffChangeVO;
import vo.user.StaffVO;

public interface StaffManage {
	/*
	 * 获取酒店工作人员信息
	 */
	public StaffVO showData (String staffID) throws NetException;
	/*
	 * 修改酒店工作人员信息
	 */
	public ResultMessage_User changeData (StaffChangeVO vo) ;
	/*
	 * 添加酒店工作人员
	 */
	public ResultMessage_User addStaff(StaffVO registVO, String password) ;
	
	public ArrayList<StaffVO> getStaffList() throws NetException;
}
