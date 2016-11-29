package bl_test.userbl;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.userbl.manager.Manager;
import util.resultmessage.ResultMessage_User;
import util.user.MemberType;
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
	public void init() throws RemoteException{
		clientvo = new ClientVO("123456789", "admin", "1234567890", 100,MemberType.Ordinary,2,"腾讯企业");
		staffvo = new StaffVO("0000000001", "admin", "12345678");
		marketervo = new MarketerVO("0000000001", "admin", "123456789");
		
		vo = new ManagerVO("0000000001", "administrator");
		manager = new Manager();
		password = "123456";
	}
	
	@Test
	public void LoginTest() throws RemoteException{
		assertEquals(ResultMessage_User.UserID_Invalid, manager.Login("123", password));
		assertEquals(ResultMessage_User.UserID_Invalid, manager.Login("12345678901234567890", password));
		assertEquals(ResultMessage_User.Account_Not_Exist, manager.Login("1234567890", password));
		assertEquals(ResultMessage_User.PasswordWrong, manager.Login(vo.managerID, "123"));
		assertEquals(ResultMessage_User.LoginSuccess, manager.Login(vo.managerID, password));
	}
}
