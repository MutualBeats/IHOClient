/**
 * @author huangxiao
 * @version 2016年11月25日
 */
package po.room;

import java.io.Serializable;

import vo.room.RoomRecordVO;

public class RoomRecordPO implements Serializable {
	/**
	 * version id
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 房间所属酒店id
	 */
	private String hotelID;
	
	/**
	 * 房间号
	 */
	private String roomNumber;
	
	/**
	 * 订单号
	 */
	private String orderID;
	
	/**
	 * 订单记录入住时间
	 */
	private String checkInDate;
	
	/**
	 * 订单预计离开时间
	 */
	private String estimateCheckOutDate;
	
	/**
	 * @param hotelID
	 * @param roomNumber
	 * @param orderID
	 * @param checkInDate
	 * @param estimateCheckOutDate
	 */
	public RoomRecordPO(String hotelID, String roomNumber, String orderID, String checkInDate,
			String estimateCheckOutDate) {
		super();
		this.hotelID = hotelID;
		this.roomNumber = roomNumber;
		this.orderID = orderID;
		this.checkInDate = checkInDate;
		this.estimateCheckOutDate = estimateCheckOutDate;
	}

	public RoomRecordPO() {
	}
	
	public RoomRecordPO(RoomRecordVO record) {
		this(record.hotelID, record.roomNumber, record.order_id, record.checkInDate, record.estimateCheckOutDate);
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getEstimateCheckOutDate() {
		return estimateCheckOutDate;
	}

	public void setEstimateCheckOutDate(String estimateCheckOutDate) {
		this.estimateCheckOutDate = estimateCheckOutDate;
	}
	
}
