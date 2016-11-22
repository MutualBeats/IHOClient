package vo;

public class ClientVO {
	/*
	 * 用户ID
	 */
	public String clientID; 
	/*
	 * 用户姓名/名称
	 */
	public String clientname;
	/*
	 * 用户联系方式
	 */
	public String tel_number;
	/*
	 * 用户信用值
	 */
	public int credit;
	/*
	 * 用户会员ID
	 */
	public String memberID;
	/*
	 * 用户会员信息
	 */
	public String memberMessage;
	/*
	 * 用户会员等级
	 */
	public int level;
	/*
	 * 构造方法
	 * @param clientID
	 * @param clientname
	 * @param tel_number
	 * @param credit
	 * @param memberID
	 * @param memberMessage
	 * @param level
	 */
	public ClientVO(String clientID, String clientname, String tel_number, int credit, String memberID,
			String memberMessage, int level) {
		super();
		this.clientID = clientID;
		this.clientname = clientname;
		this.tel_number = tel_number;
		this.credit = credit;
		this.memberID = memberID;
		this.memberMessage = memberMessage;
		this.level = level;
	}
}
