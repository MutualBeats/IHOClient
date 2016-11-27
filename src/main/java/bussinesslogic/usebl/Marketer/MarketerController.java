package bussinesslogic.usebl.marketer;

import java.rmi.RemoteException;

import bussinesslogic.usebl.manager.entrust.Marketer2Manager;
import bussinesslogicservice.userblservice.MarketerBLService;
import util.ResultMessage_For_User;
import vo.user.MarketerVO;

public class MarketerController implements MarketerBLService , Marketer2Manager {
	
	private Marketer marketer;
	
	public MarketerController() throws RemoteException{
		marketer = new Marketer();
	}

	@Override
	public ResultMessage_For_User Login(String marketerID, String password) throws RemoteException {
		return marketer.Login(marketerID, password);
	}

	@Override
	public MarketerVO showData(String marketerID) throws RemoteException {
		return marketer.showData(marketerID);
	}
	
	@Override
	public ResultMessage_For_User changeData(MarketerVO vo) throws RemoteException {
		return marketer.changeData(vo);
	}

	@Override
	public ResultMessage_For_User addMarketer(MarketerVO vo, String password) throws RemoteException {
		return marketer.addMarketer(vo, password);
	}


}
