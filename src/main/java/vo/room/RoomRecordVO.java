package vo.room;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RoomRecordVO {
	
	private final StringProperty orderIDProperty = new SimpleStringProperty();
	private final StringProperty checkInDateProperty = new SimpleStringProperty();
	private final StringProperty checkOutDateProperty = new SimpleStringProperty();
	
	public void setOrderID(String orderID) {
		if(orderID.equals(""))
			orderIDProperty.set("线下入住");
		else
			orderIDProperty.set(orderID);
	}
	
	public StringProperty getOrderIDProperty() {
		return orderIDProperty;
	}
	
	public void setCheckInDate(String checkInDate) {
		checkInDateProperty.set(checkInDate);
	}
	
	public StringProperty getCheckInDateProperty() {
		return checkInDateProperty;
	}
	
	public void setCheckOutDate(String checkOutDate) {
		checkOutDateProperty.set(checkOutDate);
	}
	
	public StringProperty getCheckOutDateProperty() {
		return checkOutDateProperty;
	}
	
	/**
	 * 订单记录入住时间
	 */
	public String checkInDate;
	
	/**
	 * 订单预计离开时间
	 */
	public String estimateCheckOutDate;
	
	/**
	 * 订单号
	 */
	public String order_id;

	public RoomRecordVO(String checkInDate, String estimateCheckOutDate, String order_id) {
		super();
		this.checkInDate = checkInDate;
		this.estimateCheckOutDate = estimateCheckOutDate;
		this.order_id = order_id;
		
		setOrderID(order_id);
		setCheckInDate(checkInDate);
		setCheckOutDate(estimateCheckOutDate);
	}
	
}
