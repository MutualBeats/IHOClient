/**
 * @author huangxiao
 * 2016年11月6日
 */
package bussinesslogic.roombl;

import bussinesslogic.orderbl.RoomUpdate;
import util.resultmessage.ResultMessage_Room;

public class MockRoom extends Room implements RoomUpdate{

	public MockRoom() {
	}
	
	public ResultMessage_Room checkIn(String hotelID, String roomID) {
		return ResultMessage_Room.Check_In_Successful;
	}
	
	public ResultMessage_Room checkOut(String hotelID, String roomID) {
		return ResultMessage_Room.Check_Out_Successful;
	}
	
}
