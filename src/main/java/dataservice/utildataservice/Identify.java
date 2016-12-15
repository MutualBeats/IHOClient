package dataservice.utildataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import util.resultmessage.ResultMessage_Verify;

public interface Identify extends Remote{
	
	public ResultMessage_Verify login(String user_name, String password) throws RemoteException;
	
	/**
	 * 检查用户名是否重叠
	 * 
	 * @param user_name
	 * @return
	 */
	public ResultMessage_Verify checkUserName(String user_name) throws RemoteException;
	
	/**
	 * 检查身份
	 * 
	 * @param user_name
	 * @return
	 */
	public ResultMessage_Verify checkIdentity(String user_name) throws RemoteException; 
	
}
