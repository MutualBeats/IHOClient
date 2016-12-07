package dataservice.utildataservice;

import util.resultmessage.ResultMessage_Verify;

public interface Identify {
	
	public ResultMessage_Verify login(String user_name, String password);
	
	/**
	 * 检查
	 * 
	 * @param user_name
	 * @return
	 */
	public ResultMessage_Verify checkUserName(String user_name);
	
	public ResultMessage_Verify checkIdentity(String user_name); 
	
}
