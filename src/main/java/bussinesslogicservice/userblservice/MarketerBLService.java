package bussinesslogicservice.userblservice;

import java.rmi.RemoteException;

import util.resultmessage.ResultMessage_User;
import vo.user.MarketerVO;

public interface MarketerBLService {
	
	public MarketerVO showData (String marketerID) throws RemoteException;
}
