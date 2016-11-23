package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.StaffPO;
import util.ResultMessage_For_Stub;

public interface StaffDataService extends Remote{
	/*
	 * 获取StaffPO内部数据
	 */
	public StaffPO findData(String StaffID) throws RemoteException;
	/*
	 * 在数据库中更新一个StaffPO记录
	 */
	public ResultMessage_For_Stub updateData(StaffPO po) throws RemoteException;
	/*
	 * 检测是否允许登陆
	 */
	public ResultMessage_For_Stub find(String ID, String password) throws RemoteException;
	/*
	 * 在数据库中生成一个staffPO记录
	 */
	public ResultMessage_For_Stub insert(StaffPO po, String password) throws RemoteException;
}
