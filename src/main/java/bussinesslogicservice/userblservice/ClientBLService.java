package bussinesslogicservice.userblservice;

import java.util.ArrayList;

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
	public ResultMessage Signup(ClientVO vo, String password);
	/*
	 * 注册企业会员
	 */
	public ResultMessage businessRegister (ClientVO vo);
	/*
	 * 注册普通会员
	 */
	public ResultMessage originalRegister (ClientVO vo);
	/*
	 * 查看会员信息
	 */
	public ClientVO get (String memberID);
	/*
	 * 更新会员等级信息
	 */
	public ResultMessage levelUpdate (ArrayList<Integer> levelList,int level);
	/*
	 * 更新会员信息
	 */
	public ResultMessage update(String memberID,ClientVO vo);
}
