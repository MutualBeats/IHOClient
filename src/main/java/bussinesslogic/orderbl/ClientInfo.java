package bussinesslogic.orderbl;

import util.exception.NetException;
import vo.user.ClientVO;

public interface ClientInfo {
	
	public ClientVO getClientInfo(String clientID) throws NetException;
	
}
