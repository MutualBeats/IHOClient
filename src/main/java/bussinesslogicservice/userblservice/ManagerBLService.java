package bussinesslogicservice.userblservice;

import util.ResultMessage;
import vo.ClientVO;
import vo.MarketerVO;
import vo.StaffVO;

public interface ManagerBLService {
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
	public ResultMessage changeStaffData (StaffVO vo);
	/*
	 * 添加酒店工作人员
	 */
	public ResultMessage addStaff(StaffVO vo);
	/*
	 * 获取网站营销人员信息
	 */
	public MarketerVO showMarketerData (String marketerID);
	/*
	 * 修改网站营销人员信息
	 */
	public ResultMessage changeMarketerData (MarketerVO vo);
	/*
	 * 添加网站营销人员
	 */
	public ResultMessage addMarketer(MarketerVO vo);
}
