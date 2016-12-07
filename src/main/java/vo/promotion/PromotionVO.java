package vo.promotion;

import java.util.ArrayList;

import po.promotion.PromotionPO;
import util.promotion.PromotionType;

public class PromotionVO {
	/**
	 * 促销策略id
	 */
	public String promotionID;
	/**
	 * 促销策略名称
	 */
	public String promotionName;
	/**
	 * 促销策略类型
	 */
	public PromotionType type;
	/**
	 * 不同等级对应折扣
	 */
	public ArrayList<Double> discount;
	/**
	 * 酒店id（若网站促销策略则为空）
	 */
	public String hotelID;
	/**
	 * 开始时间
	 */
	public String startDate;
	/**
	 * 结束时间
	 */
	public String finishDate;

	/**
	 * @param promotionID
	 * @param promotionName
	 * @param type
	 * @param discount
	 * @param hotelID
	 * @param startDate
	 * @param finishDate
	 */
	public PromotionVO(String promotionID, String promotionName, PromotionType type, ArrayList<Double> discount,
			String hotelID, String startDate, String finishDate) {
		super();
		this.promotionID = promotionID;
		this.promotionName = promotionName;
		this.type = type;
		this.discount = discount;
		this.hotelID = hotelID;
		this.startDate = startDate;
		this.finishDate = finishDate;
	}

	public PromotionVO(PromotionPO po) {
		this(po.getPromotionID(), po.getPromotionName(), po.getType(), po.getDiscount(), po.getHotelID(),
				po.getStartDate(), po.getFinishDate());
	}

}
