package vo.user;

import po.user.ClientInfoChangePO;

/**
 * 
 * 信息改变VO
 * 
 * @author heleninsa
 *
 */
public class ClientInfoChangeVO {
	
	public String clientID;
	
	public String clientName;
	
	public String contactWay;

	public ClientInfoChangeVO(String clientID, String clientName, String contactWay) {
		super();
		this.clientID = clientID;
		this.clientName = clientName;
		this.contactWay = contactWay;
	}
	
	public static ClientInfoChangePO transformVOToPO(ClientInfoChangeVO vo) {
		return new ClientInfoChangePO(vo.clientID, vo.clientName, vo.contactWay);
	}
	
}
