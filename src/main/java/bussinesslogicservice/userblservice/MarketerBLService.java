package bussinesslogicservice.userblservice;

import util.ResultMessage;
import vo.MarketerVO;

public interface MarketerBLService {
	/*
	 * 登录
	 */
	public ResultMessage Login(String ID, String password);
	/*
	 * 获取网站营销人员信息
	 */
	public MarketerVO showData (String marketerID);
}
