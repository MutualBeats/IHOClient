package presentation.bundle;

import java.util.Enumeration;
import java.util.ResourceBundle;

import presentation.staffui.roommanage.UpdateRoom;

public class RoomUpdateBundle extends ResourceBundle {
	
	private UpdateRoom update;
	private static final String BUNDLE = "update";
	
	public RoomUpdateBundle(UpdateRoom update) {
		this.update = update;
	}

	@Override
	protected Object handleGetObject(String key) {
		if(BUNDLE.equals(key)) {
			return update;
		}
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		return null;
	}

}
