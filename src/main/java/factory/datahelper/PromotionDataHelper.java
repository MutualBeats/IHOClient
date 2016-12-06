package factory.datahelper;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.promotiondataservice.PromotionDataService;
import po.promotion.PromotionPO;
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

	/* (non-Javadoc)
	 * @see dataservice.promotiondataservice.PromotionDataService#addPromotion(po.promotion.PromotionPO)
	 */
	@Override
	public ResultMessage_Promotion addPromotion(PromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see dataservice.promotiondataservice.PromotionDataService#getHotelPromotion(java.lang.String)
	 */
	@Override
	public ArrayList<PromotionPO> getHotelPromotion(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see dataservice.promotiondataservice.PromotionDataService#getWebPromotion()
	 */
	@Override
	public ArrayList<PromotionPO> getWebPromotion() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see dataservice.promotiondataservice.PromotionDataService#deletePromotion(java.lang.String)
	 */
	@Override
	public ResultMessage_Promotion deletePromotion(String promotionID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see dataservice.promotiondataservice.PromotionDataService#levelMake(java.util.ArrayList)
	 */
	@Override
	public ResultMessage_Promotion levelMake(ArrayList<Integer> level, ArrayList<Double> discount) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


}
