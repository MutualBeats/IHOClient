/**
 * @author huangxiao
 * @author Saltwater
 * 2016年11月6日
 */
package bussinesslogic.roombl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import factory.datahelper.DataHelperFactory;
import factory.datahelper.RoomDataHelper;
import po.room.RoomPO;
import po.room.RoomRecordPO;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Room;
import vo.room.RoomRecordVO;
import vo.room.RoomVO;

/**
 * Room Logic Impl
 * 
 * @author Saltwater
 * @version 2.0
 */

public class Room {

	private RoomDataHelper room_service;

	public Room() throws NetException {
		room_service = DataHelperFactory.getDataFactoryHelperInstance().getRoomDatabase();
	}

	/**
	 * 导入房间
	 * 
	 * @param importRoomList
	 * @return rooms' number imported unsuccessfully
	 * @throws RemoteException
	 *             : Net Error
	 */
	public ArrayList<String> importRoom(ArrayList<RoomVO> importRoomList) throws NetException {
		ArrayList<String> unsuccessful = new ArrayList<>();
		for (RoomVO each : importRoomList) {
			ResultMessage_Room result = room_service.addRoom(new RoomPO(each));
			if (!result.equals(ResultMessage_Room.Room_Add_Successful)) {
				unsuccessful.add(each.roomNumber);
			}
		}
		return unsuccessful;
	}

	/**
	 * 获得房间列表
	 * 
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<RoomVO> getRoomList(String hotelID) throws NetException {
		Iterator<RoomPO> iterator = room_service.getRoomList(hotelID);
		ArrayList<RoomVO> roomList = new ArrayList<>();
		while (iterator.hasNext()) {
			roomList.add(new RoomVO(iterator.next()));
		}
		return roomList;
	}
	
	/**
	 * 入住
	 * 
	 * @param hotelID
	 * @param roomNumber
	 * @return
	 */
	public ResultMessage_Room checkIn(String hotelID, String roomNumber, boolean isOnline) {
		return room_service.checkIn(hotelID, roomNumber, isOnline);
	}
	
	/**
	 * 离开
	 * 
	 * @param hotelID
	 * @param roomNumber
	 * @return
	 */
	public ResultMessage_Room checkOut(String hotelID, String roomNumber, boolean isOnline) {
		return room_service.checkOut(hotelID, roomNumber, isOnline);
	}
	
	/**
	 * 获得预定记录
	 * 
	 * @param hotelID
	 * @param roomNumber
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<RoomRecordVO> getOrderReord(String hotelID, String roomNumber) throws NetException {
		ArrayList<RoomRecordVO> records = new ArrayList<>();
		Iterator<RoomRecordPO> iterator = room_service.getOrderRecord(hotelID, roomNumber);
		while(iterator.hasNext()) {
			RoomRecordPO each = iterator.next();
			records.add(new RoomRecordVO(each.getCheckInDate(), each.getEstimateCheckOutDate(),each.getOrderID(), each.getHotelID(), each.getRoomNumber()));
		}
		return records;
	}

	/**
	 * 增加记录
	 * 
	 * @param record
	 * @return
	 */
	public ResultMessage_Room addRecord(RoomRecordVO record) {
		return room_service.addRecord(new RoomRecordPO(record));
	}

	/**
	 * 删除记录
	 * 
	 * @param orderID
	 * @return
	 */
	public ResultMessage_Room deleteRecord(String orderID) {
		return room_service.deleteRecord(orderID);
	}
	
	public RoomVO getRoomInfo(String hotelID, String roomNumber) throws NetException {
		return new RoomVO(room_service.getRoomInfo(hotelID, roomNumber));
	}
	
}
