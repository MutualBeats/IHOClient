/**
 * @author huangxiao
 * 2016年10月16日
 */
package vo;

public class HotelEvaluationVO {
	
	/**
	 * 被评论酒店id
	 */
	public String hotelID;
	/**
	 * 评价者
	 */
	public String clientName;
	/**
	 * 评价时间
	 */
	public String evaluateTime;
	/**
	 * 评分
	 */
	public int evaluateScore;
	/**
	 * 评论
	 */
	public String evaluateInfo;
	
	/**
	 * @param hotelID
	 * @param clientName
	 * @param evaluateTime
	 * @param evaluateScore
	 * @param evaluateInfo
	 */
	public HotelEvaluationVO(String hotelID, String clientName, String evaluateTime, int evaluateScore,
			String evaluateInfo) {
		super();
		this.hotelID = hotelID;
		this.clientName = clientName;
		this.evaluateTime = evaluateTime;
		this.evaluateScore = evaluateScore;
		this.evaluateInfo = evaluateInfo;
	}

}
