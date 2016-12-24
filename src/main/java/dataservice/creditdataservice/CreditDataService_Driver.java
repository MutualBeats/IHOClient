/**
 * @author huangxiao
 */
package dataservice.creditdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.credit.CreditPO;
import util.Time;
import util.credit.CreditChangeAction;
import util.resultmessage.ResultMessage_Credit;

public class CreditDataService_Driver {
	
	public void drive(CreditDataService creditDataService) throws RemoteException {
		
		// 添加信用记录
		CreditPO po = new CreditPO();
		po.setClientID("huangxiao");
		po.setOrderID("");
		po.setAction(CreditChangeAction.Deposit);
		po.setChangeTime(Time.getCurrentTime());
		po.setChangeValue(1024);
		po.setCredit(1024);
		
		ResultMessage_Credit result = creditDataService.insert(po);
		System.out.println(result.toString());
		
		// 查找信用记录
		ArrayList<CreditPO> creditList = creditDataService.find("huangxiao");
		System.out.println("Find " + creditList.size() + " credit records.");
	
	}

}
