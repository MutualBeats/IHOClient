package bussinesslogic.promotionbl;

import java.util.Iterator;

import bussinesslogic.orderbl.PromotionGet;
import vo.promotion.PromotionVO;

public class MockPromotion extends Promotion implements PromotionGet {

	@Override
	public Iterator<PromotionVO> getPromotion() {
		return null;
	}

}
