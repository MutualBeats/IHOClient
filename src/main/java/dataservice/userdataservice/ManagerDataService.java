package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.user.ManagerPO;

public interface ManagerDataService extends Remote{

	public ManagerPO getManagerInfor() throws RemoteException;
	
}
