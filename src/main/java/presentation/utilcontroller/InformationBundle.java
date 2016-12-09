package presentation.utilcontroller;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class InformationBundle extends ResourceBundle {

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