package bussinesslogicservice.userblservice;

import util.ResultMessage_For_User;
import vo.user.ClientVO;
import vo.user.MemberVO;

public interface ClientBLService {
	/*
	 * 获取用户信息
	 */
	public ClientVO showData (String clientID);
	/*
	 * 修改用户信息
	 */
	public ResultMessage_For_User changeData (String clientID, String clientName, String contactWay);
	/*
	 * 用户登录
	 */
	public ResultMessage_For_User Login(String clientID, String password);
	/*
	 * 注册新用户
	 */
	public ResultMessage_For_User Signup(ClientVO vo, String password);
	/*
	 * 注册会员
	 */
	public ResultMessage_For_User memberRegister (MemberVO vo);
	/*
	 * 查看会员信息
	 */
	public MemberVO showMemberData(String clientID);
	/*
	 * 更新会员信息
	 */
	public ResultMessage_For_User changeMemberData(MemberVO vo);
}
