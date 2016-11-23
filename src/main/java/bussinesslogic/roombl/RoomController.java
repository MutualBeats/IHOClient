package bussinesslogic.roombl;

import java.util.ArrayList;

import bussinesslogic.orderbl.RoomUpdate;
import bussinesslogicservice.roomblservice.RoomBLService;
import util.ResultMessage_For_Stub;
import vo.RoomVO;

public class RoomController implements RoomBLService, RoomUpdate{

	private Room room = new Room();
	
	@Override
	public ResultMessage_For_Stub importRoom(ArrayList<RoomVO> importRoomList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RoomVO> getRoom(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage_For_Stub checkIn(String hotelID, String roomID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage_For_Stub checkOut(String hotelID, String roomID) {
		// TODO Auto-generated method stub
		return null;
	}

}
