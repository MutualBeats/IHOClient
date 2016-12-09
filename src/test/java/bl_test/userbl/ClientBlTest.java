package bl_test.userbl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogic.userbl.client.Client;
import util.exception.NetException;
import util.resultmessage.ResultMessage_User;
import util.user.MemberType;
import vo.user.ClientInfoChangeVO;
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
		try {
			client = new Client(ControllerFactory.getCreditRegister());
		} catch (Exception e) {
			e.printStackTrace();
		}
		password = "test";
	}
	
	@Test
	public void showDataTest() throws NetException {
//		assertNull(client.showData("123"));
		assertNull(client.getClientInfo(vo1.id));
		assertEquals(vo2.contactWay, client.getClientInfo(vo2.id).contactWay);
	}
	
	@Test
	public void changeDataTest() throws RemoteException{
//		assertEquals(ResultMessage_User.UserName_Invalid, client.changeData(vo2.clientID, "123", vo2.contactWay));
//		assertEquals(ResultMessage_User.UserName_Invalid, client.changeData(vo2.clientID, "12345678901234567890", vo2.contactWay));
		ClientInfoChangeVO vo = new ClientInfoChangeVO(vo2.id, vo1.name, vo2.contactWay);
		assertEquals(ResultMessage_User.UpdateSuccess, client.changeClientInfo(vo));
	}
	
	
	@Test
	public void memberRegisterTest() throws RemoteException{
		assertEquals(ResultMessage_User.BusinessMember_Exist, client.memberRegister(new MemberVO(vo02.clientID, vo00.memberType, 0, vo00.memberMessage)));
		assertEquals(ResultMessage_User.OriginalMember_Exist, client.memberRegister(new MemberVO(vo03.clientID, vo00.memberType, 0, vo00.memberMessage)));
		assertEquals(ResultMessage_User.Register_Success, client.memberRegister(new MemberVO(vo04.clientID, vo00.memberType, 0, vo00.memberMessage)));
		assertEquals(ResultMessage_User.Register_Success, client.memberRegister(new MemberVO(vo04.clientID, vo01.memberType, 0, vo01.memberMessage)));
	}
	
}
