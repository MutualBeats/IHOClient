package bussinesslogic.orderbl;

import po.room.RoomRecordPO;
import util.resultmessage.ResultMessage_Room;

public interface RoomUpdate {
	
	public ResultMessage_Room addRecord(RoomRecordPO record);

	public ResultMessage_Room deleteRecord(String orderID);
	
	public ResultMessage_Room checkIn(String hotelID, String roomID);
	
	public ResultMessage_Room checkOut(String hotelID, String roomID);
	
}
