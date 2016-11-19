package bussinesslogic.promotionbl;

import java.util.ArrayList;
import java.util.Iterator;

import bussinesslogic.orderbl.PromotionGet;
import bussinesslogicservice.promotionblservice.MemberPromotionBLservice;
import vo.MemberVO;
import vo.PromotionVO;

public class MemberPromotionController implements MemberPromotionBLservice, PromotionGet{

	@Override
	public ArrayList<Integer> levelMake(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO getLevel(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionVO getDiscount(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<PromotionVO> getPromotion() {
		// TODO Auto-generated method stub
		return null;
	}

}
