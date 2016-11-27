package bl_test.roombl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.roombl.RoomController;
import dataservice.roomdataservice.ResultMessage_Room;
import po.room.RoomRecordPO;
import util.RoomCondition;
import util.RoomType;
import vo.room.RoomRecordVO;
import vo.room.RoomVO;

public class RoomBlTest {

	private RoomController controller;

	@Before
	public void init() {
		controller = new RoomController();
	}

	/**
	 * Only the first test is effective
	 */
	@Test
	public void testImport() {
		ArrayList<RoomVO> roomList = new ArrayList<>();
		roomList.add(new RoomVO("00000001", "3B323", RoomType.Double, 200, RoomCondition.NotReserved));
		ArrayList<String> failedList = null;
		try {
			failedList = controller.importRoom(roomList);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		assertEquals(failedList.size(), 1);
	}
	
	@Test
	public void tesGetRoomList() {
		try {
			ArrayList<RoomVO> rooms = controller.getRoomList("00000001");
			assertEquals(rooms.size(), 3);
			RoomVO first = rooms.get(0);
			assertEquals(first.condition, RoomCondition.NotReserved);
			assertEquals(first.price, 233);
			assertEquals(first.roomNumber, "3B323");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCheckInAndOut() {
		ResultMessage_Room result = null;
		// In
		result = controller.checkIn("00000001", "3B323");
		if (!result.equals(ResultMessage_Room.Net_Error)) {
			assertEquals(result, ResultMessage_Room.Check_In_Successful);
		}
		result = controller.checkIn("00000001", "3B322");
		if (!result.equals(ResultMessage_Room.Net_Error)) {
			assertEquals(result, ResultMessage_Room.Check_In_Successful);
		}
		result = controller.checkIn("00000001", "3B321");
		if (!result.equals(ResultMessage_Room.Net_Error)) {
			assertEquals(result, ResultMessage_Room.Check_In_Successful);
		}
		result = controller.checkIn("00000001", "3B321");
		if (!result.equals(ResultMessage_Room.Net_Error)) {
			assertEquals(result, ResultMessage_Room.Check_In_Failed);
		}
		// Out
		result = controller.checkOut("00000001", "3B323");
		if (!result.equals(ResultMessage_Room.Net_Error)) {
			assertEquals(result, ResultMessage_Room.Check_Out_Successful);
		}
		result = controller.checkOut("00000001", "3B322");
		if (!result.equals(ResultMessage_Room.Net_Error)) {
			assertEquals(result, ResultMessage_Room.Check_Out_Successful);
		}
		result = controller.checkOut("00000001", "3B321");
		if (!result.equals(ResultMessage_Room.Net_Error)) {
			assertEquals(result, ResultMessage_Room.Check_Out_Successful);
		}
		result = controller.checkOut("00000001", "3B321");
		if (!result.equals(ResultMessage_Room.Net_Error)) {
			assertEquals(result, ResultMessage_Room.Check_Out_Failed);
		}
	}

	@Test
	public void testRecord() {
		ResultMessage_Room result = null;
		result = controller
				.addRecord(new RoomRecordPO("00000001", "3B323", "0000000000000001"
						, "2016/11/26", "2016/11/30"));
		if (!result.equals(ResultMessage_Room.Net_Error)) {
			assertEquals(result, ResultMessage_Room.Time_Conflict);
			result = controller.deleteRecord("0000000000000001");
			if (!result.equals(ResultMessage_Room.Net_Error)) {
				assertEquals(result, ResultMessage_Room.Record_Delete_Successful);
			}
		}
		result = controller
				.addRecord(new RoomRecordPO("00000001", "3B323", "0000000000000002"
						, "2016/11/30", "2016/11/32"));
	}
	
	@Test
	public void testRoomInfoGet() {
		try {
			RoomVO roomInfo = controller.getRoomInfo("00000001", "3B323");
			assertEquals(roomInfo.price, 233);
			assertEquals(roomInfo.type, RoomType.Four);
			assertEquals(roomInfo.condition, RoomCondition.Occupied);
			roomInfo = controller.getRoomInfo("00000001", "3B3564");
			assertNull(roomInfo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testGetRecord() {
		try {
			ArrayList<RoomRecordVO> records = controller.getOrderReord("00000001", "3B323");
			assertEquals(records.size(), 3);
			RoomRecordVO newest = records.get(0);
			assertEquals(newest.checkInDate, "2016/11/26");
			assertEquals(newest.estimateCheckOutDate, "2016/11/27");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
}
