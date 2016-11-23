/**
 * @author huangxiao
 * 2016年10月15日
 */
package bussinesslogicservice.creditblservice;

import java.util.ArrayList;

import util.result_message.credit.ResultMessage_Credit;
import vo.credit.CreditVO;

public class CreditBLService_Driver {
	public void drive(CreditBLService creditBLService) {
		ResultMessage_Credit result = null;
		result = creditBLService.increaseCredit("0000000001", 100);
		if(result == ResultMessage_Credit.Credit_Increase_Successful)
			System.out.println("Client exists\n");
		else
			System.out.println("Client doesn't exist\n");
		result = creditBLService.decreaseCredit("0000000001", 100);
		if(result == ResultMessage_Credit.Credit_Decrease_Successful)
			System.out.println("Client exists\n");
		else
			System.out.println("Client doesn't exist\n");
		
		ArrayList<CreditVO> creditList = creditBLService.checkCreditRecord("0000000001");
		for (CreditVO vo : creditList)
			System.out.println(vo.clientID + '\t' + vo.changeTime + '\t' + vo.changeValue + '\t' + vo.credit + '\n');
	}
}
