/**
 * @author huangxiao
 * @version 2016年12月24日
 */
package dataservice.creditdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.credit.CreditPO;
import util.Time;
import util.credit.CreditChangeAction;
import util.resultmessage.ResultMessage_Credit;

public class CreditDataService_Stub implements CreditDataService {

	private CreditPO po;
	
	public CreditDataService_Stub() {
		po = new CreditPO();
		po.setClientID("huangxiao");
		po.setOrderID("");
		po.setAction(CreditChangeAction.Deposit);
		po.setChangeTime(Time.getCurrentTime());
		po.setChangeValue(1024);
		po.setCredit(1024);
	}
	
	@Override
	public ResultMessage_Credit insert(CreditPO po) throws RemoteException {
		return ResultMessage_Credit.Update_Successful;
	}

	@Override
	public ArrayList<CreditPO> find(String clientID) throws RemoteException {
		ArrayList<CreditPO> creditList = new ArrayList<>();
		po.setClientID(clientID);
		creditList.add(po);
		return creditList;
	}

}
