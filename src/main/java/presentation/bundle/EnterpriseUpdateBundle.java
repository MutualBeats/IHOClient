package presentation.bundle;

import java.util.Enumeration;
import java.util.ResourceBundle;

import presentation.staffui.hotelpromotion.Update;

public class EnterpriseUpdateBundle extends ResourceBundle {
	
	private Update update;
	private final static String BUNDLE = "update";
	
	public EnterpriseUpdateBundle(Update update) {
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
