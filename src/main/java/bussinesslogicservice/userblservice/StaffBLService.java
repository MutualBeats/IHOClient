package bussinesslogicservice.userblservice;

import vo.StaffVO;

public interface StaffBLService {
	/*
	 * 获取酒店工作人员信息
	 */
	public StaffVO showData (String staffID);
}
