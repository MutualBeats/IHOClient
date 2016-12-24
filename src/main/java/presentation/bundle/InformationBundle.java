package presentation.bundle;

import java.util.Enumeration;
import java.util.ResourceBundle;

/**
 * 
 * 人员信息Bundle
 * 
 * @author heleninsa
 *
 */
public class InformationBundle extends ResourceBundle {
	
	/**
	 * 根据不同类型的人员，传递对应VO
	 */
	private Object information;
	private final static String INFOR_MATION_KEY = "info";

	public InformationBundle(Object information) {
		super();
		this.information = information;
	}

	@Override
	protected Object handleGetObject(String key) {
		if (INFOR_MATION_KEY.equals(key)) {
			return information;
		}
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		return null;
	}

}