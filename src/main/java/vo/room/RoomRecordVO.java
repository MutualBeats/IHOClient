package vo.room;

public class RoomRecordVO {
	
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
	}

	
	
	
}
