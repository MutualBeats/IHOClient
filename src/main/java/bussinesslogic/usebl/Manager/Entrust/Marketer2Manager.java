package bussinesslogic.usebl.manager.entrust;

import util.ResultMessage_For_Stub;
import vo.MarketerVO;

public interface Marketer2Manager {
	/*
	 * 获取网站营销人员信息
	 */
	public MarketerVO showData (String marketerID);
	/*
	 * 修改网站营销人员信息
	 */
	public ResultMessage_For_Stub changeData (MarketerVO vo);
	/*
	 * 添加网站营销人员
	 */
	public ResultMessage_For_Stub addMarketer(MarketerVO vo, String password);
}
