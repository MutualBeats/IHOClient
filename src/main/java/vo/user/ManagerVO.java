package vo.user;

public class ManagerVO {
	/**
	 * 网站管理人员ID
	 */
	public String managerID;
	/**
	 * 网站营销管理人员姓名
	 */
	public String managerName;
	/**
	 * 电话
	 */
	public String contactWay;
	
	
	public ManagerVO(String managerID, String managerName, String contactWay) {
		super();
		this.managerID = managerID;
		this.managerName = managerName;
		this.contactWay = contactWay;
	}
	
	
	
}
