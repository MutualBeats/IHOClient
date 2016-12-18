package presentation.bundle;

import java.util.Enumeration;
import java.util.ResourceBundle;

import presentation.staffui.roommanage.UpdateRoomRecord;

public class RoomRecordUpdateBundle extends ResourceBundle {
	
	private UpdateRoomRecord update;
	private static final String KEY = "update";

	public RoomRecordUpdateBundle(UpdateRoomRecord update) {
		this.update = update;
	}
	
	@Override
	protected Object handleGetObject(String key) {
		if(KEY.equals(key)) {
			return update;
		}
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		return null;
	}

}
