/**
 * @author huangxiao
 * 2016年10月14日
 */
package bussinesslogicservice.roomblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.exception.NetException;
import util.resultmessage.ResultMessage_Room;
import vo.room.RoomRecordVO;
import vo.room.RoomVO;

public interface RoomBLService {
	/**
	 * 录入客房
	 * @return 未成功录入列表
	 * @throws RemoteException 
	 */
	public ArrayList<String> importRoom(ArrayList<RoomVO> importRoomList) throws NetException;

	/**
	 * 获得某酒店的房间列表
	 * @throws RemoteException 
	 */
	public ArrayList<RoomVO> getRoomList(String hotelID) throws NetException;
	/**
	 * 房间信息
	 * 
	 * @param hotelID
	 * @param roomNumber
	 * @return
	 * @throws RemoteException
	 */
	public RoomVO getRoomInfo(String hotelID, String roomNumber ) throws NetException;
	/**
	 * 获得房间预定信息
	 * 
	 * @param hotelID
	 * @param roomNumber
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<RoomRecordVO> getOrderRecord(String hotelID, String roomNumber) throws NetException;
	/**
	 * 添加线下房间记录
	 * @param roomRecord
	 * @return
	 */
	public ResultMessage_Room addRecord(RoomRecordVO roomRecord);
	/**
	 * 客户线下入住
	 * @param hotelID
	 * @param roomNumber
	 * @return ResultMessage
	 */
	public ResultMessage_Room checkIn(String hotelID, String roomNumber);
	/**
	 * 客户线下退房
	 * @param hotelID
	 * @param roomNumber
	 * @return ResultMessage
	 */
	public ResultMessage_Room checkOut(String hotelID, String roomNumber);
}
