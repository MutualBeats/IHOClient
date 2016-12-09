package bussinesslogicservice.userblservice;

import util.exception.NetException;
import vo.user.MarketerVO;

public interface MarketerBLService {
	
	public MarketerVO showData (String marketerID) throws NetException;
}
