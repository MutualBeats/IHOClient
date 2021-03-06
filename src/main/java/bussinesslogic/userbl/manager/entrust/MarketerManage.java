package bussinesslogic.userbl.manager.entrust;

import java.util.ArrayList;

import util.exception.NetException;
import util.resultmessage.ResultMessage_User;
import vo.user.MarketerVO;

public interface MarketerManage {
	/*
	 * 获取网站营销人员信息
	 */
	public MarketerVO showData (String marketerID) throws NetException;
	/*
	 * 修改网站营销人员信息
	 */
	public ResultMessage_User changeData (MarketerVO vo) ;
	/*
	 * 添加网站营销人员
	 */
	public ResultMessage_User addMarketer(MarketerVO vo, String password) ;

	public ArrayList<MarketerVO> getMarketerList() throws NetException;
}
