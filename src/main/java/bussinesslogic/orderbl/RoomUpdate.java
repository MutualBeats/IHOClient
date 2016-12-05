package bussinesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.room.RoomRecordPO;
import util.resultmessage.ResultMessage_Room;
import vo.room.RoomRecordVO;

public interface RoomUpdate {
	
	public ResultMessage_Room addRecord(RoomRecordPO record);

	public ResultMessage_Room deleteRecord(String orderID);
	
	public ResultMessage_Room onlineCheckIn(String hotelID, String roomNumber);
	
	public ResultMessage_Room onlineCheckOut(String hotelID, String roomNumber);
	
	public ArrayList<RoomRecordVO> getOrderRecord(String hotelID, String roomNumber) throws RemoteException;
	
}
