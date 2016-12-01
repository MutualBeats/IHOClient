package config;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import util.UserIdentity;

/**
 * 
 * Identify Verify
 * 
 * @author heleninsa
 *
 */
public class NumberConfig {

	
	private final static String length_cfg_path = "src/main/resources/length_config.xml";
	
	private static int USER_NAME_MIN_LENGTH;
	private static int USER_NAME_MAX_LENGTH;
	
	private static int PASSWORD_MIN_LENGTH;
	private static int PASSWORD_MAX_LENGTH;
	
	private static int PHONE_LENGTH;
	
	static {
		number_config_parse();
	}
	
	private static void number_config_parse() {
		SAXReader reader = new SAXReader();
		File cfg_file = new File(length_cfg_path);
		try {
			Document document = reader.read(cfg_file);
			Element root = document.getRootElement();
			//Element Reach
			Element username = root.element("username");
			Element password = root.element("password");
			Element phone = root.element("phone");
			//INIT
			int user_min = Integer.parseInt(username.attributeValue("min_length"));
			int user_max = Integer.parseInt(username.attributeValue("max_length"));
			int pass_min = Integer.parseInt(password.attributeValue("min_length"));
			int pass_max = Integer.parseInt(password.attributeValue("max_length"));
			int ph = Integer.parseInt(phone.attributeValue("phone_length"));
			init(user_min, user_max, pass_min, pass_max, ph);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	/**
	 * Initialization of length config
	 * 
	 * @param user_min
	 * @param user_max
	 * @param pass_min
	 * @param pass_max
	 */
	private static void init(int user_min, int user_max, int pass_min, int pass_max, int ph) {
		USER_NAME_MIN_LENGTH = user_min;
		USER_NAME_MAX_LENGTH = user_max;
		PASSWORD_MIN_LENGTH = pass_min;
		PASSWORD_MAX_LENGTH = pass_max;
		PHONE_LENGTH = ph;
	}

	
	public static void main(String[] args) {
		System.out.println(PHONE_LENGTH);
	}
	
	/**
	 * check the identity of user
	 * 
	 * @param user_name
	 *            : Identity of user
	 * @return
	 */
	public static UserIdentity identify(String user_name) {
		return null;
	}

	
	/**
	 * Check the name formatter
	 * 
	 * @param length
	 * @return
	 */
	public static boolean nameFormatterCheck(int length) {
		if(length > USER_NAME_MAX_LENGTH || length < USER_NAME_MIN_LENGTH) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Check the password formatter
	 * 
	 * @param length
	 * @return
	 */
	public static boolean passFormatterCheck(int length) {
		if(length > PASSWORD_MAX_LENGTH || length < PASSWORD_MIN_LENGTH) {
			return false;
		}
		
		return true;	
	}

}
