package bussinesslogicservice.utildataservice;

import util.resultmessage.ResultMessage_Verify;

public interface Identify {
	
	public ResultMessage_Verify login(String user_name, String password);
	
	public ResultMessage_Verify checkUserName(String user_name);
	
}
