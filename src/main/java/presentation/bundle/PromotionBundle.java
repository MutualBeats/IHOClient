package presentation.bundle;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;

import vo.promotion.PromotionVO;
/**
 * 
 * OrderList Bundle ： 用于查看促销策略列表
 * 
 * 包含： 总列表 会员商圈促销策略列表 限时促销策略列表
 * 
 * @author hehuixian
 *
 */
public class PromotionBundle  extends ResourceBundle{

	public ArrayList<PromotionVO> total_promotionList;
//	public ArrayList<PromotionVO> time_promotionList;
//	public ArrayList<PromotionVO> field_promotionList;
	
	private final static String TOTAL_PROMOTION = "total_promotion";
//	private final static String TIME_PROMOTION = "time_promotion";
//	private final static String FIELD_PROMOTION = "field_promotion";
	
	
	public PromotionBundle(ArrayList<PromotionVO> total_promotionList) {
		// TODO Auto-generated constructor stub
		super();
		this.total_promotionList=total_promotionList;
//		this.time_promotionList=time_promotionList;
//		this.field_promotionList=field_promotionList;
	}
	
	@Override
	protected Object handleGetObject(String key) {
		// TODO Auto-generated method stub
		if(TOTAL_PROMOTION.equals(key)) {
			return total_promotionList;
		}
//		else if (TIME_PROMOTION.equals(key)){
//			return time_promotionList;
//		}
//		else if (FIELD_PROMOTION.equals(key)){
//			return field_promotionList;
//		}
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
