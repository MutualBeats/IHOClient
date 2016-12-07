package bussinesslogic.roombl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogic.orderbl.RoomUpdate;
import bussinesslogicservice.roomblservice.RoomBLService;
import po.room.RoomRecordPO;
import util.resultmessage.ResultMessage_Room;
import vo.room.RoomRecordVO;
import vo.room.RoomVO;

public class RoomController implements RoomBLService, RoomUpdate{

	private Room room;
	
	public RoomController() throws Exception {
		room = new Room();
	}
	
	@Override
	public ResultMessage_Room checkIn(String hotelID, String roomNumber) {
		return room.checkIn(hotelID, roomNumber, false);
	}

	@Override
	public ResultMessage_Room checkOut(String hotelID, String roomNumber) {
		return room.checkOut(hotelID, roomNumber, false);
	}

	@Override
	public ArrayList<String> importRoom(ArrayList<RoomVO> importRoomList) throws RemoteException {
		return room.importRoom(importRoomList);
	}

	@Override
	public ArrayList<RoomVO> getRoomList(String hotelID) throws RemoteException {
		return room.getRoomList(hotelID);
	}
	@Override
	public ArrayList<RoomRecordVO> getOrderRecord(String hotelID, String roomNumber) throws RemoteException {
		return room.getOrderReord(hotelID, roomNumber);
	}
	@Override
	public ResultMessage_Room addRecord(RoomRecordPO record) {
		return room.addRecord(record);
	}
	@Override
	public ResultMessage_Room deleteRecord(String orderID) {
		return room.deleteRecord(orderID);
	}
	@Override
	public RoomVO getRoomInfo(String hotelID, String roomNumber ) throws RemoteException {
		return room.getRoomInfo(hotelID, roomNumber);
	}

	@Override
	public ResultMessage_Room onlineCheckIn(String hotelID, String roomNumber) {
		return room.checkIn(hotelID, roomNumber, true);
	}

	@Override
	public ResultMessage_Room onlineCheckOut(String hotelID, String roomNumber) {
		return room.checkOut(hotelID, roomNumber, true);
	}

	@Override
	public int getRoomPrice(String hotelID, String roomNumber) throws RemoteException {
		return room.getRoomInfo(hotelID, roomNumber).price;
	}

	
}
