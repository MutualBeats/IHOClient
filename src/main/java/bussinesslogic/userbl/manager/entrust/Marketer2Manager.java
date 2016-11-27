package bussinesslogic.userbl.manager.entrust;

import java.rmi.RemoteException;

import util.ResultMessage_For_User;
import vo.user.MarketerVO;

public interface Marketer2Manager {
	/*
	 * 获取网站营销人员信息
	 */
	public MarketerVO showData (String marketerID) throws RemoteException;
	/*
	 * 修改网站营销人员信息
	 */
	public ResultMessage_For_User changeData (MarketerVO vo) throws RemoteException;
	/*
	 * 添加网站营销人员
	 */
	public ResultMessage_For_User addMarketer(String marketerName, String contactWay, String password) throws RemoteException;
}
