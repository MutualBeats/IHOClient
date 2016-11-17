package bussinesslogic.usebl.Marketer;

import bussinesslogic.usebl.Manager.Entrust.Marketer2Manager;
import bussinesslogicservice.userblservice.MarketerBLService;
import util.ResultMessage;
import vo.MarketerVO;

public class MarketerController implements MarketerBLService , Marketer2Manager {

	@Override
	public ResultMessage Login(String ID, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MarketerVO showData(String marketerID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ResultMessage changeData(MarketerVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addMarketer(MarketerVO vo) {
		// TODO Auto-generated method stub
		return null;
	}


}
