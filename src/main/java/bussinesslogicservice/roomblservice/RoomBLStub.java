package bussinesslogicservice.roomblservice;

import java.util.ArrayList;

import util.exception.NetException;
import util.resultmessage.ResultMessage_Room;
import util.room.RoomState;
import util.room.RoomType;
import vo.room.RoomRecordVO;
import vo.room.RoomVO;

public class RoomBLStub implements RoomBLService{

	public String hotelID = "00000001";
	public String roomNumber = "3B346"; 
	public RoomType type = RoomType.Four;
	public int price = 2000;
	private RoomState condition = RoomState.NotReserved;


	// 录入客房
	@Override
	public ArrayList<String> importRoom(ArrayList<RoomVO> importRoomList) {
		return new ArrayList<>();
	}


	// 得到某酒店房间列表
	@Override
	public ArrayList<RoomVO> getRoomList(String hotelID) {
		if(hotelID.equals("00000001")) {
			ArrayList<RoomVO> roomList = new ArrayList<RoomVO>();
			roomList.add(new RoomVO(hotelID, roomNumber, type, price, condition));
			return roomList;
		}
		else return null;
	}


	@Override
	public RoomVO getRoomInfo(String hotelID, String roomNumber) throws NetException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<RoomRecordVO> getOrderRecord(String hotelID, String roomNumber) throws NetException {
		if(hotelID.equals(this.hotelID) && roomNumber.equals(this.roomNumber)) {
			RoomRecordVO recordVO = new RoomRecordVO("2016/11/16", "2016/11/30", "000000000000001", hotelID, roomNumber);
			ArrayList<RoomRecordVO> recordVOs = new ArrayList<>();
			recordVOs.add(recordVO);
			return recordVOs;
		}
		return new ArrayList<>();
	}


	@Override
	public ResultMessage_Room addRecord(RoomRecordVO roomRecord) {
		return ResultMessage_Room.Record_Add_Successful;
	}


	@Override
	public ResultMessage_Room checkIn(String hotelID, String roomNumber) {
		return ResultMessage_Room.Check_In_Successful;
	}


	@Override
	public ResultMessage_Room checkOut(String hotelID, String roomNumber) {
		return ResultMessage_Room.Check_Out_Successful;
	}

	
}
