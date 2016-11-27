package vo.user;

public class ManagerVO {
	/*
	 * 网站管理人员ID
	 */
	public String managerID;
	/*
	 * 网站营销管理人员姓名
	 */
	public String managerName;
	/*
	 * 构造方法
	 * @param managerID
	 * @param managername
	 */
	public ManagerVO(String managerID, String managername) {
		super();
		this.managerID = managerID;
		this.managerName = managername;
	}

}
