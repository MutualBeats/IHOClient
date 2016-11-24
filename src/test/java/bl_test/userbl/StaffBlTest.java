package bl_test.userbl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.usebl.staff.Staff;
import vo.user.StaffVO;

public class StaffBlTest {
	StaffVO vo;
	Staff staff;
	
	@Before
	public void init(){
		vo = new StaffVO("0000000001", "admin","12345678");
		staff = new Staff();
	}
	
	@Test
	public void testShowData(){
		String staffID = vo.staffID;
		StaffVO vo = staff.showData(staffID);
		assertEquals(this.vo.staffname, vo.staffname);
	}
}
