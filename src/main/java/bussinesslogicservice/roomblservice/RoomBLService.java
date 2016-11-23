/**
 * @author huangxiao
 * 2016年10月14日
 */
package bussinesslogicservice.roomblservice;

import java.util.ArrayList;

import util.ResultMessage_For_Stub;
import vo.RoomVO;

public interface RoomBLService {
	/**
	 * 录入客房
	 */
	public ResultMessage_For_Stub importRoom(ArrayList<RoomVO> importRoomList);
	/**
	 * 获得某酒店的所有房间
	 */
	public ArrayList<RoomVO> getRoom(String hotelID);
	/**
	 * 客户入住
	 */
	public ResultMessage_For_Stub checkIn(String hotelID, String roomID);
	/**
	 * 客户退房
	 */
	public ResultMessage_For_Stub checkOut(String hotelID, String roomID);
}
