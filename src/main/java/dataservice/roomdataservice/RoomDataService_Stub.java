/**
 * @author huangxiao
 */
package dataservice.roomdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.room.RoomPO;
import po.room.RoomRecordPO;
import util.Time;
import util.resultmessage.ResultMessage_Room;
import util.room.RoomState;
import util.room.RoomType;

public class RoomDataService_Stub implements RoomDataService {
	
	private static final int HOTEL_ID_LENGTH = 8;
	private static final int ORDER_ID_LENGTH = 16;

	private RoomPO room;
	
	public RoomDataService_Stub() {
		room = new RoomPO();
		room.setHotelID("00000001");
		room.setRoomNumber("3B323");
		room.setType(RoomType.Double);
		room.setPrice(512);
		room.setCondition(RoomState.NotReserved);
	}
	
	@Override
	public ArrayList<RoomPO> getRoom(String hotelID) throws RemoteException {
		ArrayList<RoomPO> rooms = new ArrayList<>();
		if(hotelID.length() != HOTEL_ID_LENGTH)
			return rooms;
		room.setHotelID(hotelID);
		rooms.add(room);
		return rooms;
	}

	@Override
	public RoomPO getRoomInfo(String hotelID, String roomNumber) throws RemoteException {
		if(hotelID.length() != HOTEL_ID_LENGTH)
			return null;
		room.setHotelID(hotelID);
		room.setRoomNumber(roomNumber);
		return room;
	}

	@Override
	public ResultMessage_Room addRoom(RoomPO po) throws RemoteException {
		if(po.getHotelID().length() != HOTEL_ID_LENGTH)
			return null;
		return ResultMessage_Room.Room_Add_Successful;
	}

	@Override
	public ResultMessage_Room checkIn(String hotelID, String roomNumber, boolean isOnline) throws RemoteException {
		return ResultMessage_Room.Check_In_Successful;
	}

	@Override
	public ResultMessage_Room checkOut(String hotelID, String roomNumber, boolean isOnline) throws RemoteException {
		return ResultMessage_Room.Check_Out_Successful;
	}

	@Override
	public ArrayList<RoomRecordPO> getOrderRecord(String hotelID, String roomNumber) throws RemoteException {
		RoomRecordPO record = new RoomRecordPO();
		record.setHotelID(hotelID);
		record.setRoomNumber(roomNumber);
		record.setOrderID("");
		record.setCheckInDate(Time.getCurrentDate());
		record.setEstimateCheckOutDate(Time.getCurrentDate());
		ArrayList<RoomRecordPO> records = new ArrayList<>();
		records.add(record);
		return records;
	}

	@Override
	public ResultMessage_Room addRecord(RoomRecordPO po) throws RemoteException {
		return ResultMessage_Room.Record_Add_Successful;
	}

	@Override
	public ResultMessage_Room deleteRecord(String orderID) throws RemoteException {
		if(orderID.length() != ORDER_ID_LENGTH)
			return ResultMessage_Room.Room_Record_Not_Exist;
		return ResultMessage_Room.Record_Delete_Successful;
	}

}
