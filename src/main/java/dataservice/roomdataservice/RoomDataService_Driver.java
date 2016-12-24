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

public class RoomDataService_Driver {
	
	public void drive(RoomDataService roomDataService) throws RemoteException {
		ResultMessage_Room result;
		
		// 获取酒店房间
		ArrayList<RoomPO> roomList = roomDataService.getRoom("00000001");
		System.out.println("HotelID: 00000001 has " + roomList.size() + " rooms.");
		
		// 获取房间信息
		RoomPO roomPO = roomDataService.getRoomInfo("00000001", "3B323");
		System.out.println(roomPO.getCondition().toString() + " " + roomPO.getPrice());
	
		// 录入客房
		RoomPO room = new RoomPO();
		room.setHotelID("00000001");
		room.setRoomNumber("测试房间1");
		room.setType(RoomType.Double);
		room.setPrice(512);
		room.setCondition(RoomState.NotReserved);
		result = roomDataService.addRoom(room);
		System.out.println(result.toString());
		
		// 入住
		result = roomDataService.checkIn("00000001", "测试房间1", false);
		System.out.println(result.toString());
		
		// 退房
		result = roomDataService.checkOut("0000001", "测试房间1", false);
		System.out.println(result.toString());
		
		// 获取未来房间记录
		ArrayList<RoomRecordPO> records = roomDataService.getOrderRecord("00000001", "3B323");
		System.out.println("3B323 has " + records.size() + " records in the future");
		
		// 增加房间记录
		RoomRecordPO record = new RoomRecordPO();
		record.setHotelID("00000001");
		record.setRoomNumber("3B323");
		record.setOrderID("1000000000000000");
		record.setCheckInDate(Time.getCurrentDate());
		record.setEstimateCheckOutDate(Time.getCurrentDate());
		result = roomDataService.addRecord(record);
		System.out.println(result.toString());
		
		// 删除房间记录
		result = roomDataService.deleteRecord("1000000000000000");
		System.out.println(result.toString());
		
	}

}
