package bussinesslogic.roombl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogic.orderbl.RoomUpdate;
import bussinesslogicservice.roomblservice.RoomBLService;
import dataservice.roomdataservice.ResultMessage_Room;
import po.room.RoomRecordPO;
import vo.room.RoomRecordVO;
import vo.room.RoomVO;

public class RoomController implements RoomBLService, RoomUpdate{

	private Room room = new Room();

	@Override
	public ResultMessage_Room checkIn(String hotelID, String roomNumber) {
		return room.checkIn(hotelID, roomNumber);
	}

	@Override
	public ResultMessage_Room checkOut(String hotelID, String roomNumber) {
		return room.checkOut(hotelID, roomNumber);
	}

	@Override
	public ArrayList<String> importRoom(ArrayList<RoomVO> importRoomList) throws RemoteException {
		return room.importRoom(importRoomList);
	}

	@Override
	public ArrayList<RoomVO> getRoomList(String hotelID) throws RemoteException {
		return room.getRoomList(hotelID);
	}
	
	public ArrayList<RoomRecordVO> getOrderReord(String hotelID, String roomNumber) throws RemoteException {
		return room.getOrderReord(hotelID, roomNumber);
	}


	public ResultMessage_Room addRecord(RoomRecordPO record) {
		return room.addRecord(record);
	}

	public ResultMessage_Room deleteRecord(String orderID) {
		return room.deleteRecord(orderID);
	}
	
	public RoomVO getRoomInfo(String hotelID, String roomNumber ) throws RemoteException {
		return room.getRoomInfo(hotelID, roomNumber);
	}
	
}
