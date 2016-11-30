package bl_test.userbl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.userbl.client.Client;
import util.resultmessage.ResultMessage_User;
import util.user.MemberType;
import vo.user.ClientVO;
import vo.user.MemberVO;

public class ClientBlTest {
	ClientVO vo1;//Valid and Not Exist
	ClientVO vo2;//Exist
	MemberVO vo00;//Valid and Not Exist
	MemberVO vo01;//Valid and Not Exist
	MemberVO vo02;//Exist
	MemberVO vo03;//Exist
	MemberVO vo04;//Exist
	Client client;
	String password;
	
	@Before
	public void init() throws RemoteException{
		vo1 = new ClientVO("12345678901", "client1", "120", 0,MemberType.Ordinary,2,"腾讯企业");
		vo2 = new ClientVO("12345678902", "client2", "110", 0,MemberType.Ordinary,2,"腾讯企业");
		vo00 = new MemberVO("12345678900",MemberType.Ordinary, 2 ,"XX");
		vo01 = new MemberVO("12345678901",MemberType.Enterprise, 2 ,"XX");
		vo02 = new MemberVO("12345678902",MemberType.Ordinary, 2,"腾讯企业");
		vo03 = new MemberVO("12345678903",MemberType.Enterprise, 2,"腾讯企业");
		vo04 = new MemberVO("12345678904",MemberType.Not, 0,"");
		client = new Client();
		password = "test";
	}
	
	@Test
	public void showDataTest() throws RemoteException{
		assertNull(client.showData("123"));
		assertNull(client.showData(vo1.clientID));
		assertEquals(vo2.contactWay, client.showData(vo2.clientID).contactWay);
	}
	
	@Test
	public void changeDataTest() throws RemoteException{
		assertEquals(ResultMessage_User.UserName_Invalid, client.changeData(vo2.clientID, "123", vo2.contactWay));
		assertEquals(ResultMessage_User.UserName_Invalid, client.changeData(vo2.clientID, "12345678901234567890", vo2.contactWay));
		assertEquals(ResultMessage_User.UpdateSuccess, client.changeData(vo2.clientID, vo1.clientName, vo2.contactWay));
	}
	
	@Test
	public void LoginTest() throws RemoteException{
		assertEquals(ResultMessage_User.UserID_Invalid, client.Login("123", password));
		assertEquals(ResultMessage_User.Account_Not_Exist, client.Login(vo1.clientID, password));
		assertEquals(ResultMessage_User.PasswordWrong, client.Login(vo2.clientID, "1234"));
		assertEquals(ResultMessage_User.LoginSuccess, client.Login(vo2.clientID, password));
	}
	
	@Test
	public void SignupTest() throws RemoteException{
		assertEquals(ResultMessage_User.UserID_Invalid, client.Signup("123", vo1.clientName, vo1.contactWay, password));
		assertEquals(ResultMessage_User.UserName_Invalid, client.Signup(vo1.clientID, "123", vo1.contactWay, password));
		assertEquals(ResultMessage_User.UserName_Invalid, client.Signup(vo1.clientID, "12345678901234567890", vo1.contactWay, password));
		assertEquals(ResultMessage_User.Account_Exist, client.Signup(vo2.clientID, vo1.clientName, vo1.contactWay, password));
		assertEquals(ResultMessage_User.AddSucccess, client.Signup(vo1.clientID, vo1.clientName, vo1.contactWay, password));
	}
	
	@Test
	public void memberRegisterTest() throws RemoteException{
		assertEquals(ResultMessage_User.BusinessMember_Exist, client.memberRegister(new MemberVO(vo02.clientID, vo00.memberType, 0, vo00.memberMessage)));
		assertEquals(ResultMessage_User.OriginalMember_Exist, client.memberRegister(new MemberVO(vo03.clientID, vo00.memberType, 0, vo00.memberMessage)));
		assertEquals(ResultMessage_User.OriginalRegisterSuccess, client.memberRegister(new MemberVO(vo04.clientID, vo00.memberType, 0, vo00.memberMessage)));
		assertEquals(ResultMessage_User.BusinessRegisterSuccess, client.memberRegister(new MemberVO(vo04.clientID, vo01.memberType, 0, vo01.memberMessage)));
	}
	
	@Test
	public void showMemberDataTest() throws RemoteException{
		assertEquals(vo02.memberMessage, client.showMemberData(vo02.clientID).memberMessage);
	}
	
	@Test
	public void changeMemberDataTest() throws RemoteException{
		assertEquals(ResultMessage_User.UpdateSuccess, client.changeMemberData(new MemberVO(vo02.clientID, vo02.memberType, 0, vo00.memberMessage)));
	}
}
