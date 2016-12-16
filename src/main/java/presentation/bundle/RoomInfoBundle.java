/**
 * @author huangxiao
 * @version 2016年12月16日
 */
package presentation.bundle;

import java.util.Enumeration;
import java.util.ResourceBundle;

import vo.room.RoomVO;

public class RoomInfoBundle extends ResourceBundle {
	
	private RoomVO room;
	
	private static final String ROOM = "room";

	public RoomInfoBundle(RoomVO room) {
		super();
		this.room = room;
	}
	
	@Override
	protected Object handleGetObject(String key) {
		if (ROOM.equals(key))
			return room;
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		return null;
	}

}
