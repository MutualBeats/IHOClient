package dataservice.userdataservice;

import java.rmi.Remote;

import po.user.ManagerPO;
import util.exception.NetException;
import util.resultmessage.ResultMessage_User;

public interface ManagerDataService extends Remote{

	public ManagerPO getManagerInfo() throws NetException;
	
	public ResultMessage_User changeManagerInfo(ManagerPO po) throws NetException;
	
}
