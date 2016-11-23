package bussinesslogicservice.userblservice;

import util.ResultMessage_For_Stub;
import vo.StaffVO;

public interface StaffBLService {
	/*
	 * 登录
	 */
	public ResultMessage_For_Stub Login(String ID, String password);
	/*
	 * 获取酒店工作人员信息
	 */
	public StaffVO showData (String staffID);
}
