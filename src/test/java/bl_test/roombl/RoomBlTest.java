package bl_test.roombl;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.roombl.RoomController;
import dataservice.roomdataservice.ResultMessage_Room;
import po.room.RoomRecordPO;
import util.RoomCondition;
import util.RoomType;
import vo.room.RoomVO;

public class RoomBLTest {

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(failedList.size(), 1);
	}
	
	@Test
	public void testCheckIn() {
		ResultMessage_Room result = null;
		result = controller.checkIn("00000001", "3B323"); 
		if(!result.equals(ResultMessage_Room.Net_Error)) {
			assertEquals(result, ResultMessage_Room.Check_In_Successful);
		}
		result = controller.checkIn("00000001", "3B322"); 
		if(!result.equals(ResultMessage_Room.Net_Error)) {
			assertEquals(result, ResultMessage_Room.Check_In_Successful);
		}
		result = controller.checkIn("00000001", "3B321"); 
		if(!result.equals(ResultMessage_Room.Net_Error)) {
			assertEquals(result, ResultMessage_Room.Check_In_Successful);
		}
		result = controller.checkIn("00000001", "3B321"); 
		if(!result.equals(ResultMessage_Room.Net_Error)) {
			assertEquals(result, ResultMessage_Room.Check_In_Failed);
		}
	}
	
	@Test
	public void testCheckOut() {
		ResultMessage_Room result = null;
		result = controller.checkOut("00000001", "3B323"); 
		if(!result.equals(ResultMessage_Room.Net_Error)) {
			assertEquals(result, ResultMessage_Room.Check_Out_Successful);
		}
		result = controller.checkOut("00000001", "3B322"); 
		if(!result.equals(ResultMessage_Room.Net_Error)) {
			assertEquals(result, ResultMessage_Room.Check_Out_Successful);
		}
		result = controller.checkOut("00000001", "3B321"); 
		if(!result.equals(ResultMessage_Room.Net_Error)) {
			assertEquals(result, ResultMessage_Room.Check_Out_Successful);
		}
		result = controller.checkOut("00000001", "3B321"); 
		if(!result.equals(ResultMessage_Room.Net_Error)) {
			assertEquals(result, ResultMessage_Room.Check_Out_Failed);
		}
	}
	
	@Test
	public void testRecord() {
		ResultMessage_Room result = null;
		result = controller.addRecord(new RoomRecordPO("00000001", "3B323", "0000000000000001"
				+ "", "2016/11/26","2016/11/27"));		
	}

}
