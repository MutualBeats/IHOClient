package vo.user;

import util.MemberType;

public class ClientVO {
	/*
	 * 用户ID
	 */
	public String clientID;
	/*
	 * 用户姓名/名称
	 */
	public String clientName;
	/*
	 * 用户联系方式
	 */
	public String contactWay;
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
		super();
		this.clientID = clientID;
		this.clientName = clientName;
		this.contactWay = contactWay;
		this.credit = credit;
		this.memberType = memberType;
		this.level = level;
		this.memberMessage = memberMessage;
	}
	
}
