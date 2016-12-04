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
	/*
	 * 酒店工作人员所在酒店ID
	 */
	public String hotelID;
	/**
	 * @param staffID
	 * @param staffname
	 * @param hotelname
	 * @param hotelId
	 */
	public StaffVO(String staffID, String staffname, String hotelId) {
		super();
		this.staffID = staffID;
		this.staffName = staffname;
		this.hotelID = hotelId;
	}
	public static StaffPO transformVOToPO(StaffVO vo) {
		return new StaffPO(vo.hotelID,vo.staffName, vo.hotelID);
	}

}
