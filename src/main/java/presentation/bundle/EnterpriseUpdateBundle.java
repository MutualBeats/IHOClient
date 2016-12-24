package presentation.bundle;

import java.util.Enumeration;
import java.util.ResourceBundle;

import presentation.staffui.hotelpromotion.UpdateEnterList;

/**
 * 
 * 会员记录更新接口bundle
 * 
 * @author heleninsa
 *
 */
public class EnterpriseUpdateBundle extends ResourceBundle {
	
	private UpdateEnterList update;
	private final static String BUNDLE = "update";
	
	public EnterpriseUpdateBundle(UpdateEnterList update) {
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
