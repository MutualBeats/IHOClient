package bussinesslogic.orderbl;

import util.exception.NetException;
import vo.user.ClientVO;

/**
 * 
 * 客户信息接口
 * 
 * @author heleninsa
 *
 */
public interface ClientInfo {
	
	/**
	 * 获取客户信息
	 * @param clientID
	 * @return
	 * @throws NetException
	 */
	public ClientVO getClientInfo(String clientID) throws NetException;
	
}
