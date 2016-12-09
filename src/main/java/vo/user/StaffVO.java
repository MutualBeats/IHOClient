package vo.user;

import po.user.StaffPO;
import util.resultmessage.ResultMessage_Verify;

public class StaffVO extends BaseVO{
	/*
	 * 酒店工作人员所在酒店ID
	 */
	public String hotelID;
	
	public StaffVO(String staffID, String staffName, String contactWay, String hotelID) {
		super(staffID, staffName, contactWay, ResultMessage_Verify.STAFF);
		this.hotelID = hotelID;
	}

	public static StaffPO transformVOToPO(StaffVO vo) {
		return new StaffPO(vo.id ,vo.name, vo.contactWay, vo.hotelID);
	}

}
