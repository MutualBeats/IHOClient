package po.user;

import java.io.Serializable;

import vo.user.StaffChangeVO;

public class StaffChangePO implements Serializable{

	/**
	 * ID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 酒店工作人员ID
	 */
	private String staffID;
	/**
	 * 酒店工作人员姓名
	 */
	private String staffName;
	/**
	 * Phone
	 */
	private String contactWay;
	
	public StaffChangePO(String staffID, String staffName, String contactWay) {
		super();
		this.staffID = staffID;
		this.staffName = staffName;
		this.contactWay = contactWay;
	}
	
	public StaffChangePO(StaffChangeVO vo) {
		this(vo.staffID, vo.staffName, vo.contactWay);
	}

	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getContactWay() {
		return contactWay;
	}

	public void setContactWay(String contactWay) {
		this.contactWay = contactWay;
	}
	
	
	
}
