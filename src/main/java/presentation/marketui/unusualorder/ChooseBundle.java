package presentation.marketui.unusualorder;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class ChooseBundle extends ResourceBundle {

	private ChooseCredit choose;
	private final static String CHOOSE = "choose";

	/**
	 * @param choose
	 */
	public ChooseBundle(ChooseCredit choose) {
		super();
		this.choose = choose;
	}

	@Override
	protected Object handleGetObject(String key) {
		if (CHOOSE.equals(key)) {
			return choose;
		}
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
