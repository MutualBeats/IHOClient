package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ClientVO;
import po.MarketerPO;
import po.StaffPO;
import util.ResultMessage;

public interface ManagerDataService extends Remote{
	/*
	 * 获取ManagerPO内部数据
	 */
	public ClientVO findData(String ManagerID) throws RemoteException;

}
