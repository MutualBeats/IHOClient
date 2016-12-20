package factory.datahelper;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import dataservice.creditdataservice.CreditDataService;
import po.credit.CreditPO;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Credit;
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
	
	/**
	 * 信用更新
	 * 
	 * @param vo
	 * @return
	 */
	public ResultMessage_Credit creditUpdate(CreditVO vo) {
		//Check local data
		try {
			checkAndUpdateCache(vo.clientID);
		} catch (NetException e) {
			return ResultMessage_Credit.Credit_Net_Error;
		}
		//Change Create
		CreditPO i_po = new CreditPO(vo);
		//Count current credit
		int after_credit = credit_record_cache.get(0).getCredit() + vo.changeValue;
		i_po.setCredit(after_credit);
		return insert(i_po);
	}
	
	public ResultMessage_Credit creditRegist(CreditVO vo) {
		return insert(new CreditPO(vo));
	}
	
	private ResultMessage_Credit insert(CreditPO po) {
		// Cache Update
		credit_record_cache.add(0, po);
		// TODO : 留给结束模块、异常模块完成
		ResultMessage_Credit insert_result = ResultMessage_Credit.Update_Successful;
		try {
			insert_result = data_service.insert(po);
		} catch (NetException e) {
			System.err.println("Fail To Update Credit");
			e.printStackTrace();
			return ResultMessage_Credit.Credit_Net_Error;
		}
		return insert_result;
	}

	public ArrayList<CreditVO> find(String clientID) throws NetException {
		checkAndUpdateCache(clientID);
		// Copy And Change To VO.
		ArrayList<CreditVO> record_copy = new ArrayList<>();
		for (Iterator<CreditPO> it = credit_record_cache.iterator(); it.hasNext();) {
			record_copy.add(new CreditVO(it.next()));
		}
		return record_copy;
	}

	public CreditPO getNewestCredit(String clientID) throws NetException {
		checkAndUpdateCache(clientID);
		// Return a copy right;
		return CreditPO.copy(credit_record_cache.get(0));
	}

	/**
	 * To Check the Cache State And Update it.
	 * 
	 * @param clientID
	 * @throws RemoteException 
	 */
	private void checkAndUpdateCache(String clientID) throws NetException {
		if (checkOldCache(clientID)) {
			credit_record_cache = data_service.find(clientID);
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
