package bussinesslogicservice.userblservice;

import java.util.ArrayList;

import util.ResultMessage_For_User;
import vo.user.ClientVO;

public interface ClientBLService {
	/*
	 * 获取用户信息
	 */
	public ClientVO showData (String clientID);
	/*
	 * 修改用户信息
	 */
	public ResultMessage_For_User changeData (ClientVO vo);
	/*
	 * 用户登录
	 */
	public ResultMessage_For_User Login(String ID, String password);
	/*
	 * 注册新用户
	 */
	public ResultMessage_For_User Signup(ClientVO vo, String password);
	/*
	 * 注册企业会员
	 */
	public ResultMessage_For_User businessRegister (ClientVO vo);
	/*
	 * 注册普通会员
	 */
	public ResultMessage_For_User originalRegister (ClientVO vo);
	/*
	 * 查看会员信息
	 */
	public ClientVO get (String memberID);
	/*
	 * 更新会员等级信息
	 */
	public ResultMessage_For_User levelUpdate (ArrayList<Integer> levelList,int level);
	/*
	 * 更新会员信息
	 */
	public ResultMessage_For_User update(String memberID,ClientVO vo);
}
