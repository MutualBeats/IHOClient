/**
 * @author huangxiao
 * 2016年10月15日
 */
package bussinesslogicservice.roomblservice;

import java.util.ArrayList;

import util.*;
import vo.RoomVO;

public class RoomBLService_Driver {

	public void drive(RoomBLService roomBLService) {
		ResultMessage result;
		ArrayList<RoomVO> roomList = new ArrayList<RoomVO>();
		roomList.add(new RoomVO("00000001", "1234", RoomType.Single, 100, new ArrayList<RoomCheckRecord>(), new ArrayList<RoomConditionOfDate>()));
		result = roomBLService.importRoom(roomList);
		if(result == ResultMessage.ImportSuccess)
			System.out.println("Success\n");
		else
			System.out.println("Failed\n");
		
		result = roomBLService.checkIn("3B323", "2016/11/4");
		if(result == ResultMessage.RoomUpdateSuccess)
			System.out.println("Success\n");
		else
			System.out.println("Failed\n");
		result = roomBLService.checkOut("3B323", "2016/11/4");
		if(result == ResultMessage.RoomUpdateSuccess)
			System.out.println("Success\n");
		else
			System.out.println("Failed\n");
		
		ArrayList<RoomVO> rooms = roomBLService.getRoom("00000001");
		for (RoomVO roomVO : rooms)
			System.out.println(roomVO.hotelID + '\t' + roomVO.roomNumber + '\t' + roomVO.price);
		
	}
}
