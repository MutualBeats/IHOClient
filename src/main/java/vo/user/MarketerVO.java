package vo.user;

import po.user.MarketerPO;

/**
 * 
 * Marketer
 * 
 * @author heleninsa
 *
 */
public class MarketerVO {
	/*
	 * 网站营销人员ID
	 */
	public String marketerID;
	/*
	 * 网站营销人员姓名
	 */
	public String marketerName;
	/*
	 * 网站营销人员联系方式
	 */
	public String contactWay;
	
	
	
	public MarketerVO(String marketerID, String marketerName, String contactWay) {
		super();
		this.marketerID = marketerID;
		this.marketerName = marketerName;
		this.contactWay = contactWay;
	}



	public static MarketerPO transformVOToPO(MarketerVO vo) {
		return new MarketerPO(vo.marketerID, vo.marketerName, vo.contactWay);
	}
}
