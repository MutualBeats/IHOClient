package bussinesslogicservice.userblservice;

import util.exception.NetException;
import vo.user.StaffVO;

public interface StaffBLService {
	
	public StaffVO showData(String staffID) throws NetException;
	
}
