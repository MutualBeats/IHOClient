package config;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	
	private final static String length_cfg_path = "src/main/resources/config/length_config.xml";
		
	private static Pattern PHONE_PATTERN;
	
	private static Pattern USERNAME_PATTERN;
	
	private static Pattern NAME_PATTERN;
	
	private static Pattern PASS_PATTERN;
	
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
			Element name = root.element("name");
			Element password = root.element("password");
			Element phone = root.element("phone");
			//INIT
			String ph = phone.attributeValue("phone_pattern");
			String  un = username.attributeValue("name_pattern");
			String nm = name.attributeValue("name_pattern");
			String ps = password.attributeValue("pass_pattern");
			init(un,nm,ps,ph);
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
	private static void init(String username_pattern, String name_pattern, String pass_pattern, String ph_pattern) {
		PHONE_PATTERN = Pattern.compile(ph_pattern);
		USERNAME_PATTERN = Pattern.compile(username_pattern);
		NAME_PATTERN = Pattern.compile(name_pattern);
		PASS_PATTERN = Pattern.compile(pass_pattern);
	}

	
	public static void main(String[] args) {
		System.out.println(PHONE_PATTERN);
	}

	
	/**
	 * Check the user name formatter
	 * 
	 * @param length
	 * @return
	 */
	public static boolean userNameFormatterCheck(String user_name) {
		Matcher matcher = USERNAME_PATTERN.matcher(user_name);
		return matcher.matches();
	}
	
	/**
	 * Check the name formatter
	 * 
	 * @param name
	 * @return
	 */
	public static boolean nameFormatterCheck(String name) {
		Matcher matcher = NAME_PATTERN.matcher(name);
		return matcher.matches();
	}
	
	/**
	 * Check the password formatter
	 * 
	 * @param length
	 * @return
	 */
	public static boolean passFormatterCheck(String pass) {
		Matcher matcher = PASS_PATTERN.matcher(pass);
		return matcher.matches();
	}
	
	/**
	 * Check the phone formatter
	 * 
	 * @param phone
	 * @return
	 */
	public static boolean phoneFormatterCheck(String phone) {
		Matcher matcher = PHONE_PATTERN.matcher(phone);
		return matcher.matches();
	}

}
