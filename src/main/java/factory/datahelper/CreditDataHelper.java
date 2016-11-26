package factory.datahelper;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import dataservice.creditdataservice.CreditDataService;
import dataservice.creditdataservice.ResultMessage_Credit;
import po.credit.CreditChangePO;
import po.credit.CreditPO;
import util.result_message.credit.ResultMessage_CreditBL;
import vo.credit.CreditVO;

/**
 * @author Saltwater Data Helper : Store some information as cache . Own same
 *         function And hide the return.
 */
public class CreditDataHelper {
	/**
	 * The turly data service
	 */
	private CreditDataService data_service;

	/**
	 * Local Cache for Credit in Client
	 */
	private ArrayList<CreditPO> credit_record_cache = new ArrayList<>();

	public CreditDataHelper(CreditDataService data_service) {
		this.data_service = data_service;
	}

	public ResultMessage_CreditBL increase(CreditChangePO po) {
		return creditChange(po);
	}

	public ResultMessage_CreditBL decrease(CreditChangePO po) {
		return creditChange(po);
	}

	private ResultMessage_CreditBL creditChange(CreditChangePO po) {
		//Check local data
		checkAndUpdateCache(po.getClientID());
		//Change Create
		CreditPO i_po = new CreditPO();
		i_po.setAction();
		i_po.setChangeTime(po.getChangeTime());
		i_po.setClientID(po.getClientID());
		i_po.setChangeValue(po.getChangeValue());
		//Count current credit
		int after_credit = credit_record_cache.get(0).getCredit() + po.getChangeValue();
		i_po.setCredit(after_credit);
		return insert(i_po);
	}

	private ResultMessage_CreditBL insert(CreditPO po) {
		// Cache Update
		credit_record_cache.add(po);
		// TODO : 留给结束模块、异常模块完成
		ResultMessage_Credit insert_result = ResultMessage_Credit.Update_Successful;
		try {
			insert_result = data_service.insert(po);
		} catch (RemoteException e) {
			System.err.println("Fail To Update Credit");
			e.printStackTrace();
			return ResultMessage_CreditBL.Credit_Net_Error;
		}
		if (insert_result.equals(ResultMessage_Credit.Update_Successful)) {
			return ResultMessage_CreditBL.Credit_Increase_Successful;
		} else {
			return ResultMessage_CreditBL.Credit_User_Not_Found;
		}
	}

	public Iterator<CreditVO> find(String clientID) {
		checkAndUpdateCache(clientID);
		// Copy And Change To VO.
		ArrayList<CreditVO> record_copy = new ArrayList<>();
		for (Iterator<CreditPO> it = credit_record_cache.iterator(); it.hasNext();) {
			record_copy.add(new CreditVO(it.next()));
		}
		return record_copy.iterator();
	}

	public CreditPO getNewestCredit(String clientID) {
		checkAndUpdateCache(clientID);
		// Return a copy right;
		return CreditPO.copy(credit_record_cache.get(0));
	}

	/**
	 * To Check the Cache State And Update it.
	 * 
	 * @param clientID
	 */
	private void checkAndUpdateCache(String clientID) {
		if (checkOldCache(clientID)) {
			try {
				credit_record_cache = data_service.find(clientID);
			} catch (RemoteException e) {
				System.err.println("Fail to Connect the Credit Database Service. Please check your Internet");
				e.printStackTrace();
			}
		}
	}

	/**
	 * To Check the Cache and Make Sure the Info Match Well
	 * 
	 * @param clientID
	 * @return Nesessity for cache update
	 */
	private boolean checkOldCache(String clientID) {
		if (credit_record_cache.isEmpty()) {
			return true;
		}
		CreditPO po = credit_record_cache.get(0);
		return !po.getClientID().equals(clientID);
	}

}
