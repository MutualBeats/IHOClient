package bussinesslogicservice.userblservice;

import util.ResultMessage;
import vo.ClientVO;

public interface ClientBLService {
	/*
	 * 获取用户信息
	 */
	public ClientVO showData (String clientID);
	/*
	 * 修改用户信息
	 */
	public ResultMessage changeData (ClientVO vo);
	/*
	 * 用户登录
	 */
	public ResultMessage Login(String ID, String password);
	/*
	 * 注册新用户
	 */
	public ResultMessage Signup(ClientVO vo);
}
