package bussinesslogicservice.roomblservice;

import java.util.ArrayList;

import dataservice.roomdataservice.ResultMessage_Room;
import util.RoomCheckRecord;
import util.RoomConditionOfDate;
import util.RoomType;
import vo.room.RoomVO;

public class RoomBLService_Stub implements RoomBLService {

	public String hotelID;
	public String roomNumber;
	public RoomType type;
	public int price;
	public ArrayList<RoomCheckRecord> checkRecordList;
	public ArrayList<RoomConditionOfDate> conditionList;

	public RoomBLService_Stub(String hotelID, String roomNumber, RoomType type, int price, 
							ArrayList<RoomCheckRecord> checkRecordList, ArrayList<RoomConditionOfDate> conditionList) {
		this.hotelID = hotelID;
		this.roomNumber = roomNumber;
		this.type = type;
		this.price = price;
		this.checkRecordList = checkRecordList;
		this.conditionList = conditionList;	
	}

	// 录入客房
	@Override
	public ResultMessage_Room importRoom(ArrayList<RoomVO> importRoomList) {
		if(importRoomList.size() == 1)
			return ResultMessage_Room.Import_Successful;
		else return ResultMessage_Room.Import_Failed;
	}

	// 得到某酒店房间列表
	@Override
	public ArrayList<RoomVO> getRoom(String hotelID) {
		if(hotelID.equals("00000001")) {
			ArrayList<RoomVO> roomList = new ArrayList<RoomVO>();
			roomList.add(new RoomVO(hotelID, roomNumber, type, price, checkRecordList, conditionList));
			return roomList;
		}
		else return null;
	}
	
	// 客户入住
	@Override
	public ResultMessage_Room checkIn(String hotelID, String roomID) {
		return ResultMessage_Room.Check_In_Successful;
	}
	
	// 客户退房
	@Override
	public ResultMessage_Room checkOut(String hotelID, String roomID) {
		return ResultMessage_Room.Check_Out_Successful;
	}
	
}

