package bussinesslogicservice.userblservice;

import util.exception.NetException;
import vo.user.MarketerVO;

public class MarketerBLStub implements MarketerBLService{

	@Override
	public MarketerVO showData(String marketerID) throws NetException {
		return new MarketerVO("testmarketer", "Test", "12345678900");
	}

}
