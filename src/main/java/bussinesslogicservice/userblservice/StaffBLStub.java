package bussinesslogicservice.userblservice;

import util.exception.NetException;
import vo.user.StaffVO;

public class StaffBLStub implements StaffBLService{

	@Override
	public StaffVO showData(String staffID) throws NetException {
		return new StaffVO("test_staff", "Test", "12345678900", "00000001");
	}

}
