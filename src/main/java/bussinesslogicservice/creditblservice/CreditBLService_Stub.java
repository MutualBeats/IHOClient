package bussinesslogicservice.creditblservice;

import java.util.ArrayList;

import util.result_message.credit.ResultMessage_CreditBLService;
import vo.CreditVO;

public class CreditBLService_Stub implements CreditBLService {
	
	public String clientID;
	public String changeTime;
	public int changeValue;
	public int credit;
	
	public CreditBLService_Stub(String clientID, String changeTime, int changeValue, int credit) {
		this.clientID = clientID;
		this.changeTime = changeTime;
		this.changeValue = changeValue;
		this.credit = credit;
	}
	
	// 增加客户信用
	@Override
	public ResultMessage_CreditBLService increaseCredit(String clientID, int value) {
		if(clientID.equals("0000000001"))
			return ResultMessage_CreditBLService.Credit_Increase_Successful;
		else return ResultMessage_CreditBLService.Credit_Increase_Failed;
	}

	// 减少客户信用
	@Override
	public ResultMessage_CreditBLService decreaseCredit(String clientID, int value) {
		if(clientID.equals("0000000001"))
			return ResultMessage_CreditBLService.Credit_Decrease_Successful;
		else return ResultMessage_CreditBLService.Credit_Decrease_Failed;
	}

	// 信用记录界面得到客户的信用历史记录
	@Override
	public ArrayList<CreditVO> checkCreditRecord(String clientID) {
		ArrayList<CreditVO> creditList = new ArrayList<CreditVO>();
		creditList.add(new CreditVO(clientID, changeTime, changeValue, credit));
		return creditList;
	}

}
