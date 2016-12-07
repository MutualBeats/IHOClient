/**
 * @author huangxiao
 * @version 2016年12月7日
 */
package vo.promotion;

import java.util.ArrayList;

import po.promotion.PromotionPO;
import util.promotion.PromotionType;

public class EnterprisePromotionVO extends PromotionVO {
	
	/**
	 * 促销策略合作企业列表
	 */
	public ArrayList<String> enterpriseList;

	/**
	 * @param promotionID
	 * @param promotionName
	 * @param type
	 * @param discount
	 * @param hotelID
	 * @param startDate
	 * @param finishDate
	 * @param enterpriseList
	 */
	public EnterprisePromotionVO(String promotionID, String promotionName, PromotionType type,
			ArrayList<Double> discount, String hotelID, String startDate, String finishDate,
			ArrayList<String> enterpriseList) {
		super(promotionID, promotionName, type, discount, hotelID, startDate, finishDate);
		this.enterpriseList = enterpriseList;
	}
	
	public EnterprisePromotionVO(PromotionPO po) {
		super(po);
		enterpriseList = po.getEnterpriseList();
	}

}
