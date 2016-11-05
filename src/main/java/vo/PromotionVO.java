package vo;

import java.util.ArrayList;

public class PromotionVO {
	
	public String promotionId;
	public String message;
	public String id;
	public String startTime;
	public String endTime;
	public double discount;
	public static ArrayList<Integer> levelList;
	/**
	 * @param promotionId
	 * @param message
	 * @param id
	 * @param startTime
	 * @param endTime
	 * @param discount
	 */
	public PromotionVO(String promotionId, String message, String id, String startTime, String endTime,
			double discount) {
		super();
		this.promotionId = promotionId;
		this.message = message;
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.discount = discount;
	}
	
}
