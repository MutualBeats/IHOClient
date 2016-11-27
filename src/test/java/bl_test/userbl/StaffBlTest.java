package bl_test.userbl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.usebl.staff.Staff;
import util.ResultMessage_For_User;
import vo.user.StaffVO;

public class StaffBlTest {
	StaffVO vo1;// Valid and Not Exist
	StaffVO vo2;// Exist
	Staff staff;
	String password;
	
	@Before
	public void init(){
		vo1 = new StaffVO("0000000001", "administrator","12345678");
		vo2 = new StaffVO("0000000002", "administrator","12345678");
		staff = new Staff();
		password = "123456";
	}
	
	@Test
	public void LoginTest(){
		assertEquals(ResultMessage_For_User.UserID_Invalid, staff.Login("123", password));
		assertEquals(ResultMessage_For_User.Account_Not_Exist, staff.Login(vo1.staffID, password));
		assertEquals(ResultMessage_For_User.PasswordWrong, staff.Login(vo2.staffID, "1234"));
		assertEquals(ResultMessage_For_User.LoginSuccess, staff.Login(vo2.staffID, password));
	}
	
	@Test
	public void showDataTest(){
		assertNull(staff.showData("123"));
		assertNull(staff.showData(vo1.staffID));
		assertEquals(vo2.hotelId, staff.showData(vo2.staffID).hotelId);
	}
	
	@Test
	public void changeDataTest(){
		assertEquals(ResultMessage_For_User.UserName_Invalid, staff.changeData(new StaffVO(vo2.staffID,"123", vo2.hotelId)));
		assertEquals(ResultMessage_For_User.UserName_Invalid, staff.changeData(new StaffVO(vo2.staffID,"12345678901234567890", vo2.hotelId)));
		assertEquals(ResultMessage_For_User.UpdateSuccess, staff.changeData(vo2));
	}
	
	@Test
	public void addMarketerTest(){
		assertEquals(ResultMessage_For_User.UserID_Invalid, staff.addStaff(new StaffVO("123", vo1.staffname,vo1.hotelId), password));
		assertEquals(ResultMessage_For_User.UserName_Invalid, staff.addStaff(new StaffVO(vo1.staffID, "123",vo1.hotelId), password));
		assertEquals(ResultMessage_For_User.UserName_Invalid, staff.addStaff(new StaffVO(vo1.staffID, "12345678901234567890",vo1.hotelId), password));
		assertEquals(ResultMessage_For_User.Hotel_Not_Exist, staff.addStaff(new StaffVO(vo1.staffID,vo1.staffname,"123"), password));
		assertEquals(ResultMessage_For_User.Hotel_Have_Staff, staff.addStaff(new StaffVO(vo1.staffID,vo1.staffname,vo2.hotelId), password));
		assertEquals(ResultMessage_For_User.Account_Exist, staff.addStaff(vo2, password));
		assertEquals(ResultMessage_For_User.AddSucccess, staff.addStaff(vo1, password));
	}
}
