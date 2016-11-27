/**
 * @author huangxiao
 * 2016年10月14日
 */
package bussinesslogicservice.roomblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.roomdataservice.ResultMessage_Room;
import vo.room.RoomRecordVO;
import vo.room.RoomVO;

public interface RoomBLService {
	/**
	 * 录入客房
	 * @return 未成功录入列表
	 * @throws RemoteException 
	 */
	public ArrayList<String> importRoom(ArrayList<RoomVO> importRoomList) throws RemoteException;

	/**
	 * 获得某酒店的房间列表
	 * @throws RemoteException 
	 */
	public ArrayList<RoomVO> getRoomList(String hotelID) throws RemoteException;
	/**
	 * 房间信息
	 * 
	 * @param hotelID
	 * @param roomNumber
	 * @return
	 * @throws RemoteException
	 */
	public RoomVO getRoomInfo(String hotelID, String roomNumber ) throws RemoteException;
	/**
	 * 获得房间预定信息
	 * 
	 * @param hotelID
	 * @param roomNumber
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<RoomRecordVO> getOrderReord(String hotelID, String roomNumber) throws RemoteException;
	/**
	 * 客户入住
	 */
	public ResultMessage_Room checkIn(String hotelID, String roomNumber);

	/**
	 * 客户退房
	 */
	public ResultMessage_Room checkOut(String hotelID, String roomNumber);
}
