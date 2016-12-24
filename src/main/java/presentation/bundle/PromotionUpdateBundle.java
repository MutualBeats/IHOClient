/**
 * @author huangxiao
 * @version 2016年12月18日
 */
package presentation.bundle;

import java.util.Enumeration;
import java.util.ResourceBundle;

import presentation.utilcontroller.PromotionUpdate;

public class PromotionUpdateBundle extends ResourceBundle{
	private PromotionUpdate update;
	private static final String Key ="update";
	
	
	public PromotionUpdateBundle(PromotionUpdate update) {
		this.update=update;
	}
	
	@Override
	protected Object handleGetObject(String key) {
		if(Key.equals(key)){
			return update;
		}
		return null;
	}

	
	@Override
	public Enumeration<String> getKeys() {
		return null;
	}
	
}
