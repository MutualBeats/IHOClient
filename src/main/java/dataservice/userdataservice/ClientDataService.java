package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ClientVO;
import util.ResultMessage;

public interface ClientDataService extends Remote{
	/*
	 * 获取ClientPO内部数据
	 */
	public ClientVO findData(String ClientID) throws RemoteException;
	/*
	 * 在数据库中更新一个ClientPO记录
	 */
	public ResultMessage updateData(ClientVO po) throws RemoteException;
	/*
	 * 检测是否允许登陆
	 */
	public ResultMessage find(String ID, String password) throws RemoteException;
	/*
	 * 在数据库中生成一个clientPO记录
	 */
	public ResultMessage insert(ClientVO po, String password) throws RemoteException;
}
