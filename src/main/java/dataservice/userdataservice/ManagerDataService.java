package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ClientPO;
import po.MarketerPO;
import po.StaffPO;
import util.ResultMessage;

public interface ManagerDataService extends Remote{
	/*
	 * 获取ManagerPO内部数据
	 */
	public ClientPO findData(String ManagerID) throws RemoteException;

}
