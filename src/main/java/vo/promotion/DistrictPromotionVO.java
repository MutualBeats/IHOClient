/**
 * @author huangxiao
 * @version 2016年12月7日
 */
package vo.promotion;

import java.util.ArrayList;

import po.promotion.DistrictPromotionPO;
import po.promotion.PromotionPO;
import util.promotion.PromotionType;

public class DistrictPromotionVO extends PromotionVO {

	/**
	 * 促销策略作用商圈列表
	 */
	public ArrayList<String> districtList;

	/**
	 * @param promotionID
	 * @param promotionName
	 * @param type
	 * @param discount
	 * @param hotelID
	 * @param startDate
	 * @param finishDate
	 * @param districtList
	 */
	public DistrictPromotionVO(String promotionID, String promotionName, PromotionType type, ArrayList<Double> discount,
			String hotelID, String startDate, String finishDate, ArrayList<String> districtList) {
		super(promotionID, promotionName, type, discount, hotelID, startDate, finishDate);
		this.districtList = districtList;
	}
	
	public DistrictPromotionVO(PromotionPO po) {
		super(po);
		districtList = ((DistrictPromotionPO) po).getDistrictList();
	}
}
