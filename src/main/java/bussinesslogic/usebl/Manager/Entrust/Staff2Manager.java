package bussinesslogic.usebl.manager.entrust;

import util.ResultMessage;
import vo.StaffVO;

public interface Staff2Manager {
	/*
	 * 获取酒店工作人员信息
	 */
	public StaffVO showData (String staffID);
	/*
	 * 修改酒店工作人员信息
	 */
	public ResultMessage changeData (StaffVO vo);
	/*
	 * 添加酒店工作人员
	 */
	public ResultMessage addStaff(StaffVO vo, String password);
}
