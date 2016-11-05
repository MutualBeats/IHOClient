package bussinesslogicservice.userblservice;

import vo.MarketerVO;

public interface MarketerBLService {
	/*
	 * 获取网站营销人员信息
	 */
	public MarketerVO showData (String marketerID);
}
