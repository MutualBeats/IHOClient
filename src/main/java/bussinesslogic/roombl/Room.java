/**
 * @author huangxiao
 * @author Saltwater
 * 2016年11月6日
 */
package bussinesslogic.roombl;

import java.util.ArrayList;

import dataservice.roomdataservice.ResultMessage_Room;
import util.ResultMessage_For_Stub;
import vo.room.RoomVO;

/**
 * Room Logic Impl
 * 
 * @author Saltwater
 * @version 2.0
 */

public class Room {
	
	/**
	 * 导入房间
	 * 
	 * @param importRoomList
	 * @return
	 */
	public ResultMessage_Room importRoom(ArrayList<RoomVO> importRoomList) {
		return null;
	}
	/**
	 * 获得房间列表
	 * 
	 * @param hotelID
	 * @return
	 */
	public ArrayList<RoomVO> getRoomList(String hotelID) {
		return null;
	}

	public ResultMessage_Room checkIn(String hotelID, String roomID) {
		return null;
	}

	public ResultMessage_Room checkOut(String hotelID, String roomID) {
		return null;
	}
	
	

}
