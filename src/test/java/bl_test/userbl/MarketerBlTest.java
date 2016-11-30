package bl_test.userbl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.userbl.marketer.Marketer;
import util.resultmessage.ResultMessage_User;
import vo.user.MarketerVO;

public class MarketerBlTest {
	MarketerVO vo1;// Valid and Not Exist
	MarketerVO vo2;// Exist
	Marketer marketer;
	String password;
	
	@Before
	public void init() {
		vo1 = new MarketerVO("20161130011", "营销人员03", "12345678901");
		vo2 = new MarketerVO("20161130002", "营销人员02", "120");
		try {
			marketer = new Marketer();
		} catch (Exception e) {
		}
		password = "test";
	}
	
	@Test
	public void LoginTest() {
		try {
			assertEquals(ResultMessage_User.UserID_Invalid, marketer.Login("123", password));
			assertEquals(ResultMessage_User.PasswordWrong, marketer.Login(vo2.marketerID, "1234"));
			assertEquals(ResultMessage_User.Account_Not_Exist, marketer.Login(vo1.marketerID, password));
			assertEquals(ResultMessage_User.LoginSuccess, marketer.Login(vo2.marketerID, password));
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}
	
	@Test
	public void showDataTest() {
		try {
			assertNull(marketer.showData("123"));
			assertNull(marketer.showData(vo1.marketerID));
			assertEquals(vo2.contactWay, marketer.showData(vo2.marketerID).contactWay);
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}
	
	@Test
	public void changeDataTest() {
		try {
			assertEquals(ResultMessage_User.UserName_Invalid, marketer.changeData(new MarketerVO(vo2.marketerID,"123", vo2.contactWay)));
			assertEquals(ResultMessage_User.UserName_Invalid, marketer.changeData(new MarketerVO(vo2.marketerID,"12345678901234567890", vo2.contactWay)));
			assertEquals(ResultMessage_User.UpdateSuccess, marketer.changeData(vo2));
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}
	
	@Test
	public void addMarketerTest() {
		try {
			assertEquals(ResultMessage_User.UserName_Invalid, marketer.addMarketer( "123",vo1.contactWay, password));
			assertEquals(ResultMessage_User.UserName_Invalid, marketer.addMarketer( "12345678901234567890",vo1.contactWay, password));
			assertEquals(ResultMessage_User.AddSucccess, marketer.addMarketer(vo1.marketerName, vo1.contactWay, password));
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}
}
