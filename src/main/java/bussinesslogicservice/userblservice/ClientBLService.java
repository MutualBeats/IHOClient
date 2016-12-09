package bussinesslogicservice.userblservice;

import java.rmi.RemoteException;

import util.resultmessage.ResultMessage_User;
import vo.user.ClientInfoChangeVO;
import vo.user.ClientRegistVO;
import vo.user.ClientVO;
import vo.user.MemberVO;

public interface ClientBLService {
	
	/**
	 * 用户注册
	 * 
	 * @param registVO
	 * @param password
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage_User regist(ClientRegistVO info);
	/**
	 * 获取用户信息
	 * 
	 * @param clientID
	 * @return
	 * @throws RemoteException
	 */
	public ClientVO getClientInfo (String clientID) throws RemoteException;
	/**
	 * 修改用户信息
	 * 
	 * @param vo
	 * @return
	 */
	public ResultMessage_User changeClientInfo (ClientInfoChangeVO vo);
	/**
	 * 注册会员
	 * 
	 * @param vo
	 * @return
	 */
	public ResultMessage_User registerMember (MemberVO vo);

}
