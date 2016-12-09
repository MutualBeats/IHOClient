package bussinesslogic.orderbl;

import java.util.Iterator;

import util.exception.NetException;
import vo.promotion.PromotionVO;

public interface PromotionGet {
	
	public Iterator<PromotionVO> getUnderwayPromotion(String hotelID) throws NetException;
	
	public double getDiscount(int level) throws NetException;
	
}
