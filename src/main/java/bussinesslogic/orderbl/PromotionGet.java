package bussinesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.Iterator;

import vo.promotion.PromotionVO;

public interface PromotionGet {
	
	/**
	 * Get all the available promotion for current order
	 * 
	 * @return
	 */
	public Iterator<PromotionVO>  getPromotion();
	
}
