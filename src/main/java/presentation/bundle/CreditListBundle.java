package presentation.bundle;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;

import vo.credit.CreditVO;

/**
 * 
 * 信用列表传递bundle
 * 
 * @author heleninsa
 *
 */
public class CreditListBundle extends ResourceBundle{

	private ArrayList<CreditVO> credit_record;

	private final static String RECORD = "credit";

	public CreditListBundle(ArrayList<CreditVO> credit_record) {
		super();
		this.credit_record = credit_record;
	}

	@Override
	protected Object handleGetObject(String key) {
		if (RECORD.equals(key)) {
			return credit_record;
		}
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		return null;
	}
	
}
