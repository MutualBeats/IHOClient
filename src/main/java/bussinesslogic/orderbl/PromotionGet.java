package bussinesslogic.orderbl;

import java.util.Iterator;

import po.PromotionVO;

public interface PromotionGet {
	
	/**
	 * Get all the available promotion for current order
	 * 
	 * @return
	 */
	public Iterator<PromotionVO>  getPromotion();
	
}
