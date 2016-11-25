package factory.datahelper;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import bussinesslogic.hotelbl.Hotel;
import bussinesslogic.roombl.Room;
import dataservice.roomdataservice.RoomDataService;
import po.RoomPO;
import util.result_message.room.ResultMessage_RoomBL;

/**
 * @author Saltwater
 * @version 1.0
 */
public class RoomDataHelper {

	private RoomDataService room_service;
	/**
	 * Cache for room . Store all the room info in specific hotel
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
			ArrayList<RoomPO> rooms = room_service.find(hotelID);
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
	public ResultMessage_RoomBL addRoom(RoomPO po) {
		if (!po.getHotelID().equals(current_hotel)) {
			// Reload cache.
			try {
				getRoomList(po.getHotelID());
			} catch (RemoteException e) {
				return ResultMessage_RoomBL.Net_Error;
			}
		}
		// Check Room.
		if (room_cache.containsKey(po.getRoomNumber())) {
			return ResultMessage_RoomBL.Room_Exist_Already;
		} else {
			//Update Cache
			po.setHotelID(current_hotel);
			room_cache.put(po.getRoomNumber(), po);
			return ResultMessage_RoomBL.Room_Add_Successful;
		}	
	}
	
	public ResultMessage_RoomBL checkIn() {
		
	}
	
	/**
	 * Update Room Info 
	 * 
	 * @param po
	 * @return
	 */
	private ResultMessage_RoomBL update(RoomPO po) {
		// TODO Auto-generated method stub
		return null;
	}

}
