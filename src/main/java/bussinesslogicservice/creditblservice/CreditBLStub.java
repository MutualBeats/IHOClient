package bussinesslogicservice.creditblservice;

import java.util.ArrayList;

import util.credit.CreditChangeAction;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Credit;
import vo.credit.CreditVO;

public class CreditBLStub implements CreditBLService{
	
	@Override
	public ResultMessage_Credit creditUpdate(CreditVO updateVO) {
		if(updateVO.action == CreditChangeAction.Register) {
			System.out.println("Register");
		} else if(updateVO.credit < 0 && updateVO.action == CreditChangeAction.PutUpOrder){
			return ResultMessage_Credit.Credit_Too_Low;
		}
			return ResultMessage_Credit.Update_Successful;
	}

	@Override
	public ArrayList<CreditVO> checkCreditRecord(String clientID) throws NetException {
		if(clientID.equals("test_client")) {
			CreditVO zero = new CreditVO(clientID, "2016/11/15 23:59:59", 0, 0, CreditChangeAction.Register, "");
			CreditVO one = new CreditVO(clientID, "2016/11/16 23:59:59", 1000, 1000, CreditChangeAction.Deposit, "");
			CreditVO two = new CreditVO(clientID, "2016/11/18 23:59:59", 5000, 6000, CreditChangeAction.Deposit, "");
			CreditVO three = new CreditVO(clientID, "2016/11/19 23:59:59", -4000, 2000, CreditChangeAction.AppealOrder, "0000000000000001");
			ArrayList<CreditVO> record = new ArrayList<>();
			record.add(three);
			record.add(two);
			record.add(one);
			record.add(zero);
			return record;
		}
		return new ArrayList<>();
	}

}
