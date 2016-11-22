package bl_test.userbl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.usebl.client.Client;
import util.ResultMessage;
import vo.ClientVO;

public class ClientBlTest {

	ClientVO vo;
	Client client;
	
	@Before
	public void init(){
		vo = new ClientVO("0000000001", "admin", "123456789", 100, "123456789","腾讯企业",2);
		client = new Client();
	}
	
	@Test
	public void testShowData(){
		String clientID = vo.clientID;
		ClientVO vo = client.showData(clientID);
		assertEquals(this.vo.clientname, vo.clientname);
	}
	
	@Test
	public void testChangeData(){
		assertEquals(ResultMessage.ChangeSuccess, client.changeData(this.vo));
	}
	
	@Test
	public void testLogin(){
		assertEquals(ResultMessage.ClientExist, client.Login(this.vo.clientID, "123456"));
	}
	
	@Test
	public void testSignup(){
		assertEquals(ResultMessage.RegisterSuccess, client.Signup(this.vo, "123456"));
	}
	
	@Test
	public void testbusinessRegister(){
		assertEquals(ResultMessage.RegisterSuccess, client.businessRegister(this.vo));
	}
	
	@Test
	public void testoriginalRegister(){
		assertEquals(ResultMessage.RegisterSuccess, client.originalRegister(this.vo));
	}
	
	@Test
	public void testget(){
		String memberID = vo.memberID;
		ClientVO vo = client.get(memberID);
		assertEquals(this.vo.memberMessage, vo.memberMessage);
	}
	
	@Test
	public void testlevelUpdate(){
		assertEquals(ResultMessage.UpdateSucceed, client.levelUpdate(new ArrayList<Integer>(), 1));
	}
	
	@Test
	public void testupdate(){
		String memberID = vo.memberID;
		assertEquals(ResultMessage.UpdateSucceed, client.update(memberID, vo));
	}
}
