package vo;

public class ManagerVO {
	/*
	 * 网站管理人员ID
	 */
	private String managerID;
	/*
	 * 网站营销管理人员姓名
	 */
	private String managername;
	/*
	 * 构造方法
	 * @param managerID
	 * @param managername
	 */
	public ManagerVO(String managerID, String managername) {
		super();
		this.managerID = managerID;
		this.managername = managername;
	}
	public String getManagerID() {
		return managerID;
	}
	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}
}
