package factory.datahelper;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.promotiondataservice.PromotionDataService;
import po.promotion.PromotionPO;
import po.user.ClientPO;
import util.resultmessage.ResultMessage_Promotion;

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
	public ResultMessage_Promotion hotelAdd(PromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage_Promotion webAdd(PromotionPO po) throws RemoteException {
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
