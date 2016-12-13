/**
 * @author huangxiao
 * @version 2016年12月13日
 */
package presentation.staffui.hotelpromotion;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import util.promotion.PromotionType;

public final class HotelPromotionData {
	
	private final StringProperty promotionID = new SimpleStringProperty();
	
	private final StringProperty promotionName = new SimpleStringProperty();
	
	private final StringProperty promotionType = new SimpleStringProperty();
	
	private final StringProperty startDate = new SimpleStringProperty();
	
	private final StringProperty endDate = new SimpleStringProperty();
	
	private final DoubleProperty discount = new SimpleDoubleProperty();

	public HotelPromotionData(String promotionID, String promotionName, PromotionType promotionType, String startDate, String endDate, double discount) {
		setPromotionID(promotionID);
		setPromotionName(promotionName);
		setPromotionType(promotionType);
		setStartDate(startDate);
		setEndDate(endDate);
		setDiscount(discount);
	}
	
	public void setPromotionID(String promotionID) {
		this.promotionID.set(promotionID);
	}
	
	public String getPromotionID() {
		return promotionID.get();
	}
	
	public StringProperty promotionIDProperty() {
		return promotionID;
	}
	
	public void setPromotionName(String promotionName) {
		this.promotionName.set(promotionName);
	}
	
	public String getPromotionName() {
		return promotionName.get();
	}
	
	public StringProperty promotionNameProperty() {
		return promotionName;
	}
	
	public void setPromotionType(PromotionType promotionType) {
		String type;
		switch (promotionType) {
		case Birthday:
			type = "生日特惠";
			break;
		case Enterprise:
			type = "合作企业特惠";
			break;
		case Room:
			type = "三间房以上预订特惠";
			break;
		case Holiday:
			type = "节日特惠";
			break;
		default:
			type = "其他";
		}
		this.promotionType.set(type);
	}
	
	public String getPromotionType() {
		return promotionType.get();
	}
	
	public StringProperty promotionTypeProperty() {
		return promotionType;
	}
	
	public void setStartDate(String startDate) {
		this.startDate.set(startDate);
	}
	
	public String getStartDate() {
		return startDate.get();
	}
	
	public StringProperty startDateProperty() {
		return startDate;
	}
	
	public void setEndDate(String endDate) {
		this.startDate.set(endDate);
	}
	
	public String getEndDate() {
		return endDate.get();
	}
	
	public StringProperty endDateProperty() {
		return endDate;
	}
	
	public void setDiscount(double discount) {
		this.discount.set(discount);
	}
	
	public double getDiscount() {
		return discount.get();
	}
	
	public DoubleProperty discountProperty() {
		return discount;
	}
	
}
