package bussinesslogic.orderbl;

import java.util.ArrayList;

import util.exception.NetException;
import util.resultmessage.ResultMessage_Room;
import vo.room.RoomRecordVO;

public interface RoomUpdate {
	
	public int getRoomPrice(String hotelID, String roomNumber) throws NetException;
	
	public ResultMessage_Room addRecord(RoomRecordVO record);

	public ResultMessage_Room deleteRecord(String orderID);
	
	public ResultMessage_Room onlineCheckIn(String hotelID, String roomNumber);
	
	public ResultMessage_Room onlineCheckOut(String hotelID, String roomNumber);
	
	public ArrayList<RoomRecordVO> getOrderRecord(String hotelID, String roomNumber) throws NetException;
	
}
