package bussinesslogic.promotionbl;

import java.util.ArrayList;
import java.util.Iterator;

import bussinesslogic.orderbl.PromotionGet;
import bussinesslogicservice.promotionblservice.PromotionBLService;
import util.resultmessage.ResultMessage_Promotion;
import vo.promotion.PromotionVO;

public class PromotionController implements PromotionBLService,PromotionGet{

	/* (non-Javadoc)
	 * @see bussinesslogicservice.promotionblservice.PromotionBLService#addhotelPromotion(vo.promotion.PromotionVO)
	 */
	@Override
	public ResultMessage_Promotion addhotelPromotion(PromotionVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see bussinesslogicservice.promotionblservice.PromotionBLService#addWebPromotion(vo.promotion.PromotionVO)
	 */
	@Override
	public ResultMessage_Promotion addWebPromotion(PromotionVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see bussinesslogicservice.promotionblservice.PromotionBLService#gethotelPromotion(java.lang.String)
	 */
	@Override
	public ArrayList<PromotionVO> gethotelPromotion(String hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see bussinesslogicservice.promotionblservice.PromotionBLService#getWebPromotion()
	 */
	@Override
	public ArrayList<PromotionVO> getWebPromotion() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see bussinesslogicservice.promotionblservice.PromotionBLService#cancel(java.lang.String)
	 */
	@Override
	public ResultMessage_Promotion cancel(String promotionID) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see bussinesslogicservice.promotionblservice.PromotionBLService#getMemberLevel()
	 */
	@Override
	public ArrayList<Integer> getMemberLevel() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see bussinesslogicservice.promotionblservice.PromotionBLService#getMemberDiscount()
	 */
	@Override
	public ArrayList<Double> getMemberDiscount() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see bussinesslogicservice.promotionblservice.PromotionBLService#makeLevel(java.util.ArrayList, java.util.ArrayList)
	 */
	@Override
	public ResultMessage_Promotion makeLevel(ArrayList<Integer> level, ArrayList<Double> discount) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Iterator<PromotionVO> getPromotion() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
