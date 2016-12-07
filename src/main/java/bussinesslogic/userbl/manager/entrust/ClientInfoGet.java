package bussinesslogic.userbl.manager.entrust;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.resultmessage.ResultMessage_User;
import vo.user.ClientInfoChangeVO;
import vo.user.ClientVO;

public interface ClientInfoGet {
	
	/**
	 * 获取用户信息
	 * 
	 * @param clientID
	 * @return
	 * @throws RemoteException
	 */
	public ClientVO getClientInfo(String clientID) throws RemoteException;
	
	/**
	 * 获取用户列表
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<ClientVO> getClientList() throws RemoteException;
	
	/**
	 * 更改用户信息
	 * 
	 * @param vo
	 * @return
	 */
	public ResultMessage_User changeClientInfo(ClientInfoChangeVO vo);
	
}
