package factory.datahelper;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import dataservice.roomdataservice.ResultMessage_Room;
import dataservice.roomdataservice.RoomDataService;
import po.RoomPO;
import po.RoomRecordPO;
import util.RoomCondition;

/**
 * @author Saltwater
 * @version 1.0
 */
public class RoomDataHelper {

	private RoomDataService room_service;
	/**
	 * Cache for room . Store all the room info in specific hotel
	 * 
	 * Key : RoomNumber 
	 */
	private Map<String, RoomPO> room_cache;
	/**
	 * A record for current hotel. To increase the speed of judge cache_hit
	 */
	private String current_hotel;

	/**
	 * @param room_service
	 */
	public RoomDataHelper(RoomDataService room_service) {
		super();
		this.room_service = room_service;
		this.room_cache = new HashMap<>();
		this.room_cache.clear();
		this.current_hotel = "";
	}

	/**
	 * Find all the room in HotelID Search local cache, If here, return it, else
	 * , request the server and get the room list
	 * 
	 * @param hotelID
	 * @return The iterator of the room.
	 * @throws RemoteException
	 *             : Net Error
	 */
	public Iterator<RoomPO> getRoomList(String hotelID) throws RemoteException {
		if (!current_hotel.equals(hotelID)) {
			ArrayList<RoomPO> rooms = room_service.getRoom(hotelID);
			// Cache Update
			current_hotel = hotelID;
			room_cache.clear();
			Iterator<RoomPO> iterator = rooms.iterator();
			//Reload
			while (iterator.hasNext()) {
				RoomPO each = iterator.next();
				room_cache.put(each.getRoomNumber(), each);
			}
		}
		return room_cache.values().iterator();
	}

	/**
	 * 添加酒店
	 * 
	 * @param po
	 * @return
	 */
	public ResultMessage_Room addRoom(RoomPO po) {
		if (!po.getHotelID().equals(current_hotel)) {
			// Reload cache.
			try {
				getRoomList(po.getHotelID());
			} catch (RemoteException e) {
				return ResultMessage_Room.Net_Error;
			}
		}
		// Check Room.
		if (room_cache.containsKey(po.getRoomNumber())) {
			return ResultMessage_Room.Room_Exist_Already;
		} else {
			//Update Cache
			po.setHotelID(current_hotel);
			room_cache.put(po.getRoomNumber(), po);
			return ResultMessage_Room.Room_Add_Successful;
		}	
	}
	/**
	 * 入住酒店
	 * 
	 * @param hotelID
	 * @param roomNumber
	 * @return
	 */
	public ResultMessage_Room checkIn(String hotelID, String roomNumber) {
		ResultMessage_Room result = null;
		try {
			//更新服务器端信息
			result = room_service.checkIn(hotelID, roomNumber);
		} catch (RemoteException e) {
			//网络错误，中断操作
			return ResultMessage_Room.Net_Error;
		}
		//更新本地缓存
		if(result.equals(ResultMessage_Room.Check_In_Successful)) {
			if(hotelID.equals(current_hotel) && room_cache.containsKey(roomNumber)) {
				RoomPO po = room_cache.get(roomNumber);
				po.setCondition(RoomCondition.Occupied);
			}
		}
		return result;
	}
	
	public ResultMessage_Room checkOut(String hotelID, String roomNumber) {
		ResultMessage_Room result = null;
		try {
			//更新服务器端信息
			result = room_service.checkOut(hotelID, roomNumber);
		} catch (RemoteException e) {
			//网络错误，中断操作
			return ResultMessage_Room.Net_Error;
		}
		//更新本地缓存
		if(result.equals(ResultMessage_Room.Check_Out_Successful)) {
			if(hotelID.equals(current_hotel) && room_cache.containsKey(roomNumber)) {
				RoomPO po = null;
				//更新房间信息
				try {
					po = room_service.getRoomInfo(hotelID, roomNumber);
				} catch (RemoteException e) {
					return ResultMessage_Room.Net_Error;
				}
				room_cache.remove(roomNumber);
				room_cache.put(roomNumber, po);
			}
		}
		return result;
	}
	
	/**
	 * 获取房间预定记录
	 * 
	 * @param hotelID
	 * @param roomNumber
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<RoomRecordPO> getOrderRecord(String hotelID, String roomNumber) throws RemoteException {
		return room_service.getOrderRecord(hotelID, roomNumber);
	}
	
	/**
	 * 增加酒店预定记录
	 * 
	 * @param po
	 * @return
	 */
	public ResultMessage_Room addRecord(RoomRecordPO po) {
		try {
			return this.room_service.addRecord(po);
		} catch (RemoteException e) {
			return ResultMessage_Room.Net_Error;
		}
	}
	
	/**
	 * 删除预定记录
	 * 
	 * @param orderID
	 * @return
	 */
	public ResultMessage_Room deleteRecord(String orderID) {
		try {
			return room_service.deleteRecord(orderID);
		} catch (RemoteException e) {
			return ResultMessage_Room.Net_Error;
		}
	}

}
