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
	 * @param checkInDate
	 * @param estimateCheckOutDate
	 */
	public RoomRecordVO(String checkInDate, String estimateCheckOutDate) {
		this.checkInDate = checkInDate;
		this.estimateCheckOutDate = estimateCheckOutDate;
	}
	
	
	
}
