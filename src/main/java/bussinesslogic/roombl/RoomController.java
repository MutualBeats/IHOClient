package bussinesslogic.roombl;

import java.util.ArrayList;

import bussinesslogic.orderbl.RoomUpdate;
import bussinesslogicservice.roomblservice.RoomBLService;
import util.ResultMessage;
import vo.RoomVO;

public class RoomController implements RoomBLService, RoomUpdate{

	private Room room = new Room();
	
	@Override
	public ResultMessage importRoom(ArrayList<RoomVO> importRoomList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RoomVO> getRoom(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage checkIn(String hotelID, String roomID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage checkOut(String hotelID, String roomID) {
		// TODO Auto-generated method stub
		return null;
	}

}
