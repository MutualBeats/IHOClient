package bussinesslogicservice.userblservice;

import util.ResultMessage_For_User;
import vo.user.MarketerVO;

public interface MarketerBLService {
	/*
	 * 登录
	 */
	public ResultMessage_For_User Login(String ID, String password);
	/*
	 * 获取网站营销人员信息
	 */
	public MarketerVO showData (String marketerID);
}
