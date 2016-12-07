package bussinesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import factory.datahelper.DataHelperFactory;
import factory.datahelper.PromotionDataHelper;
import po.promotion.DistrictPromotionPO;
import po.promotion.EnterprisePromotionPO;
import po.promotion.PromotionPO;
import util.promotion.PromotionType;
import util.resultmessage.ResultMessage_Promotion;
import vo.promotion.DistrictPromotionVO;
import vo.promotion.EnterprisePromotionVO;
import vo.promotion.PromotionVO;

public class Promotion {
	
	private PromotionDataHelper promotion_service;
	
	public Promotion() {
		try {
			promotion_service = DataHelperFactory.getDataFactoryHelperInstance().getPromotionDatabase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultMessage_Promotion addhotelPromotion(PromotionVO vo) {
		PromotionPO po;
		if(vo.type.equals(PromotionType.Enterprise))
			po = new EnterprisePromotionPO((EnterprisePromotionVO)vo);
		po = new PromotionPO(vo);
		return promotion_service.addPromotion(po);
	}

	public ResultMessage_Promotion addWebPromotion(PromotionVO vo) {
		PromotionPO po;
		if(vo.type.equals(PromotionType.BusinessDistrict))
			po = new DistrictPromotionPO((DistrictPromotionVO)vo);
		po = new PromotionPO(vo);
		return promotion_service.addPromotion(po);
	}

	public ArrayList<PromotionVO> gethotelPromotion(String hotelID) throws RemoteException {
		Iterator<PromotionPO> iterator = promotion_service.getHotelPromotion(hotelID);
		ArrayList<PromotionVO> hotelPromotionList = new ArrayList<>();
		while(iterator.hasNext()) {
			PromotionPO po = iterator.next();
			PromotionVO vo;
			if(po.getType().equals(PromotionType.Enterprise))
				vo = new EnterprisePromotionVO(po);
			vo = new PromotionVO(po);
			hotelPromotionList.add(vo);
		}
		return hotelPromotionList;
	}

	public ArrayList<PromotionVO> getWebPromotion() throws RemoteException {
		Iterator<PromotionPO> iterator = promotion_service.getWebPromotion();
		ArrayList<PromotionVO> webPromotionList = new ArrayList<>();
		while (iterator.hasNext()) {
			PromotionPO po = iterator.next();
			PromotionVO vo;
			if(po.getType().equals(PromotionType.BusinessDistrict))
				vo = new DistrictPromotionVO(po);
			vo = new PromotionVO(po);
			webPromotionList.add(vo);
		}
		return webPromotionList;
	}

	public ResultMessage_Promotion cancel(String promotionID) {
		return promotion_service.deletePromotion(promotionID);
	}

	public ArrayList<Integer> getMemberLevel() throws RemoteException {
		return promotion_service.getMemberLevel();
	}

	public ArrayList<Double> getMemberDiscount() throws RemoteException {
		return promotion_service.getMemberDiscount();
	}

	public ResultMessage_Promotion makeLevel(ArrayList<Integer> level, ArrayList<Double> discount) {
		return promotion_service.levelMake(level, discount);
	}

}
