package bussinesslogic.promotionbl;

import java.util.ArrayList;

import bussinesslogicservice.promotionblservice.PromotionBLService;
import util.ResultMessage;
import vo.OrderPromotionConditionVO;
import vo.PromotionVO;

public class PromotionController implements PromotionBLService{

	@Override
	public ResultMessage hotelAdd(PromotionVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage webAdd(PromotionVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionVO> hotelLook(String hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionVO> webLook() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage cancel(String promotionID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionVO> getPromotion(OrderPromotionConditionVO ordervo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
