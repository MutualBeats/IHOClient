package bussinesslogic.roombl;

import java.util.ArrayList;

import bussinesslogicservice.roomblservice.RoomBLService;
import util.ResultMessage;
import vo.RoomVO;

public class RoomController implements RoomBLService{

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
	public ResultMessage checkIn(String roomID, String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage checkOut(String roomID, String date) {
		// TODO Auto-generated method stub
		return null;
	}

}
