package bussinesslogic.orderbl;

import java.util.Iterator;

import util.exception.NetException;
import vo.promotion.PromotionVO;

/**
 * 
 * 计算订单获取符合条件的Promotion接口
 * 
 * @author heleninsa
 *
 */
public interface PromotionGet {
	
	public Iterator<PromotionVO> getUnderwayPromotion(String hotelID) throws NetException;
	
	public double getDiscount(int level) throws NetException;
	
}
