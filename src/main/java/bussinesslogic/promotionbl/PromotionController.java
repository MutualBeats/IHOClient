package bussinesslogic.promotionbl;

import java.util.ArrayList;
import java.util.Iterator;

import bussinesslogic.orderbl.PromotionGet;
import bussinesslogicservice.promotionblservice.PromotionBLService;
import util.resultmessage.ResultMessage_Promotion;
import vo.order.OrderPromotionConditionVO;
import vo.promotion.PromotionVO;

public class PromotionController implements PromotionBLService,PromotionGet{

	@Override
	public ResultMessage_Promotion hotelAdd(PromotionVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage_Promotion webAdd(PromotionVO vo) {
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
	public ResultMessage_Promotion cancel(String promotionID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionVO> getPromotion(OrderPromotionConditionVO ordervo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<PromotionVO> getPromotion() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
