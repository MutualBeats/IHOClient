package vo;

public class StaffVO {
	/*
	 * 酒店工作人员ID
	 */
	public String staffID;
	/*
	 * 酒店工作人员姓名
	 */
	public String staffname;
	/*
	 * 酒店工作人员所在酒店
	 */
	public String hotelname;
	/*
	 * 酒店工作人员所在酒店ID
	 */
	public String hotelId;
	/**
	 * @param staffID
	 * @param staffname
	 * @param hotelname
	 * @param hotelId
	 */
	public StaffVO(String staffID, String staffname, String hotelname, String hotelId) {
		super();
		this.staffID = staffID;
		this.staffname = staffname;
		this.hotelname = hotelname;
		this.hotelId = hotelId;
	}

}
