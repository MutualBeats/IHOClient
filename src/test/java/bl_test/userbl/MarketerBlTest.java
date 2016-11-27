package bl_test.userbl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.rmi.RemoteException;

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
	public void init() throws RemoteException{
		vo1 = new MarketerVO("0000000011", "营销人员03", "12345678901");
		vo2 = new MarketerVO("0000000002", "营销人员02", "120");
		marketer = new Marketer();
		password = "test";
	}
	
	@Test
	public void LoginTest() throws RemoteException{
		assertEquals(ResultMessage_For_User.UserID_Invalid, marketer.Login("123", password));
		assertEquals(ResultMessage_For_User.PasswordWrong, marketer.Login(vo2.marketerID, "1234"));
		assertEquals(ResultMessage_For_User.Account_Not_Exist, marketer.Login(vo1.marketerID, password));
		assertEquals(ResultMessage_For_User.LoginSuccess, marketer.Login(vo2.marketerID, password));
	}
	
	@Test
	public void showDataTest() throws RemoteException{
		assertNull(marketer.showData("123"));
		assertNull(marketer.showData(vo1.marketerID));
		assertEquals(vo2.contactWay, marketer.showData(vo2.marketerID).contactWay);
	}
	
	@Test
	public void changeDataTest() throws RemoteException{
		assertEquals(ResultMessage_For_User.UserName_Invalid, marketer.changeData(new MarketerVO(vo2.marketerID,"123", vo2.contactWay)));
		assertEquals(ResultMessage_For_User.UserName_Invalid, marketer.changeData(new MarketerVO(vo2.marketerID,"12345678901234567890", vo2.contactWay)));
		assertEquals(ResultMessage_For_User.UpdateSuccess, marketer.changeData(vo2));
	}
	
	@Test
	public void addMarketerTest() throws RemoteException{
		assertEquals(ResultMessage_For_User.UserID_Invalid, marketer.addMarketer(new MarketerVO("123", vo1.marketername,vo1.contactWay), password));
		assertEquals(ResultMessage_For_User.UserName_Invalid, marketer.addMarketer(new MarketerVO(vo1.marketerID, "123",vo1.contactWay), password));
		assertEquals(ResultMessage_For_User.UserName_Invalid, marketer.addMarketer(new MarketerVO(vo1.marketerID, "12345678901234567890",vo1.contactWay), password));
		assertEquals(ResultMessage_For_User.Account_Exist, marketer.addMarketer(vo2, password));
		assertEquals(ResultMessage_For_User.AddSucccess, marketer.addMarketer(vo1, password));
	}
}
