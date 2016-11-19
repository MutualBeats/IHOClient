package factory.datahelper;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import dataservice.creditdataservice.CreditDataService;
import po.CreditChangePO;
import po.CreditPO;
import vo.CreditVO;

/**
 * @author Saltwater
 * Data Helper : 
 * 	Store some information as cache .
 * 	Own same function
 */
public class CreditDataHelper {
	/**
	 *  The turly data service
	 */
	private CreditDataService data_service;
	
	/**
	 *  Local Cache for Credit in Client
	 */
	private ArrayList<CreditPO> credit_record_cache = new ArrayList<>();
	
	public CreditDataHelper(CreditDataService data_service) {
		this.data_service = data_service;
	}
	
	public void increase(CreditChangePO po) {
		creditChange(po);
	}
	
	public void decrease(CreditChangePO po) {
		creditChange(po);
	}
	
	private void creditChange(CreditChangePO po) {
		CreditPO i_po = new CreditPO();
		i_po.setChangeTime(po.getChangeTime());
		i_po.setClientID(po.getClientID());
		i_po.setChangeValue(po.getChangeValue());
		int after_credit = i_po.getCredit() + po.getChangeValue();
		i_po.setCredit(after_credit);
		insert(i_po);
	}
	
	private void insert(CreditPO po) {
		checkAndUpdateCache(po.getClientID());
		//Cache Update
		credit_record_cache.add(po);
		//TODO : 留给结束模块、异常模块完成
		try {
			data_service.insert(po);
		} catch (RemoteException e) {
			System.err.println("Fail To Update Credit");
			e.printStackTrace();
		}
	}
	

	public ArrayList<CreditVO> find(String clientID) {
		checkAndUpdateCache(clientID);
		//Copy And Change To VO.
		ArrayList<CreditVO> record_copy = new ArrayList<>();
		for(Iterator<CreditPO> it = credit_record_cache.iterator(); it.hasNext();) {
			record_copy.add(new CreditVO(it.next()));
		}
		return record_copy;
	}
	
	public CreditPO getNewestCredit(String clientID) {
		checkAndUpdateCache(clientID);
		//Return a copy right;
		return CreditPO.copy(credit_record_cache.get(0));
	}
	
	/**
	 *  To Check the Cache State And Update it.
	 * 
	 * @param clientID
	 */
	private void checkAndUpdateCache(String clientID) {
		if(checkOldCache(clientID)) {
			try {
				credit_record_cache = data_service.find(clientID);
			} catch (RemoteException e) {
				System.err.println("Fail to Connect the Credit Database Service");
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
		if(credit_record_cache.isEmpty()) {
			return true;
		}
		CreditPO po = credit_record_cache.get(0);
		return !po.getClientID().equals(clientID);
	}

}
