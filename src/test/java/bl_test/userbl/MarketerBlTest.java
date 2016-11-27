package bl_test.userbl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.usebl.marketer.Marketer;
import util.ResultMessage_For_User;
import vo.user.MarketerVO;

public class MarketerBlTest {
	MarketerVO vo1;// Valid and Not Exist
	MarketerVO vo2;// Exist
	Marketer marketer;
	String password;
	
	@Before
	public void init(){
		vo1 = new MarketerVO("0000000001", "administrator", "12345678901");
		vo2 = new MarketerVO("0000000002", "administrator", "12345678901");
		marketer = new Marketer();
		password = "123456";
	}
	
	@Test
	public void LoginTest(){
		assertEquals(ResultMessage_For_User.UserID_Invalid, marketer.Login("123", password));
		assertEquals(ResultMessage_For_User.UserID_Invalid, marketer.Login("12345678901234567890", password));
		assertEquals(ResultMessage_For_User.PasswordWrong, marketer.Login(vo2.marketerID, "1234"));
		assertEquals(ResultMessage_For_User.Account_Not_Exist, marketer.Login(vo1.marketerID, password));
		assertEquals(ResultMessage_For_User.LoginSuccess, marketer.Login(vo2.marketerID, password));
	}
	
	@Test
	public void showDataTest(){
		assertEquals(null, marketer.showData("123"));
		assertEquals(null, marketer.showData("12345678901234567890"));
		assertEquals(null, marketer.showData(vo1.marketerID));
		assertEquals(vo2.tel_number, marketer.showData(vo2.marketerID).tel_number);
	}
	
	@Test
	public void changeDataTest(){
		assertEquals(ResultMessage_For_User.UserName_Invalid, marketer.changeData(new MarketerVO(vo2.marketerID,"123", vo2.tel_number)));
		assertEquals(ResultMessage_For_User.UserName_Invalid, marketer.changeData(new MarketerVO(vo2.marketerID,"12345678901234567890", vo2.tel_number)));
		assertEquals(ResultMessage_For_User.Tel_Invalid, marketer.changeData(new MarketerVO(vo2.marketerID, vo2.marketername, "123")));
		assertEquals(ResultMessage_For_User.UpdateSuccess, marketer.changeData(vo2));
	}
	
	@Test
	public void addMarketerTest(){
		assertEquals(ResultMessage_For_User.UserID_Invalid, marketer.addMarketer(new MarketerVO("123", vo1.marketername,vo1.tel_number), password));
		assertEquals(ResultMessage_For_User.UserID_Invalid, marketer.addMarketer(new MarketerVO("12345678901234567890", vo1.marketername,vo1.tel_number), password));
		assertEquals(ResultMessage_For_User.UserName_Invalid, marketer.addMarketer(new MarketerVO(vo1.marketerID, "123",vo1.tel_number), password));
		assertEquals(ResultMessage_For_User.UserName_Invalid, marketer.addMarketer(new MarketerVO(vo1.marketerID, "12345678901234567890",vo1.tel_number), password));
		assertEquals(ResultMessage_For_User.Tel_Invalid, marketer.addMarketer(new MarketerVO(vo1.marketerID, vo1.marketername, "123"), password));
		assertEquals(ResultMessage_For_User.Account_Exist, marketer.addMarketer(vo2, password));
		assertEquals(ResultMessage_For_User.AddSucccess, marketer.addMarketer(vo1, password));
	}
}
