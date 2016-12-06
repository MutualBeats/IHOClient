package bl_test.roombl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.roombl.RoomController;
import po.room.RoomRecordPO;
import util.resultmessage.ResultMessage_Room;
import util.room.RoomState;
import util.room.RoomType;
import vo.room.RoomRecordVO;
import vo.room.RoomVO;

public class RoomBlTest {

	private RoomController controller;

	@Before
	public void init() {
		try {
			controller = new RoomController();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Only the first test is effective
	 */
	@Test
	public void testImport() {
		ArrayList<RoomVO> roomList = new ArrayList<>();
		roomList.add(new RoomVO("00000001", "3B323", RoomType.Double, 200, RoomState.NotReserved));
		roomList.add(new RoomVO("00000001", "3B322", RoomType.Single, 600, RoomState.NotReserved));
		roomList.add(new RoomVO("00000001", "3B320", RoomType.Triple, 200, RoomState.NotReserved));
		roomList.add(new RoomVO("00000001", "3B321", RoomType.Four, 200, RoomState.NotReserved));
		ArrayList<String> failedList = null;
		try {
			failedList = controller.importRoom(roomList);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		assertEquals(failedList.size(), 4);
	}
	
	@Test
	public void tesGetRoomList() {
		try {
			ArrayList<RoomVO> rooms = controller.getRoomList("00000001");
			assertEquals(rooms.size(), 5);
			RoomVO first = rooms.get(0);
			assertEquals(first.condition, RoomState.Reserved);
			assertEquals(first.type, RoomType.Single);
			assertEquals(first.price, 256);
			assertEquals(first.roomNumber, "3B346");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
// Test Can Only Excute One Time
//	@Test
//	public void testCheckInAndOut() {
//		ResultMessage_Room result = null;
//		// In
//		result = controller.checkIn("00000001", "3B323");
//		if (!result.equals(ResultMessage_Room.Net_Error)) {
//			assertEquals(ResultMessage_Room.Check_In_Successful,result);
//			result = controller.checkOut("00000001", "3B323");
//			if (!result.equals(ResultMessage_Room.Net_Error)) {
//				assertEquals(ResultMessage_Room.Check_Out_Successful,result);
//			}
//		}
//		result = controller.checkIn("00000001", "3B322");
//		if (!result.equals(ResultMessage_Room.Net_Error)) {
//			assertEquals( ResultMessage_Room.Check_In_Failed,result);
//		}
//		result = controller.checkIn("00000001", "3B321");
//		if (!result.equals(ResultMessage_Room.Net_Error)) {
//			assertEquals(ResultMessage_Room.Check_In_Failed,result);
//		}
//	}
//
	@Test
	public void testRecord() {
		ResultMessage_Room result = null;
		result = controller
				.addRecord(new RoomRecordPO("00000001", "3B323", "0000000000000004"
						, "2016/11/29", "2016/11/30"));
		if (!result.equals(ResultMessage_Room.Net_Error)) {
			assertEquals(result, ResultMessage_Room.Record_Add_Successful);
			result = controller.deleteRecord("0000000000000004");
			if (!result.equals(ResultMessage_Room.Net_Error)) {
				assertEquals(result, ResultMessage_Room.Record_Delete_Successful);
				result = controller
						.addRecord(new RoomRecordPO("00000001", "3B323", "0000000000000005"
								, "2016/11/30", "2016/11/32"));
				if(!result.equals(ResultMessage_Room.Net_Error)) {
					assertEquals(result, ResultMessage_Room.Record_Add_Successful);
					result = controller.deleteRecord("0000000000000005");
					assertEquals(ResultMessage_Room.Record_Delete_Successful, result);
				}
			}
		}
	}
	
	@Test
	public void testRoomInfoGet() {
		try {
			RoomVO roomInfo = controller.getRoomInfo("00000001", "3B323");
			assertEquals(roomInfo.price, 1024);
			assertEquals(roomInfo.type, RoomType.Four);
			assertEquals(roomInfo.condition, RoomState.NotReserved);
		} catch (RemoteException e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testGetRecord() {
		try {
			ArrayList<RoomRecordVO> records = controller.getOrderRecord("00000001", "3B323");
			assertEquals(records.size(), 2);
			RoomRecordVO newest = records.get(0);
			assertEquals(newest.checkInDate, "2016/11/27");
			assertEquals(newest.estimateCheckOutDate, "2016/11/27");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
}
