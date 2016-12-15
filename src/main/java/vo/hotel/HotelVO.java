/**
 * @author huangxiao
 * 2016年10月16日
 */
package vo.hotel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import po.hotel.HotelPO;

public class HotelVO {
	
	private StringProperty province_property;
	private StringProperty field_property;
	private StringProperty city_property;
	private StringProperty name_property;
	private StringProperty group_property;
	
	public StringProperty getProvince_property() {
		return province_property;
	}

	public StringProperty getField_property() {
		return field_property;
	}

	public StringProperty getCity_property() {
		return city_property;
	}

	public StringProperty getName_property() {
		return name_property;
	}

	public StringProperty getGroup_property() {
		return group_property;
	}

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
	public double score = -1;

	/**
	 * 构造方法
	 * 
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
		init();
	}

	/**
	 * Transfer po to vo;
	 * 
	 * @param po
	 */
	public HotelVO(HotelPO po) {
		this.hotelID = po.getHotelID();
		this.hotelName = po.getHotelName();
		this.address = po.getAddress();
		this.region = po.getRegion();
		this.businessDistrict = po.getBusinessDistrict();
		this.starLevel = po.getStarLevel();
		this.score = po.getScore();
		init();
	}
	
	private void init() { 
		String places[] = region.split("\\s");
		province_property = new SimpleStringProperty(places[0]);
		city_property = new SimpleStringProperty(places[1]);
		field_property = new SimpleStringProperty(places[2]);
		group_property = new SimpleStringProperty(businessDistrict);
		name_property = new SimpleStringProperty(hotelName);
		
	}

}
