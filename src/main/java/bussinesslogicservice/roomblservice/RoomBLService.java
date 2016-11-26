/**
 * @author huangxiao
 * 2016年10月14日
 */
package bussinesslogicservice.roomblservice;

import java.util.ArrayList;

import dataservice.roomdataservice.ResultMessage_Room;
import vo.room.RoomVO;

public interface RoomBLService {
	/**
	 * 录入客房
	 */
	public ResultMessage_Room importRoom(ArrayList<RoomVO> importRoomList);

	/**
	 * 获得某酒店的房间列表
	 */
	public ArrayList<RoomVO> getRoom(String hotelID);

	/**
	 * 客户入住
	 */
	public ResultMessage_Room checkIn(String hotelID, String roomID);

	/**
	 * 客户退房
	 */
	public ResultMessage_Room checkOut(String hotelID, String roomID);
}
