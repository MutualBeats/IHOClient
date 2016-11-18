package bl_test.userbl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.usebl.manager.Manager;
import util.ResultMessage;
import vo.ClientVO;
import vo.MarketerVO;
import vo.StaffVO;

public class ManagerBlTest {
	ClientVO clientvo;
	StaffVO staffvo;
	MarketerVO marketervo;
	
	Manager manager;
	
	@Before
	public void init(){
		clientvo = new ClientVO("0000000001", "admin", "123456789", 100, new ArrayList<String>());
		staffvo = new StaffVO("0000000001", "admin", "hotel","12345678");
		marketervo = new MarketerVO("0000000001", "admin", "123456789");
		
		manager = new Manager();
	}
	
	@Test
	public void testShowClientData(){
		String clientID = clientvo.clientID;
		ClientVO vo = manager .showClientData(clientID);
		assertEquals(this.clientvo.clientname, vo.clientname);
	}
	
	@Test
	public void testShowStaffData(){
		String staffID = staffvo.staffID;
		StaffVO vo = manager.showStaffData(staffID);
		assertEquals(this.staffvo.staffname, vo.staffname);
	}
	
	@Test
	public void testChangeStaffData(){
		assertEquals(ResultMessage.ChangeSuccess, manager.changeStaffData(this.staffvo));
	}
	
	@Test
	public void testaddStaff(){
		assertEquals(ResultMessage.RegisterSuccess, manager.addStaff(this.staffvo));
	}
	
	@Test
	public void testShowMarketerData(){
		String marketerID = marketervo.marketerID;
		MarketerVO vo = manager.showMarketerData(marketerID);
		assertEquals(this.marketervo.marketername, vo.marketername);
	}
	
	@Test
	public void testChangeMarketerData(){
		assertEquals(ResultMessage.ChangeSuccess, manager.changeMarketerData(this.marketervo));
	}
	
	@Test
	public void testaddMarketer(){
		assertEquals(ResultMessage.RegisterSuccess, manager.addMarketer(this.marketervo));
	}
}
