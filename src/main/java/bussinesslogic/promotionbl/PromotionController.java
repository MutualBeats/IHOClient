package bussinesslogic.promotionbl;

import java.util.ArrayList;
import java.util.Iterator;

import bussinesslogic.orderbl.PromotionGet;
import bussinesslogicservice.promotionblservice.PromotionBLService;
import util.resultmessage.ResultMessage_Promotion;
import vo.promotion.PromotionVO;

public class PromotionController implements PromotionBLService, PromotionGet{
	
	private Promotion promotion;

	public PromotionController() throws Exception {
		promotion = new Promotion();
	}

	@Override
	public ResultMessage_Promotion addhotelPromotion(PromotionVO vo) {
		return promotion.addhotelPromotion(vo);
	}

	@Override
	public ResultMessage_Promotion addWebPromotion(PromotionVO vo) {
		return promotion.addWebPromotion(vo);
	}

	@Override
	public ArrayList<PromotionVO> gethotelPromotion(String hotelID) {
		return promotion.gethotelPromotion(hotelID);
	}

	@Override
	public ArrayList<PromotionVO> getWebPromotion() {
		return promotion.getWebPromotion();
	}

	@Override
	public ResultMessage_Promotion cancel(String promotionID) {
		return promotion.cancel(promotionID);
	}

	@Override
	public ArrayList<Integer> getMemberLevel() {
		return promotion.getMemberLevel();
	}

	@Override
	public ArrayList<Double> getMemberDiscount() {
		return promotion.getMemberDiscount();
	}

	@Override
	public ResultMessage_Promotion makeLevel(ArrayList<Integer> level, ArrayList<Double> discount) {
		return promotion.makeLevel(level, discount);
	}
	
	@Override
	public Iterator<PromotionVO> getPromotion() {
		// TODO
		return null;
	}
	
}
