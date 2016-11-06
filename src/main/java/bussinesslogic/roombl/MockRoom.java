/**
 * @author huangxiao
 * 2016年11月6日
 */
package bussinesslogic.roombl;

import bussinesslogic.orderbl.RoomUpdate;
import util.ResultMessage;

public class MockRoom extends Room implements RoomUpdate{

	public MockRoom() {
	}
	
	public ResultMessage checkIn(String hotelID, String roomID) {
		return ResultMessage.RoomUpdateSuccess;
	}
	
	public ResultMessage checkOut(String hotelID, String roomID) {
		return ResultMessage.RoomUpdateSuccess;
	}
	
}
