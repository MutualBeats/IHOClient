package bl_test.userbl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.userbl.staff.Staff;
import util.resultmessage.ResultMessage_User;
import vo.user.StaffVO;

public class StaffBlTest {
	StaffVO vo1;// Valid and Not Exist
	StaffVO vo2;// Exist
	Staff staff;
	String password;
	
	@Before
	public void init() {
		vo1 = new StaffVO("STF0000011", "staff3","12345678");
		vo2 = new StaffVO("STF0000002", "staff2","00000002");
		try {
			staff = new Staff();
		} catch (Exception e) {
		}
		password = "test";
	}
	
	@Test
	public void LoginTest() {
		try {
//		assertEquals(ResultMessage_User.UserID_Invalid, staff.Login("123", password));
		assertEquals(ResultMessage_User.Account_Not_Exist, staff.Login(vo1.staffID, password));
		assertEquals(ResultMessage_User.PasswordWrong, staff.Login(vo2.staffID, "1234"));
		assertEquals(ResultMessage_User.LoginSuccess, staff.Login(vo2.staffID, password));
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}
	
	@Test
	public void showDataTest() {
		try {
			assertNull(staff.showData(vo1.staffID));
			assertEquals(vo2.hotelID, staff.showData(vo2.staffID).hotelID);
//			assertNull(staff.showData("123"));
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}
	
	@Test
	public void changeDataTest() {
		try {
//			assertEquals(ResultMessage_User.UserName_Invalid, staff.changeData(new StaffVO(vo2.staffID,"12345678901234567890", vo2.hotelID)));
			assertEquals(ResultMessage_User.UpdateSuccess, staff.changeData(vo2));
//			assertEquals(ResultMessage_User.UserName_Invalid, staff.changeData(new StaffVO(vo2.staffID,"123", vo2.hotelID)));
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}
	
	@Test
	public void addStaffTest() {
		try {
//			assertEquals(ResultMessage_User.UserName_Invalid, staff.addStaff( "123",vo1.hotelID, password));
//			assertEquals(ResultMessage_User.UserName_Invalid, staff.addStaff( "12345678901234567890",vo1.hotelID, password));
//			assertEquals(ResultMessage_User.HotelID_Invalid, staff.addStaff( vo1.staffName,"123", password));
			assertEquals(ResultMessage_User.Hotel_Not_Exist, staff.addStaff(vo1.staffName,"12345678", password));
			assertEquals(ResultMessage_User.Hotel_Have_Staff, staff.addStaff(vo1.staffName,vo2.hotelID, password));
			assertEquals(ResultMessage_User.AddSucccess, staff.addStaff(vo1.staffName, vo1.hotelID, password));
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}
}
