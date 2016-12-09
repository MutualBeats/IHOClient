package bl_test.userbl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.userbl.staff.Staff;
import util.resultmessage.ResultMessage_User;
import vo.user.StaffChangeVO;
import vo.user.StaffVO;

public class StaffBlTest {
	StaffVO vo1;// Valid and Not Exist
	StaffVO vo2;// Exist
	Staff staff;
	String password;
	
	@Before
	public void init() {
		vo1 = new StaffVO("STF0000011", "staff3", "12345678901","12345678");
		vo2 = new StaffVO("STF0000002", "staff2", "12345678901","00000002");
		try {
			staff = new Staff();
		} catch (Exception e) {
		}
		password = "test";
	}
	
	@Test
	public void showDataTest() {
		try {
			assertNull(staff.showData(vo1.id));
			assertEquals(vo2.hotelID, staff.showData(vo2.id).hotelID);
//			assertNull(staff.showData("123"));
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}
	
	@Test
	public void changeDataTest() {
		try {
//			assertEquals(ResultMessage_User.UserName_Invalid, staffchangeData(new StaffVO(vo2.staffID,"12345678901234567890", vo2.hotelID)));
			StaffChangeVO vo = new StaffChangeVO(vo2.id, vo2.name, vo2.contactWay);
			assertEquals(ResultMessage_User.UpdateSuccess, staff.changeData(vo));
//			assertEquals(ResultMessage_User.UserName_Invalid, staff.changeData(new StaffVO(vo2.staffID,"123", vo2.hotelID)));
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}
	

}
