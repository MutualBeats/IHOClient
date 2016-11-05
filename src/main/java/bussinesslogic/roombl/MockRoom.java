/**
 * @author huangxiao
 * 2016年11月6日
 */
package bussinesslogic.roombl;

import util.ResultMessage;

public class MockRoom extends Room {

	public MockRoom() {
	}
	
	public ResultMessage checkIn(String roomID) {
		return ResultMessage.RoomUpdateSuccess;
	}
	
	public ResultMessage checkOut(String roomID) {
		return ResultMessage.RoomUpdateSuccess;
	}
	
}
