package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.MarketerPO;
import util.ResultMessage_For_User;

public interface MarketerDataService extends Remote{
	/*
	 * 获取MarketerPO内部数据
	 */
	public MarketerPO findData(String MarketerID) throws RemoteException;
	/*
	 * 在数据库中更新一个MarketerPO记录
	 */
	public ResultMessage_For_User updateData(MarketerPO po) throws RemoteException;
	/*
	 * 检测是否允许登陆
	 */
	public ResultMessage_For_User find(String ID, String password) throws RemoteException;
	/*
	 * 在数据库中生成一个marketerPO记录
	 */
	public ResultMessage_For_User insert (MarketerPO po, String password) throws RemoteException;
}
