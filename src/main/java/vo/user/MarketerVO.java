package vo.user;

import po.user.MarketerPO;
import util.resultmessage.ResultMessage_Verify;

/**
 * 
 * Marketer
 * 
 * @author heleninsa
 *
 */
public class MarketerVO extends BaseVO{
	
	
	
	public MarketerVO(String marketerID, String marketerName, String contactWay) {
		super(marketerID, marketerName, contactWay, ResultMessage_Verify.MARKETER);
	}



	public static MarketerPO transformVOToPO(MarketerVO vo) {
		return new MarketerPO(vo.id, vo.name, vo.contactWay);
	}
}
