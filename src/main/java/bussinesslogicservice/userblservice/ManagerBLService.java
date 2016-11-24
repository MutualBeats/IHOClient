package bussinesslogicservice.userblservice;

import util.ResultMessage_For_Stub;
import util.ResultMessage_For_User;
import vo.user.ClientVO;
import vo.user.MarketerVO;
import vo.user.StaffVO;

public interface ManagerBLService {
	/*
	 * 登录
	 */
	public ResultMessage_For_Stub Login(String ID, String password);
	/*
	 * 获取用户信息
	 */
	public ClientVO showClientData (String clientID);
	/*
	 * 获取酒店工作人员信息
	 */
	public StaffVO showStaffData (String staffID);
	/*
	 * 修改酒店工作人员信息
	 */
	public ResultMessage_For_Stub changeStaffData (StaffVO vo);
	/*
	 * 添加酒店工作人员
	 */
	public ResultMessage_For_Stub addStaff(StaffVO vo, String password);
	/*
	 * 获取网站营销人员信息
	 */
	public MarketerVO showMarketerData (String marketerID);
	/*
	 * 修改网站营销人员信息
	 */
	public ResultMessage_For_User changeMarketerData (MarketerVO vo);
	/*
	 * 添加网站营销人员
	 */
	public ResultMessage_For_User addMarketer(MarketerVO vo, String password);
}
