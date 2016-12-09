package vo.user;

import po.user.ClientRegistPO;

/**
 * 
 * 用户注册VO
 * 
 * @author heleninsa
 *
 */
public class ClientRegistVO {

	public String id;
	public String name;
	public String contactWay;
	public String psw;

	public ClientRegistVO(String id, String name, String contactWay, String psw) {
		super();
		this.id = id;
		this.name = name;
		this.contactWay = contactWay;
		this.psw = psw;
	}

	public static ClientRegistPO transformVOToPO(ClientRegistVO vo) {
		return new ClientRegistPO(vo.id, vo.name, vo.contactWay, vo.psw);
	}

}
