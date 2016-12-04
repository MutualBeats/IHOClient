package bussinesslogic.userbl.marketer;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogic.userbl.manager.entrust.MarketerManage;
import bussinesslogicservice.userblservice.MarketerBLService;
import util.resultmessage.ResultMessage_User;
import vo.user.MarketerVO;

public class MarketerController implements MarketerBLService , MarketerManage {
	
	private Marketer marketer = new Marketer();

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

	@Override
	public ArrayList<MarketerVO> getMarketerList() throws RemoteException {
		return marketer.getMarketerList();
	}


}
