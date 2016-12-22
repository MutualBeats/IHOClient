/**
 * @author huangxiao
 * @version 2016年12月16日
 */
package presentation.bundle;

import java.util.Enumeration;
import java.util.ResourceBundle;

import presentation.staffui.roommanage.UpdateRoom;
import presentation.staffui.roommanage.UpdateRoomRecord;
import vo.room.RoomVO;

public class RoomInfoUpdateBundle extends ResourceBundle {
	
	private RoomVO room;
	private static final String ROOM = "room";
	
	private UpdateRoom updateRoom;
	private static final String UPDATE_ROOM = "updateRoom";

	private UpdateRoomRecord updateRoomRecord;
	private static final String UPDATE_RECORD = "updateRoomRecord";
	
	public RoomInfoUpdateBundle(RoomVO room, UpdateRoom updateRoom, UpdateRoomRecord updateRoomRecord) {
		super();
		this.room = room;
		this.updateRoom = updateRoom;
		this.updateRoomRecord = updateRoomRecord;
	}
	
	@Override
	protected Object handleGetObject(String key) {
		if (ROOM.equals(key))
			return room;
		else if(UPDATE_ROOM.equals(key))
			return updateRoom;
		else if(UPDATE_RECORD.equals(key))
			return updateRoomRecord;
		
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		return null;
	}

}
