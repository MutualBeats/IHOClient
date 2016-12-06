package vo.user;

import po.user.StaffPO;

public class StaffVO {
	/*
	 * 酒店工作人员ID
	 */
	public String staffID;
	/*
	 * 酒店工作人员姓名
	 */
	public String staffName;
	/**
	 * 
	 */
	public String contactWay;
	/*
	 * 酒店工作人员所在酒店ID
	 */
	public String hotelID;
	
	
	
	public StaffVO(String staffID, String staffName, String contactWay, String hotelID) {
		super();
		this.staffID = staffID;
		this.staffName = staffName;
		this.contactWay = contactWay;
		this.hotelID = hotelID;
	}



	public static StaffPO transformVOToPO(StaffVO vo) {
		return new StaffPO(vo.staffID ,vo.staffName, vo.contactWay, vo.hotelID);
	}

}
