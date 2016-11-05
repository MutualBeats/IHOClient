package bussinesslogicservice.roomblservice;

import java.util.ArrayList;

import util.*;
import vo.RoomVO;

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
	public ResultMessage importRoom(ArrayList<RoomVO> importRoomList) {
		if(importRoomList.size() == 1)
			return ResultMessage.ImportSuccess;
		else return ResultMessage.ImportFailed;
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
	public ResultMessage checkIn(String roomID, String date) {
		return ResultMessage.RoomUpdateSuccess;
	}
	
	// 客户退房
	@Override
	public ResultMessage checkOut(String roomID, String date) {
		return ResultMessage.RoomUpdateSuccess;
	}
}

