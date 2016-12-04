package bussinesslogicservice.userblservice;

import java.rmi.RemoteException;

import util.resultmessage.ResultMessage_User;
import vo.user.ClientInfoChangeVO;
import vo.user.ClientVO;
import vo.user.MemberVO;

public interface ClientBLService {
	/*
	 * 获取用户信息
	 */
	public ClientVO getClientInfo (String clientID) throws RemoteException;
	/*
	 * 修改用户信息
	 */
	public ResultMessage_User changeClientInfo (ClientInfoChangeVO vo);
	/*
	 * 注册会员
	 */
	public ResultMessage_User registerMember (MemberVO vo);

}
