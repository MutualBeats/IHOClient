package bussinesslogic.promotionbl;

import java.util.ArrayList;
import java.util.Iterator;

import bussinesslogic.orderbl.PromotionGet;
import bussinesslogicservice.promotionblservice.PromotionBLService;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Promotion;
import vo.promotion.PromotionVO;

public class PromotionController implements PromotionBLService, PromotionGet{
	
	private Promotion promotion;

	public PromotionController() throws NetException {
		promotion = new Promotion();
	}

	@Override
	public String addhotelPromotion(PromotionVO vo) throws NetException {
		return promotion.addhotelPromotion(vo);
	}

	@Override
	public String addWebPromotion(PromotionVO vo) throws NetException {
		return promotion.addWebPromotion(vo);
	}

	@Override
	public ArrayList<PromotionVO> getHotelPromotion(String hotelID) throws NetException {
		return promotion.getHotelPromotion(hotelID);
	}

	@Override
	public ArrayList<PromotionVO> getWebPromotion() throws NetException {
		return promotion.getWebPromotion();
	}
	
	@Override
	public PromotionVO getPromotionById(String promotionID) throws NetException {
		return promotion.getPromotionById(promotionID);
	}

	@Override
	public ResultMessage_Promotion cancel(String promotionID) {
		return promotion.cancel(promotionID);
	}

	@Override
	public ArrayList<Integer> getMemberLevel() throws NetException {
		return promotion.getMemberLevel();
	}

	@Override
	public ArrayList<Double> getMemberDiscount() throws NetException {
		return promotion.getMemberDiscount();
	}

	@Override
	public ResultMessage_Promotion makeLevel(ArrayList<Integer> level, ArrayList<Double> discount) {
		return promotion.makeLevel(level, discount);
	}

	@Override
	public Iterator<PromotionVO> getUnderwayPromotion(String hotelID) throws NetException {
		return promotion.getUnderwayPromotion(hotelID);
	}

	@Override
	public double getDiscount(int level) throws NetException {
		return promotion.getMemberDiscount().get(level);
	}
	
}
