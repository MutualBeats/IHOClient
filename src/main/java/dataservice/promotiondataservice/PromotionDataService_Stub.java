/**
 * @author huangxiao
 * @version 2016年12月24日
 */
package dataservice.promotiondataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.promotion.PromotionPO;
import util.promotion.PromotionType;
import util.resultmessage.ResultMessage_Promotion;

public class PromotionDataService_Stub implements PromotionDataService {
	
	private static final int PROMOTION_ID_LENGTH = 6;
	private static final int MAX_VIP_LEVEL = 3;

	private ArrayList<Integer> memberLevel;
	
	private ArrayList<Double> discount;
	
	private PromotionPO po;
	
	public PromotionDataService_Stub() {
		memberLevel = new ArrayList<>();
		memberLevel.add(512);
		memberLevel.add(2048);
		memberLevel.add(8192);

		discount = new ArrayList<>();
		discount.add(10.0);
		discount.add(9.5);
		discount.add(9.0);
		discount.add(8.5);
		
		po = new PromotionPO();
		po.setPromotionID("000001");
		po.setPromotionName("测试限时普通促销策略");
		po.setDiscount(discount);
		po.setHotelID("");
		po.setStartDate("2016/11/01");
		po.setFinishDate("2016/11/02");
		po.setType(PromotionType.Holiday);

	}

	@Override
	public String addPromotion(PromotionPO po) throws RemoteException {		
		return "100000";
	}

	@Override
	public ArrayList<PromotionPO> getHotelPromotion(String hotelID) throws RemoteException {
		ArrayList<PromotionPO> promotionList = new ArrayList<>();
		po.setHotelID(hotelID);
		promotionList.add(po);
		return promotionList;
	}

	@Override
	public ArrayList<PromotionPO> getWebPromotion() throws RemoteException {
		ArrayList<PromotionPO> promotionList = new ArrayList<>();
		po.setHotelID("");
		promotionList.add(po);
		return promotionList;
	}

	@Override
	public PromotionPO getPromotionById(String promotionID) throws RemoteException {
		po.setPromotionID(promotionID);
		return po;
	}

	@Override
	public ResultMessage_Promotion deletePromotion(String promotionID) throws RemoteException {
		if(promotionID.length() != PROMOTION_ID_LENGTH)
			return ResultMessage_Promotion.Promotion_Not_Exist;
		return ResultMessage_Promotion.Delete_Successful;
	}

	@Override
	public ArrayList<Integer> getMemberLevel() throws RemoteException {
		return memberLevel;
	}

	@Override
	public ArrayList<Double> getMemberDiscount() throws RemoteException {
		return discount;
	}

	@Override
	public ResultMessage_Promotion levelMake(ArrayList<Integer> level, ArrayList<Double> discount)
			throws RemoteException {
		if(level.size() != MAX_VIP_LEVEL - 1 || discount.size() != MAX_VIP_LEVEL)
			return null;
		return ResultMessage_Promotion.Level_Make_Successful;
	}

}
