package bussinesslogic.promotionbl;

import java.util.ArrayList;
import java.util.Iterator;

import factory.datahelper.DataHelperFactory;
import factory.datahelper.PromotionDataHelper;
import po.promotion.DistrictPromotionPO;
import po.promotion.EnterprisePromotionPO;
import po.promotion.PromotionPO;
import util.Time;
import util.exception.NetException;
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

	public String addhotelPromotion(PromotionVO vo) throws NetException {
		PromotionPO po;
		if (vo.type.equals(PromotionType.Enterprise))
			po = new EnterprisePromotionPO((EnterprisePromotionVO) vo);
		else
			po = new PromotionPO(vo);
		return promotion_service.addPromotion(po);
	}

	public String addWebPromotion(PromotionVO vo) throws NetException {
		PromotionPO po;
		if (vo.type.equals(PromotionType.BusinessDistrict))
			po = new DistrictPromotionPO((DistrictPromotionVO) vo);
		else
			po = new PromotionPO(vo);
		return promotion_service.addPromotion(po);
	}

	public ArrayList<PromotionVO> getHotelPromotion(String hotelID) throws NetException {
		Iterator<PromotionPO> iterator = promotion_service.getHotelPromotion(hotelID);
		ArrayList<PromotionVO> hotelPromotionList = new ArrayList<>();
		while (iterator.hasNext()) {
			PromotionPO po = iterator.next();
			hotelPromotionList.add(promotionPOtoVO(po));
		}
		return hotelPromotionList;
	}

	public ArrayList<PromotionVO> getWebPromotion() throws NetException {
		Iterator<PromotionPO> iterator = promotion_service.getWebPromotion();
		ArrayList<PromotionVO> webPromotionList = new ArrayList<>();
		while (iterator.hasNext()) {
			PromotionPO po = iterator.next();
			webPromotionList.add(promotionPOtoVO(po));
		}
		return webPromotionList;
	}

	public PromotionVO getPromotionById(String promotionID) throws NetException {
		PromotionPO po = promotion_service.getPromotionById(promotionID);
		return promotionPOtoVO(po);
	}

	public ResultMessage_Promotion cancel(String promotionID) {
		return promotion_service.deletePromotion(promotionID);
	}

	public ArrayList<Integer> getMemberLevel() throws NetException {
		return promotion_service.getMemberLevel();
	}

	public ArrayList<Double> getMemberDiscount() throws NetException {
		return promotion_service.getMemberDiscount();
	}

	public ResultMessage_Promotion makeLevel(ArrayList<Integer> level, ArrayList<Double> discount) {
		return promotion_service.levelMake(level, discount);
	}

	public Iterator<PromotionVO> getUnderwayPromotion(String hotelID) throws NetException {
		String currentDate = Time.getCurrentDate();
		ArrayList<PromotionVO> hotelPromotionList = getHotelPromotion(hotelID);
		ArrayList<PromotionVO> webPromotionList = getWebPromotion();

		ArrayList<PromotionVO> underwayPromotionList = new ArrayList<PromotionVO>();

		for (PromotionVO vo : hotelPromotionList) {
			// 结束时间早于当前时间，跳出循环
			if (vo.finishDate.compareTo(currentDate) < 0)
				break;
			// 结束时间晚于当前时间且开始时间早于当前时间
			if (vo.startDate.compareTo(currentDate) <= 0)
				underwayPromotionList.add(vo);
		}
		for (PromotionVO vo : webPromotionList) {
			// 结束时间早于当前时间，跳出循环
			if (vo.finishDate.compareTo(currentDate) < 0)
				break;
			// 结束时间晚于当前时间且开始时间早于当前时间
			if (vo.startDate.compareTo(currentDate) <= 0)
				underwayPromotionList.add(vo);
		}

		return underwayPromotionList.iterator();
	}

	private PromotionVO promotionPOtoVO(PromotionPO po) {
		PromotionVO vo;
		switch (po.getType()) {
		case Enterprise:
			vo = new EnterprisePromotionVO(po);
			break;
		case BusinessDistrict:
			vo = new DistrictPromotionVO(po);
			break;
		default:
			vo = new PromotionVO(po);
			break;
		}
		return vo;
	}

	public int getLevelInfo(int credit) throws NetException {
		ArrayList<Integer> memberLevel = getMemberLevel();
		int lv1 = memberLevel.get(0);
		int lv2 = memberLevel.get(1);
		int lv3 = memberLevel.get(2);
		if (credit <= lv1) {
			return 0;
		} else if (lv1 < credit && credit <= lv2) {
			return 1;
		} else if (lv2 < credit && credit <= lv3) {
			return 2;
		} else {
			return 3;
		}
	}

}
