/**
 * @author huangxiao
 * 2016年10月15日
 */
package bussinesslogicservice.creditblservice;

import java.util.Iterator;

import util.result_message.credit.ResultMessage_CreditBL;
import vo.credit.CreditVO;

public class CreditBLService_Driver {
	public void drive(CreditBLService creditBLService) {
		ResultMessage_CreditBL result = null;
		result = creditBLService.increaseCredit("0000000001", 100);
		if(result == ResultMessage_CreditBL.Credit_Increase_Successful)
			System.out.println("Client exists\n");
		else
			System.out.println("Client doesn't exist\n");
		result = creditBLService.decreaseCredit("0000000001", 100);
		if(result == ResultMessage_CreditBL.Credit_Decrease_Successful)
			System.out.println("Client exists\n");
		else
			System.out.println("Client doesn't exist\n");
		
		Iterator<CreditVO> creditList = creditBLService.checkCreditRecord("0000000001");
		while(creditList.hasNext()) {
			CreditVO vo = creditList.next();
			System.out.println(vo.clientID + '\t' + vo.changeTime + '\t' + vo.changeValue + '\t' + vo.credit + '\n');
		}
	}
}
