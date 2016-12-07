package bl_test.userbl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.userbl.manager.Manager;
import util.resultmessage.ResultMessage_User;
import util.user.MemberType;
import vo.user.ClientVO;
import vo.user.ManagerVO;
import vo.user.MarketerVO;
import vo.user.StaffChangeVO;
import vo.user.StaffVO;

public class ManagerBlTest {
	ClientVO clientvo1;//Valid and Not Exist
	ClientVO clientvo2;//Exist
	StaffVO staffvo1;// Valid and Not Exist
	StaffVO staffvo2;// Exist
	MarketerVO marketervo1;// Valid and Not Exist
	MarketerVO marketervo2;// Exist
	
	ManagerVO vo;
	Manager manager;
	String password;
	
	@Before
	public void init() throws RemoteException{
		clientvo1 = new ClientVO("12345678901", "client1", "120", 0,MemberType.Ordinary,2,"腾讯企业");
		clientvo2 = new ClientVO("12345678902", "client2", "110", 0,MemberType.Ordinary,2,"腾讯企业");
		staffvo1 = new StaffVO("STF0000011", "staff3","12345678901","12345678");
		staffvo2 = new StaffVO("STF0000002", "staff2", "12345678901","00000002");
		marketervo1 = new MarketerVO("20161130011", "营销人员03", "12345678901");
		marketervo2 = new MarketerVO("20161130002", "营销人员02", "120");
		
		vo = new ManagerVO("0000000001", "administrator", "12345678901");
		manager = new Manager();
		password = "test";
	}

	@Test
	public void showClientDataTest() throws RemoteException{
//		assertNull(manager.showClientData("123"));
		try {
			assertNull(manager.showClientData(clientvo1.clientID));
			assertEquals(clientvo2.contactWay, manager.showClientData(clientvo2.clientID).contactWay);
		} catch (Exception e) {
		}
		
	}
	
	@Test
	public void showStaffDataTest() {
		try {
			assertNull(manager.showStaffData(staffvo1.staffID));
			assertEquals(staffvo2.hotelID, manager.showStaffData(staffvo2.staffID).hotelID);
//			assertNull(manager.showStaffData("123"));
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}
	
	@Test
	public void changeDataTest() {
		try {
//			assertEquals(ResultMessage_User.UserName_Invalid, manager.changeStaffData(new StaffVO(staffvo2.staffID,"12345678901234567890", staffvo2.hotelID)));
			StaffChangeVO vo = new StaffChangeVO(staffvo2.staffID, staffvo2.staffName, staffvo2.contactWay);
			assertEquals(ResultMessage_User.UpdateSuccess, manager.changeStaffData(vo));
//			assertEquals(ResultMessage_User.UserName_Invalid, manager.changeStaffData(new StaffVO(staffvo2.staffID,"123", staffvo2.hotelID)));
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}
	
	
	@Test
	public void showMarketerDataTest() {
		try {
//			assertNull(manager.showMarketerData("123"));
			assertNull(manager.showMarketerData(marketervo1.marketerID));
			assertEquals(marketervo2.contactWay, manager.showMarketerData(marketervo2.marketerID).contactWay);
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}
	
	@Test
	public void changeMarketerDataTest() {
		try {
//			assertEquals(ResultMessage_User.UserName_Invalid, manager.changeMarketerData(new MarketerVO(marketervo2.marketerID,"123", marketervo2.contactWay)));
//			assertEquals(ResultMessage_User.UserName_Invalid, manager.changeMarketerData(new MarketerVO(marketervo2.marketerID,"12345678901234567890", marketervo2.contactWay)));
			assertEquals(ResultMessage_User.UpdateSuccess, manager.changeMarketerData(marketervo2));
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}
	
	@Test
	public void addMarketerTest() {
		try {
//			assertEquals(ResultMessage_User.UserName_Invalid, manager.addMarketer( new MarketerVO(marketervo1.marketerID,"123",marketervo1.contactWay) ,password));
//			assertEquals(ResultMessage_User.UserName_Invalid, manager.addMarketer( new MarketerVO(marketervo1.marketerID,"12345678901234567890",marketervo1.contactWay), password));
			assertEquals(ResultMessage_User.AddSucccess, manager.addMarketer(marketervo1, password));
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}
	
	
}
