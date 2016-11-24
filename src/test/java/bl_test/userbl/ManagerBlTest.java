package bl_test.userbl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.usebl.manager.Manager;
import util.MemberType;
import util.ResultMessage_For_Stub;
import vo.user.ClientVO;
import vo.user.MarketerVO;
import vo.user.StaffVO;

public class ManagerBlTest {
	ClientVO clientvo;
	StaffVO staffvo;
	MarketerVO marketervo;
	
	Manager manager;
	
	@Before
	public void init(){
		clientvo = new ClientVO("123456789", "admin", "1234567890", 100,MemberType.Ordinary,2,"腾讯企业");
		staffvo = new StaffVO("0000000001", "admin", "12345678");
		marketervo = new MarketerVO("0000000001", "admin", "123456789");
		
		manager = new Manager();
	}
	
	@Test
	public void testShowClientData(){
		String clientID = clientvo.clientID;
		ClientVO vo = manager .showClientData(clientID);
		assertEquals(this.clientvo.clientName, vo.clientName);
	}
	
	@Test
	public void testShowStaffData(){
		String staffID = staffvo.staffID;
		StaffVO vo = manager.showStaffData(staffID);
		assertEquals(this.staffvo.staffname, vo.staffname);
	}
	
	@Test
	public void testChangeStaffData(){
		assertEquals(ResultMessage_For_Stub.ChangeSuccess, manager.changeStaffData(this.staffvo));
	}
	
	@Test
	public void testaddStaff(){
		assertEquals(ResultMessage_For_Stub.RegisterSuccess, manager.addStaff(this.staffvo, "123456"));
	}
	
	@Test
	public void testShowMarketerData(){
		String marketerID = marketervo.marketerID;
		MarketerVO vo = manager.showMarketerData(marketerID);
		assertEquals(this.marketervo.marketername, vo.marketername);
	}
	
	@Test
	public void testChangeMarketerData(){
		assertEquals(ResultMessage_For_Stub.ChangeSuccess, manager.changeMarketerData(this.marketervo));
	}
	
	@Test
	public void testaddMarketer(){
		assertEquals(ResultMessage_For_Stub.RegisterSuccess, manager.addMarketer(this.marketervo,"123456"));
	}
}
