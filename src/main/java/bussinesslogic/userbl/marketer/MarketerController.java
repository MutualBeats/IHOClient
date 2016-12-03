package bussinesslogic.userbl.marketer;

import java.rmi.RemoteException;

import bussinesslogic.userbl.manager.entrust.Marketer2Manager;
import bussinesslogicservice.userblservice.MarketerBLService;
import util.resultmessage.ResultMessage_User;
import vo.user.MarketerVO;

public class MarketerController implements MarketerBLService , Marketer2Manager {
	
	private Marketer marketer = new Marketer();

	@Override
	public ResultMessage_User Login(String marketerID, String password) {
		return marketer.Login(marketerID, password);
	}

	@Override
	public MarketerVO showData(String marketerID) throws RemoteException {
		return marketer.showData(marketerID);
	}
	
	@Override
	public ResultMessage_User changeData(MarketerVO vo) {
		return marketer.changeData(vo);
	}

	@Override
	public ResultMessage_User addMarketer(MarketerVO vo, String password) {
		return marketer.addMarketer(vo, password);
	}


}
