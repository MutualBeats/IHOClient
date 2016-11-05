package po;

import java.util.ArrayList;

public class ClientPO {
	/*
	 * 用户ID
	 */
	private String clientID; 
	/*
	 * 用户姓名/名称
	 */
	private String clientname;
	/*
	 * 用户联系方式
	 */
	private String tel_number;
	/*
	 * 用户信用值
	 */
	private int credit;
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
	public ClientPO(String clientID, String clientname, String tel_number, int credit, ArrayList<String> memberInfo){
		this.clientID = clientID;
		this.clientname = clientname;
		this.tel_number = tel_number;
		this.credit = credit;
		this.memberInfo = memberInfo;
	}
	public ArrayList<String> getMemberInfo() {
		return memberInfo;
	}
	public void setMemberInfo(ArrayList<String> memberInfo) {
		this.memberInfo = memberInfo;
	}
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	public String getClientname() {
		return clientname;
	}
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	public String getTel_number() {
		return tel_number;
	}
	public void setTel_number(String tel_number) {
		this.tel_number = tel_number;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
}
