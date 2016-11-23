package bussinesslogicservice.creditblservice;

import java.util.ArrayList;

import util.CreditChangeAction;
import util.result_message.credit.ResultMessage_Credit;
import vo.credit.CreditVO;

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
	public ResultMessage_Credit increaseCredit(String clientID, int value) {
		if(clientID.equals("0000000001"))
			return ResultMessage_Credit.Credit_Increase_Successful;
		else return ResultMessage_Credit.Credit_Increase_Failed;
	}

	// 减少客户信用
	@Override
	public ResultMessage_Credit decreaseCredit(String clientID, int value) {
		if(clientID.equals("0000000001"))
			return ResultMessage_Credit.Credit_Decrease_Successful;
		else return ResultMessage_Credit.Credit_Decrease_Failed;
	}

	// 信用记录界面得到客户的信用历史记录
	@Override
	public ArrayList<CreditVO> checkCreditRecord(String clientID) {
		ArrayList<CreditVO> creditList = new ArrayList<CreditVO>();
		creditList.add(new CreditVO(clientID, changeTime, changeValue, credit, CreditChangeAction.ExecuteOrder, clientID));
		return creditList;
	}

}
