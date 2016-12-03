package bussinesslogic.userbl.manager.entrust;

import java.rmi.RemoteException;

import util.resultmessage.ResultMessage_User;
import vo.user.MarketerVO;

public interface Marketer2Manager {
	/*
	 * 获取网站营销人员信息
	 */
	public MarketerVO showData (String marketerID) throws RemoteException;
	/*
	 * 修改网站营销人员信息
	 */
	public ResultMessage_User changeData (MarketerVO vo) ;
	/*
	 * 添加网站营销人员
	 */
	public ResultMessage_User addMarketer(MarketerVO vo, String password) ;
}
