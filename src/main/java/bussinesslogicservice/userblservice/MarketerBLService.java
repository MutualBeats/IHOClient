package bussinesslogicservice.userblservice;

import util.ResultMessage_For_Stub;
import vo.MarketerVO;

public interface MarketerBLService {
	/*
	 * 登录
	 */
	public ResultMessage_For_Stub Login(String ID, String password);
	/*
	 * 获取网站营销人员信息
	 */
	public MarketerVO showData (String marketerID);
}
