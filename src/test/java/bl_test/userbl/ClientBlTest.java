package bl_test.userbl;

import java.rmi.RemoteException;

import org.junit.Before;

import bussinesslogic.userbl.client.Client;
import util.MemberType;
import vo.user.ClientVO;

public class ClientBlTest {

	ClientVO vo;
	Client client;
	
	@Before
	public void init() throws RemoteException{
		vo = new ClientVO("123456789", "admin", "1234567890", 100,MemberType.Ordinary,2,"腾讯企业");
		client = new Client();
	}
	

}
