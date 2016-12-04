package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.user.ClientInfoChangePO;
import po.user.ClientPO;
import po.user.MemberPO;
import util.resultmessage.ResultMessage_User;

public interface ClientDataService extends Remote {
	/**
	 * 查询用户
	 * 
	 * @param clientID
	 * @return
	 * @throws RemoteException
	 */
	public ClientPO queryClient(String clientID) throws RemoteException;

	/**
	 * 更新用户信息
	 * 
	 * @param changePO
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage_User updateClientInfo(ClientInfoChangePO changePO) throws RemoteException;

	/**
	 * Register Member
	 * 
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage_User registerMember(MemberPO po) throws RemoteException;

}
