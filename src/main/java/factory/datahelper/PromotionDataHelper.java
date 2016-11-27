package factory.datahelper;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.promotiondataservice.PromotionDataService;
import po.ClientPO;
import po.promotion.PromotionPO;
import util.ResultMessage_For_Stub;

public class PromotionDataHelper implements PromotionDataService{

	private PromotionDataService promotion_service;
	
	/**
	 * @param promotion_service
	 */
	public PromotionDataHelper(PromotionDataService promotion_service) {
		super();
		this.promotion_service = promotion_service;
	}

	@Override
	public ResultMessage_For_Stub hotelAdd(PromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage_For_Stub webAdd(PromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionPO> hotelLook(String hotelId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionPO> webLook() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void levelMake(PromotionPO po, ClientPO po2) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
