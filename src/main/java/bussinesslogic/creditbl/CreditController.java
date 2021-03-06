package bussinesslogic.creditbl;

import java.util.ArrayList;

import bussinesslogic.orderbl.CreditUpdate;
import bussinesslogic.userbl.client.CreditRegister;
import bussinesslogicservice.creditblservice.CreditBLService;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Credit;
import vo.credit.CreditVO;

public class CreditController implements CreditBLService, CreditUpdate, CreditRegister{
	
	private Credit credit = new Credit();
	
	public CreditController() throws NetException{}

	@Override
	public ArrayList<CreditVO> checkCreditRecord(String clientID) throws NetException {
		return credit.checkCreditRecord(clientID);
	}



	@Override
	public ResultMessage_Credit creditUpdate(CreditVO updateVO) {
		return credit.creditUpdate(updateVO);
	}


	@Override
	public ResultMessage_Credit addCreditRegister(String clientID) {
		return credit.addCreditRegister(clientID);
	}

	
}
