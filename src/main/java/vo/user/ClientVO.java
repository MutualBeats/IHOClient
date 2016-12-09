package vo.user;

import po.user.ClientPO;
import util.resultmessage.ResultMessage_Verify;
import util.user.MemberType;

public class ClientVO extends BaseVO{
	
	/*
	 * 用户信用值
	 */
	public int credit;
	/*
	 * 用户会员类型
	 */
	public MemberType memberType;
	/*
	 * 用户会员等级
	 */
	public int level;
	/*
	 * 用户会员信息
	 */
	public String memberMessage;

	/**
	 * 构造方法
	 * @param clientID
	 * @param clientname
	 * @param contactWay
	 * @param credit
	 * @param memberType
	 * @param level
	 * @param memberMessage
	 */
	public ClientVO(String clientID, String clientName, String contactWay, int credit, MemberType memberType, int level,
			String memberMessage) {
		super(clientID, clientName, contactWay, ResultMessage_Verify.CLIENT);
		this.credit = credit;
		this.memberType = memberType;
		this.level = level;
		this.memberMessage = memberMessage;
	}

	public static ClientPO transformVOToPO(ClientVO vo) {
		return new ClientPO(vo.id, vo.name, vo.contactWay, vo.credit, vo.memberType, vo.level, vo.memberMessage);
	}
	
}
