package config;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class URLConfig {
	
	
	private final static String UI_CFG_PATH = "src/main/resources/config/url_config.xml";
	
	private final static String FXML_PATH = "fxml_path";
	
	private final static String CSS_PATH = "css_path";
	
	private final static String ROOT_PATH = "root_path";
	
	private static String FILE_ROOT_PATH;
	
	//Login ui 
	
	private static String LOGIN_FXML;
	
	private static String LOGIN_CSS;
	
	//Sign in ui
	
	private static String SIGNIN_FXML;
	
	private static String SIGNIN_CSS;

	//Staff ui
	
	private static String STAFF_MAIN_FXML;
	
	private static String STAFF_MAIN_CSS;
	
	//Staff : Maintain Hotel
	
	private static String MAINTAIN_HOTEL_FXML;
	
	private static String MAINTAIN_HOTEL_CSS;
	
	//Staff : Order manage
	
	private static String HOTEL_ORDER_MANAGE_FXML;
	
	private static String HOTEL_ORDER_MANAGE_CSS;
	
	//Staff : Room manage
	
	private static String ROOM_MANAGE_FXML;
	
	private static String ROOM_MANAGE_CSS;
	
	//Staff : Hotel promotion make
	
	private static String HOTEL_PROMOTION_FXML;
	
	private static String HOTEL_PROMOTION_CSS;
	
	
	
	static {
		url_config_parse();
	}
	
	private static void url_config_parse() {
		SAXReader reader = new SAXReader();
		File cfg_file = new File(UI_CFG_PATH);
		try {
			Document document = reader.read(cfg_file);
			Element root = document.getRootElement();
			//Element Reach
			//Root
			Element root_path = root.element("ui_root");
			FILE_ROOT_PATH = root_path.attributeValue(ROOT_PATH);
			
			//Each stage
			Element login = root.element("login");
			Element signin = root.element("signin");
			Element staff = root.element("staff");
			
			login_init(login);
			signin_init(signin);
			staff_init(staff);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	private static void login_init(Element login) {
		Element login_fxml = login.element("fxml");
		Element login_css = login.element("css");
		String login_root = login.attributeValue(ROOT_PATH);
		LOGIN_FXML = login_root + login_fxml.attributeValue(FXML_PATH);
		LOGIN_CSS = login_root + login_css.attributeValue(CSS_PATH);
	}
	
	private static void signin_init(Element signin) {
		Element signin_fxml = signin.element("fxml");
		Element signin_css = signin.element("css");
		String signin_root = signin.attributeValue(ROOT_PATH);
		SIGNIN_FXML = signin_root + signin_fxml.attributeValue(FXML_PATH);
		SIGNIN_CSS = signin_root + signin_css.attributeValue(CSS_PATH);
	}
	
	private static void staff_init(Element staff) {
		String staff_root = staff.attributeValue("root_path");
		
		Element staff_main = staff.element("staff_main");
		Element maintain_hotel = staff.element("maintain_hotel");
		Element room_manage = staff.element("room_manage");
		Element hotel_promotion = staff.element("hotel_promotion");
		
		Element fxml;
		Element css;
		
		//Main
		fxml = staff_main.element("fxml");
		css = staff_main.element("css");
		STAFF_MAIN_FXML = staff_root + fxml.attributeValue(FXML_PATH);
		STAFF_MAIN_CSS = staff_root + css.attributeValue(CSS_PATH);
		
		//MAINTAIN
		fxml = maintain_hotel.element("fxml");
		css = maintain_hotel.element("css");
		MAINTAIN_HOTEL_FXML = staff_root + fxml.attributeValue(FXML_PATH);
		MAINTAIN_HOTEL_CSS = staff_root + css.attributeValue(CSS_PATH);
		
		//Room Manage
		fxml = room_manage.element("fxml");
		css = room_manage.element("css");
		ROOM_MANAGE_FXML = staff_root + fxml.attributeValue(FXML_PATH);
		ROOM_MANAGE_CSS = staff_root + fxml.attributeValue(CSS_PATH);
		
		//Hotel Promotion
		fxml = hotel_promotion.element("fxml");
		css = hotel_promotion.element("css");
		HOTEL_PROMOTION_FXML = staff_root + fxml.attributeValue(FXML_PATH);
		HOTEL_PROMOTION_CSS = staff_root + css.attributeValue(CSS_PATH);
	}
	
	public static URL login_fxml_url() {
		try {
			return new URL(path_combine(LOGIN_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL login_css_url() {
		try {
			return new URL(path_combine(LOGIN_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL signin_fxml_url() {
		try {
			return new URL(path_combine(SIGNIN_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL signin_css_url() {
		try {
			return new URL(path_combine(SIGNIN_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_main_fxml_url() {
		try {
			return new URL(path_combine(STAFF_MAIN_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_main_css_url() {
		try {
			return new URL(path_combine(STAFF_MAIN_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_maintain_hotel_fxml_url() {
		try {
			return new URL(path_combine(MAINTAIN_HOTEL_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_maintain_hotel_css_url() {
		try {
			return new URL(path_combine(MAINTAIN_HOTEL_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_order_manage_fxml_url() {
		try {
			return new URL(path_combine(HOTEL_ORDER_MANAGE_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_order_manage_css_url() {
		try {
			return new URL(path_combine(HOTEL_ORDER_MANAGE_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_room_manage_fxml_url() {
		try {
			return new URL(path_combine(ROOM_MANAGE_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_room_manage_css_url() {
		try {
			return new URL(path_combine(ROOM_MANAGE_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_hotel_promotion_fxml_url() {
		try {
			return new URL(path_combine(HOTEL_PROMOTION_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_hotel_promotion_css_url() {
		try {
			return new URL(path_combine(HOTEL_PROMOTION_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	private static String path_combine(String path) {
		return FILE_ROOT_PATH + path;
	}
	
}
