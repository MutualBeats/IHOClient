package vo;

public class MemberVO {
	public String memberID;
	public String memberMessage;
	public int level;
	/**
	 * @param memberID
	 * @param memberMessage
	 * @param level
	 */
	public MemberVO(String memberID, String memberMessage, int level) {
		super();
		this.memberID = memberID;
		this.memberMessage = memberMessage;
		this.level = level;
	}
	
}