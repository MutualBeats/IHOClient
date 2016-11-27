package bussinesslogicservice.userblservice;

import java.rmi.RemoteException;

import util.ResultMessage_For_User;
import vo.user.ClientVO;
import vo.user.MemberVO;

public interface ClientBLService {
	/*
	 * 获取用户信息
	 */
	public ClientVO showData (String clientID) throws RemoteException;
	/*
	 * 修改用户信息
	 */
	public ResultMessage_For_User changeData (String clientID, String clientName, String contactWay) throws RemoteException;
	/*
	 * 用户登录
	 */
	public ResultMessage_For_User Login(String clientID, String password) throws RemoteException;
	/*
	 * 注册新用户
	 */
	public ResultMessage_For_User Signup(ClientVO vo, String password) throws RemoteException;
	/*
	 * 注册会员
	 */
	public ResultMessage_For_User memberRegister (MemberVO vo)throws RemoteException;
	/*
	 * 查看会员信息
	 */
	public MemberVO showMemberData(String clientID)throws RemoteException;
	/*
	 * 更新会员信息
	 */
	public ResultMessage_For_User changeMemberData(MemberVO vo)throws RemoteException;
}
