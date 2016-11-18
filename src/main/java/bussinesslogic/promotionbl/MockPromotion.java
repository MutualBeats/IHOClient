package bussinesslogic.promotionbl;

import java.util.Iterator;

import bussinesslogic.orderbl.PromotionGet;
import po.PromotionPO;

public class MockPromotion extends Promotion implements PromotionGet {

	@Override
	public Iterator<PromotionPO> getPromotion() {
		return null;
	}

}
