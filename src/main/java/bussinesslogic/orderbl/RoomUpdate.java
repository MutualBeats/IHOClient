package bussinesslogic.orderbl;

import util.ResultMessage;

public interface RoomUpdate {
	
	public ResultMessage checkIn(String roomID);
	
	public ResultMessage checkOut(String roomID);
	
}
