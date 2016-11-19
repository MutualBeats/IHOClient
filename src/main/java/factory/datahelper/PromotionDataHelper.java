package factory.datahelper;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.promotiondataservice.PromotionDataService;
import po.MemberPO;
import po.PromotionPO;
import util.ResultMessage;

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
	public ResultMessage hotelAdd(PromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage webAdd(PromotionPO po) throws RemoteException {
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
	public void levelMake(PromotionPO po, MemberPO po2) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
