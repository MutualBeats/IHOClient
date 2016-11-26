package bussinesslogic.orderbl;

import dataservice.roomdataservice.ResultMessage_Room;

public interface RoomUpdate {
	
	public ResultMessage_Room checkIn(String hotelID, String roomID);
	
	public ResultMessage_Room checkOut(String hotelID, String roomID);
	
}
