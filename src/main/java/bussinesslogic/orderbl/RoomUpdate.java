package bussinesslogic.orderbl;

import util.ResultMessage_For_Stub;

public interface RoomUpdate {
	
	public ResultMessage_For_Stub checkIn(String hotelID, String roomID);
	
	public ResultMessage_For_Stub checkOut(String hotelID, String roomID);
	
}
