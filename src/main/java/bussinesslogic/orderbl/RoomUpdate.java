package bussinesslogic.orderbl;

import util.ResultMessage;

public interface RoomUpdate {
	
	public ResultMessage checkIn(String hotelID, String roomID);
	
	public ResultMessage checkOut(String hotelID, String roomID);
	
}
