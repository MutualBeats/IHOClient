package bussinesslogic.usebl.marketer;

import bussinesslogic.usebl.manager.entrust.Marketer2Manager;
import bussinesslogicservice.userblservice.MarketerBLService;
import util.ResultMessage_For_Stub;
import vo.MarketerVO;

public class MarketerController implements MarketerBLService , Marketer2Manager {
	
	private Marketer marketer = new Marketer();

	@Override
	public ResultMessage_For_Stub Login(String ID, String password) {
		return marketer.Login(ID, password);
	}

	@Override
	public MarketerVO showData(String marketerID) {
		return marketer.showData(marketerID);
	}
	
	@Override
	public ResultMessage_For_Stub changeData(MarketerVO vo) {
		return marketer.changeData(vo);
	}

	@Override
	public ResultMessage_For_Stub addMarketer(MarketerVO vo, String password) {
		return marketer.addMarketer(vo, password);
	}


}
