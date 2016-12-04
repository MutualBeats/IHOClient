/**
 * @author huangxiao
 * 2016年11月6日
 */
package bussinesslogic.roombl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogic.orderbl.RoomUpdate;
import util.resultmessage.ResultMessage_Room;
import vo.room.RoomRecordVO;

public class MockRoom extends Room implements RoomUpdate{

	public MockRoom() {
	}
	
	public ResultMessage_Room checkIn(String hotelID, String roomID) {
		return ResultMessage_Room.Check_In_Successful;
	}
	
	public ResultMessage_Room checkOut(String hotelID, String roomID) {
		return ResultMessage_Room.Check_Out_Successful;
	}

	@Override
	public ArrayList<RoomRecordVO> getOrderRecord(String hotelID, String roomNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
