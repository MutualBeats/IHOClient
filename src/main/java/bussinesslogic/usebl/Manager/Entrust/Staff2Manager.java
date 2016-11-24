package bussinesslogic.usebl.manager.entrust;

import util.ResultMessage_For_Stub;
import vo.user.StaffVO;

public interface Staff2Manager {
	/*
	 * 获取酒店工作人员信息
	 */
	public StaffVO showData (String staffID);
	/*
	 * 修改酒店工作人员信息
	 */
	public ResultMessage_For_Stub changeData (StaffVO vo);
	/*
	 * 添加酒店工作人员
	 */
	public ResultMessage_For_Stub addStaff(StaffVO vo, String password);
}
