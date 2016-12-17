/**
 * @author huangxiao
 * @version 2016年12月18日
 */
package presentation.bundle;

import java.util.Enumeration;
import java.util.ResourceBundle;

import vo.promotion.PromotionVO;

public class PromotionInfoBundle extends ResourceBundle {
	
	private PromotionVO promtion;
	
	private static final String PROMOTION = "promotion";
	
	public PromotionInfoBundle(PromotionVO promotion) {
		super();
		this.promtion = promotion;
	}

	@Override
	protected Object handleGetObject(String key) {
		if (PROMOTION.equals(key))
			return promtion;
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		return null;
	}
	
	

}
