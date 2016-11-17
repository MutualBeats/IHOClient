package bussinesslogicservice.userblservice;

import util.ResultMessage;
import vo.StaffVO;

public interface StaffBLService {
	/*
	 * 登录
	 */
	public ResultMessage Login(String ID, String password);
	/*
	 * 获取酒店工作人员信息
	 */
	public StaffVO showData (String staffID);
}
