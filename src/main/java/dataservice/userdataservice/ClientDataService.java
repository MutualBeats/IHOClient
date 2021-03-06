package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.user.ClientInfoChangePO;
import po.user.ClientPO;
import po.user.ClientRegistPO;
import po.user.MemberPO;
import util.resultmessage.ResultMessage_User;

/**
 * 
 * CLIENT DATA SERVICE
 * 
 * @author heleninsa
 *
 */
public interface ClientDataService extends Remote {

	/**
	 * 用户注册
	 * 
	 * @param po
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage_User regist(ClientRegistPO po) throws RemoteException;

	/**
	 * 查询用户
	 * 
	 * @param clientID
	 * @return ClientPO
	 * @throws RemoteException
	 */
	public ClientPO queryClient(String clientID) throws RemoteException;

	/**
	 * 更新用户信息
	 * 
	 * @param changePO
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage_User updateClientInfo(ClientInfoChangePO changePO) throws RemoteException;

	/**
	 * Register Member
	 * 
	 * @param po
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage_User registerMember(MemberPO po) throws RemoteException;

	/**
	 * Get all the client info
	 * 
	 * @return ArrayList<ClientPO>
	 * @throws RemoteException
	 */
	public ArrayList<ClientPO> getClientList() throws RemoteException;

}
