/**
 * @author huangxiao
 * 2016年10月16日
 */
package util.hotel;

import java.io.Serializable;

import util.room.RoomType;

public class SearchCondition implements Serializable {
	/**
	 * version id
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 酒店所属地区
	 */
	public String region;
	/**
	 * 酒店所属商圈
	 */
	public String businessDistrict;
	/**
	 * 酒店名称
	 */
	public String hotelName;
	/**
	 * 酒店星级
	 */
	public int starLevel;
	/**
	 * 酒店评分
	 */
	public double score;

	/*-------------------------------------------*/

	/**
	 * 房间最低价
	 */
	public int min_price;

	/**
	 * 房间最高价
	 */
	public int max_price;

	/**
	 * 房间类型
	 */
	public RoomType type;

	/**
	 * 是否曾经预定
	 */
	public boolean order_before;

	public SearchCondition(String region, String businessDistrict, String hotelName, int starLevel,
			double score, int min_price, int max_price, RoomType type, boolean order_before) {
		super();		this.region = region;
		this.businessDistrict = businessDistrict;
		this.hotelName = hotelName;
		this.starLevel = starLevel;
		this.score = score;
		this.min_price = min_price;
		this.max_price = max_price;
		this.type = type;
		this.order_before = order_before;
	}

}
