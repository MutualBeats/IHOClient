/**
 * @author huangxiao
 * 2016年11月6日
 */
package bussinesslogic.roombl;

import bussinesslogic.orderbl.RoomUpdate;
import util.ResultMessage_For_Stub;

public class MockRoom extends Room implements RoomUpdate{

	public MockRoom() {
	}
	
	public ResultMessage_For_Stub checkIn(String hotelID, String roomID) {
		return ResultMessage_For_Stub.RoomUpdateSuccess;
	}
	
	public ResultMessage_For_Stub checkOut(String hotelID, String roomID) {
		return ResultMessage_For_Stub.RoomUpdateSuccess;
	}
	
}
