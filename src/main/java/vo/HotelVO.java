/**
 * @author huangxiao
 * 2016年10月16日
 */
package vo;

public class HotelVO {
	/**
	 * 酒店id
	 */
	public String hotelID;
	/**
	 * 酒店名称
	 */
	public String hotelName;
	/**
	 * 酒店地址
	 */
	public String address;
	/**
	 * 酒店所属地区
	 */
	public String region;
	/**
	 * 酒店所属商圈
	 */
	public String businessDistrict;
	/**
	 * 酒店星级
	 */
	public int starLevel;
	/**
	 * 酒店评分
	 */
	public double score;
	
	/**
	 * 构造方法
	 * @param hotelID
	 * @param hotelName
	 * @param address
	 * @param region
	 * @param businessDistrict
	 * @param starLevel
	 * @param score
	 */
	public HotelVO(String hotelID, String hotelName, String address, String region, String businessDistrict,
			int starLevel, double score) {
		super();
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.address = address;
		this.region = region;
		this.businessDistrict = businessDistrict;
		this.starLevel = starLevel;
		this.score = score;
	}
	

	
}
