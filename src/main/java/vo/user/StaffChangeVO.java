package vo.user;

import po.user.StaffChangePO;

public class StaffChangeVO {
	/**
	 * 酒店工作人员ID
	 */
	public String staffID;
	/**
	 * 酒店工作人员姓名
	 */
	public String staffName;
	/**
	 * Phone
	 */
	public String contactWay;

	public StaffChangeVO(String staffID, String staffName, String contactWay) {
		super();
		this.staffID = staffID;
		this.staffName = staffName;
		this.contactWay = contactWay;
	}
	
}
