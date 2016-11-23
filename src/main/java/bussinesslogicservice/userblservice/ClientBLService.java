package bussinesslogicservice.userblservice;

import java.util.ArrayList;

import util.ResultMessage_For_Stub;
import vo.ClientVO;

public interface ClientBLService {
	/*
	 * 获取用户信息
	 */
	public ClientVO showData (String clientID);
	/*
	 * 修改用户信息
	 */
	public ResultMessage_For_Stub changeData (ClientVO vo);
	/*
	 * 用户登录
	 */
	public ResultMessage_For_Stub Login(String ID, String password);
	/*
	 * 注册新用户
	 */
	public ResultMessage_For_Stub Signup(ClientVO vo, String password);
	/*
	 * 注册企业会员
	 */
	public ResultMessage_For_Stub businessRegister (ClientVO vo);
	/*
	 * 注册普通会员
	 */
	public ResultMessage_For_Stub originalRegister (ClientVO vo);
	/*
	 * 查看会员信息
	 */
	public ClientVO get (String memberID);
	/*
	 * 更新会员等级信息
	 */
	public ResultMessage_For_Stub levelUpdate (ArrayList<Integer> levelList,int level);
	/*
	 * 更新会员信息
	 */
	public ResultMessage_For_Stub update(String memberID,ClientVO vo);
}
