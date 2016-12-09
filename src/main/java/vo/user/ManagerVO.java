package vo.user;

import po.user.ManagerPO;
import util.resultmessage.ResultMessage_Verify;

public class ManagerVO extends BaseVO{
	
	public ManagerVO(String managerID, String managerName, String contactWay) {
		super(managerID, managerName, contactWay, ResultMessage_Verify.MARKETER);
	}
	
	public static ManagerPO transformVOToPO(ManagerVO vo) {
		return new ManagerPO(vo.id, vo.name, vo.contactWay);
	}
	
	
}
