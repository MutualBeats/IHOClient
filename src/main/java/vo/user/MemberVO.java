package vo.user;

import util.user.MemberType;

public class MemberVO {
	/*
	 * 用户ID
	 */
	public String clientID;
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
	 * @param memberType
	 * @param level
	 * @param memberMessage
	 */
	public MemberVO(String clientID, MemberType memberType, int level, String memberMessage) {
		super();
		this.clientID = clientID;
		this.memberType = memberType;
		this.level = level;
		this.memberMessage = memberMessage;
	}
}
