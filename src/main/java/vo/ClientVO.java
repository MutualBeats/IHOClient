package vo;

import java.util.ArrayList;

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
	 *用户会员信息 
	 */
	private ArrayList<String> memberInfo;
	/*
	 * 构造方法
	 * @param clientID
	 * @param clientname
	 * @param tel_number
	 * @param credit
	 * @param memberInfo
	 */
	public ClientVO(String clientID, String clientname, String tel_number, int credit, ArrayList<String> memberInfo){
		this.clientID = clientID;
		this.clientname = clientname;
		this.tel_number = tel_number;
		this.credit = credit;
		this.memberInfo = memberInfo;
	}
}
