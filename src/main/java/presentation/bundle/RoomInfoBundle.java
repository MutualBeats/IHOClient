/**
 * @author huangxiao
 * @version 2016年12月16日
 */
package presentation.bundle;

import java.util.Enumeration;
import java.util.ResourceBundle;

import presentation.staffui.roommanage.UpdateRoomRecord;
import vo.room.RoomVO;

public class RoomInfoBundle extends ResourceBundle {
	
	private RoomVO room;
	
	private UpdateRoomRecord updateRoomRecord;
	
	private static final String ROOM = "room";
	private static final String UPDATE = "update";

	public RoomInfoBundle(RoomVO room, UpdateRoomRecord updateRoomRecord) {
		super();
		this.room = room;
		this.updateRoomRecord = updateRoomRecord;
	}
	
	@Override
	protected Object handleGetObject(String key) {
		if (ROOM.equals(key))
			return room;
		else if(UPDATE.equals(key))
			return updateRoomRecord;
		
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		return null;
	}

}
