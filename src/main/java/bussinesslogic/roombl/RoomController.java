package bussinesslogic.roombl;

import java.util.ArrayList;

import bussinesslogic.orderbl.RoomUpdate;
import bussinesslogicservice.roomblservice.RoomBLService;
import dataservice.roomdataservice.ResultMessage_Room;
import util.ResultMessage_For_Stub;
import vo.room.RoomVO;

public class RoomController implements RoomBLService, RoomUpdate{

	private Room room = new Room();

	@Override
	public ResultMessage_Room checkIn(String hotelID, String roomID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage_Room checkOut(String hotelID, String roomID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage_Room importRoom(ArrayList<RoomVO> importRoomList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RoomVO> getRoom(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
