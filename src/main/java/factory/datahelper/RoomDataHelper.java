package factory.datahelper;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import dataservice.roomdataservice.RoomDataService;
import po.room.RoomPO;
import po.room.RoomRecordPO;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Room;
import util.room.RoomState;

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
	private ArrayList<RoomPO> room_cache;
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
		this.room_cache = new ArrayList<>();
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
	public Iterator<RoomPO> getRoomList(String hotelID) throws NetException {
		if (!current_hotel.equals(hotelID)) {
			try {
				room_cache = room_service.getRoom(hotelID);
			} catch (RemoteException e) {
				throw new NetException();
			}
		}
		return room_cache.iterator();
	}

	/**
	 * 获取房间信息
	 *
	 * @param hotelID
	 * @param roomNumber
	 * @return
	 * @throws RemoteException
	 */
	public RoomPO getRoomInfo(String hotelID, String roomNumber) throws NetException {
		// Most operation is handle here
		if (current_hotel.equals(hotelID)) {
			for(RoomPO each : room_cache) {
				if(each.getRoomNumber().equals(roomNumber)) {
					return new RoomPO(each);
				}
			}
			
		}
		// Error may happen when request from server
		try {
			return room_service.getRoomInfo(hotelID, roomNumber);
		} catch (RemoteException e) {
			throw new NetException();
		}
	}
	
	/**
	 * 添加房间
	 * 
	 * @param po
	 * @return
	 * @throws RemoteException
	 *             : Net Error
	 */
	public ResultMessage_Room addRoom(RoomPO po) {
		try {
			// Reload cache.
			getRoomList(po.getHotelID());
			// Check Room.
			RoomPO contains = checkContain(po.getHotelID(), po.getRoomNumber());
			if (contains != null) {
				return ResultMessage_Room.Room_Exist_Already;
			} else {
				ResultMessage_Room result = ResultMessage_Room.Room_Add_Successful;
				// Update Server
				result = room_service.addRoom(po);
				if (result.equals(ResultMessage_Room.Room_Add_Successful)) {
					// Update Cache
					room_cache = room_service.getRoom(current_hotel);
				}
				return result;
			}
		} catch (RemoteException | NetException e) {
			return ResultMessage_Room.Net_Error;
		}
	}

	/**
	 * 入住酒店
	 * 
	 * @param hotelID
	 * @param roomNumber
	 * @return
	 */
	public ResultMessage_Room checkIn(String hotelID, String roomNumber, boolean isOnline) {
		ResultMessage_Room result = null;
		try {
			// 更新服务器端信息
			result = room_service.checkIn(hotelID, roomNumber, isOnline);
		} catch (RemoteException e) {
			// 网络错误，中断操作
			return ResultMessage_Room.Net_Error;
		}
		// 更新本地缓存
		if (result.equals(ResultMessage_Room.Check_In_Successful)) {
			RoomPO contains = checkContain(hotelID, roomNumber);
			if (contains != null) {
				contains.setCondition(RoomState.Occupied);
			}
		}
		return result;
	}

	public ResultMessage_Room checkOut(String hotelID, String roomNumber, boolean isOnline) {
		ResultMessage_Room result = null;
		try {
			// 更新服务器端信息
			result = room_service.checkOut(hotelID, roomNumber, isOnline);
		} catch (RemoteException e) {
			// 网络错误，中断操作
			return ResultMessage_Room.Net_Error;
		}
		// 更新本地缓存
		if (result.equals(ResultMessage_Room.Check_Out_Successful)) {
			RoomPO contains = checkContain(hotelID, roomNumber);
			if (contains != null) {
				contains.setCondition(RoomState.NotReserved);
			}
		}
		return result;
	}
	
	private RoomPO checkContain(String hotelID,String roomNumber) {
		if(!current_hotel.equals(hotelID)) {
			return null;
		}
		for(RoomPO each : room_cache) {
			if(each.getRoomNumber().equals(roomNumber)) return each;
		}
		return null;
	}
	
	/**
	 * 获取房间预定记录
	 * 
	 * @param hotelID
	 * @param roomNumber
	 * @return
	 * @throws RemoteException
	 */
	public Iterator<RoomRecordPO> getOrderRecord(String hotelID, String roomNumber) throws NetException {
		try {
			return room_service.getOrderRecord(hotelID, roomNumber).iterator();
		} catch (RemoteException e) {
			throw new NetException();
		}
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
