/**
 * @author huangxiao
 * 2016年11月6日
 */
package bl_test.roombl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.roombl.Room;
import util.ResultMessage_For_Stub;
import util.RoomCheckRecord;
import util.RoomConditionOfDate;
import util.RoomType;
import vo.room.RoomVO;

public class RoomBlTest {
	
	RoomVO vo;
	Room room;
	
	@Before
	public void init() {
		vo = new RoomVO("00000001", "3B323", RoomType.Single, 100, new ArrayList<RoomCheckRecord>(), new ArrayList<RoomConditionOfDate>());
		room = new Room();
	}

	@Test
	public void testImportRoom() {
		ArrayList<RoomVO> roomList = new ArrayList<RoomVO>();
		roomList.add(vo);
		assertEquals(ResultMessage_For_Stub.ImportSuccess, room.importRoom(roomList));
	}
	
	@Test
	public void testGetRoom() {
		boolean contain = false;
		ArrayList<RoomVO> rooms = room.getRoomList("00000001");
		for(RoomVO room : rooms) {
			if(room.equals(vo)) {
				contain = true;
				break;
			}
		}
		assertEquals(true, contain);
	}
	
	@Test
	public void testCheckIn() {
		assertEquals(ResultMessage_For_Stub.RoomUpdateSuccess, room.checkIn(vo.hotelID, vo.roomNumber));
	}
	
	@Test
	public void testCheckOut() {
		assertEquals(ResultMessage_For_Stub.RoomUpdateSuccess, room.checkOut(vo.hotelID, vo.roomNumber));
	}

}
