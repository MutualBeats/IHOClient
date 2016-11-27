package bl_test.userbl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.usebl.manager.Manager;
import util.MemberType;
import util.ResultMessage_For_User;
import vo.user.ClientVO;
import vo.user.ManagerVO;
import vo.user.MarketerVO;
import vo.user.StaffVO;

public class ManagerBlTest {
	ClientVO clientvo;
	StaffVO staffvo;
	MarketerVO marketervo;
	
	ManagerVO vo;
	Manager manager;
	String password;
	
	@Before
	public void init(){
		clientvo = new ClientVO("123456789", "admin", "1234567890", 100,MemberType.Ordinary,2,"腾讯企业");
		staffvo = new StaffVO("0000000001", "admin", "12345678");
		marketervo = new MarketerVO("0000000001", "admin", "123456789");
		
		vo = new ManagerVO("0000000001", "administrator");
		manager = new Manager();
		password = "123456";
	}
	
	@Test
	public void LoginTest(){
		assertEquals(ResultMessage_For_User.UserID_Invalid, manager.Login("123", password));
		assertEquals(ResultMessage_For_User.UserID_Invalid, manager.Login("12345678901234567890", password));
		assertEquals(ResultMessage_For_User.Account_Not_Exist, manager.Login("1234567890", password));
		assertEquals(ResultMessage_For_User.PasswordWrong, manager.Login(vo.managerID, "123"));
		assertEquals(ResultMessage_For_User.LoginSuccess, manager.Login(vo.managerID, password));
	}
}
