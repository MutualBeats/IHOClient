package config.urlconfig;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class StaffUIURLConfig {
	
	private final static String UI_CFG_PATH = "src/main/resources/config/url_config.xml";
	
	private final static String FXML_PATH = "fxml_path";
	
	private final static String CSS_PATH = "css_path";
	
	private final static String ROOT_PATH = "root_path";
	
	private static String FILE_ROOT_PATH;
	
	//Staff : Enterprise input
	
	private static String ENTERPRISE_INPUT_FXML;
	
	private static String ENTERPRISE_INPUT_CSS;
	
	//Staff : Hotel maintain confirm
	
	private static String HOTEL_MAINTAIN_CONFIRM_FXML;
	
	private static String HOTEL_MAINTAIN_CONFIRM_CSS;
	
	//Staff : Hotel promotion change
	
	private static String HOTEL_PROMOTION_CHANGE_FXML;
		
	private static String HOTEL_PROMOTION_CHANGE_CSS;
		
	//Staff : Hotel promotion check
		
	private static String HOTEL_PROMOTION_CHECK_FXML;
		
	private static String HOTEL_PROMOTION_CHECK_CSS;
		
	//Staff : Hotel promotion create
		
	private static String HOTEL_PROMOTION_CREATE_FXML;
		
	private static String HOTEL_PROMOTION_CREATE_CSS;
		
	//Staff : Hotel promotion
		
	private static String HOTEL_PROMOTION_FXML;
		
	private static String HOTEL_PROMOTION_CSS;
		
	//Staff : Maintain Hotel
		
	private static String MAINTAIN_HOTEL_FXML;
		
	private static String MAINTAIN_HOTEL_CSS;
		
	//Staff : Order check
		
	private static String ORDER_CHECK_FXML;
		
	private static String ORDER_CHECK_CSS;
		
	//Staff : Order manage
	
	private static String ORDER_MANAGE_FXML;
		
	private static String ORDER_MANAGE_CSS;
		
	//Staff : Room check
		
	private static String ROOM_CHECK_FXML;
		
	private static String ROOM_CHECK_CSS;
		
	//Staff : Room create
	
	private static String ROOM_CREATE_FXML;
		
	private static String ROOM_CREATE_CSS;
		
	//Staff : Room manage
		
	private static String ROOM_MANAGE_FXML;
		
	private static String ROOM_MANAGE_CSS;
		
	//Staff : Room update
		
	private static String ROOM_UPDATE_FXML;
		
	private static String ROOM_UPDATE_CSS;
	
	//Staff : room create confirm
	
	private static String ROOM_CREATE_CONFIRM_FXML;
	
	private static String ROOM_CREATE_CONFIRM_CSS;
	
	//Staff : room update confirm
	
	private static String ROOM_UPDATE_CONFIRM_FXML;
	
	private static String ROOM_UPDATE_CONFIRM_CSS;

	//Staff main
		
	private static String STAFF_MAIN_FXML;
		
	private static String STAFF_MAIN_CSS;
	
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
			Element staff = root.element("staff");
			
			staff_init(staff);
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	private static void staff_init(Element staff) {
		String staff_root = staff.attributeValue("root_path");
		
		Element enterprise_input = staff.element("enterprise_input");
		Element hotel_maintain_confirm = staff.element("hotel_maintain_confirm");
		Element hotel_promotion_change = staff.element("hotel_promotion_change");
		Element hotel_promotion_check = staff.element("hotel_promotion_check");
		Element hotel_promotion_create = staff.element("hotel_promotion_create");
		Element hotel_promotion = staff.element("hotel_promotion");
		Element maintain_hotel = staff.element("maintain_hotel");
		Element order_check = staff.element("order_check");
		Element order_manage = staff.element("order_manage");
		Element room_check = staff.element("room_check");
		Element room_create = staff.element("room_create");
		Element room_manage = staff.element("room_manage");
		Element room_update = staff.element("room_update");
		Element room_create_confirm = staff.element("room_create_confirm");
		Element room_update_confirm = staff.element("room_update_confirm");
		Element staff_main = staff.element("staff_main");
		
		Element fxml;
		Element css;
		
		//Enterprise input
		fxml = enterprise_input.element("fxml");
		css = enterprise_input.element("css");
		ENTERPRISE_INPUT_FXML = staff_root + fxml.attributeValue(FXML_PATH);
		ENTERPRISE_INPUT_CSS = staff_root + css.attributeValue(CSS_PATH);
		
		//Hotel maintain confirm
		fxml = hotel_maintain_confirm.element("fxml");
		css = hotel_maintain_confirm.element("css");
		HOTEL_MAINTAIN_CONFIRM_FXML = staff_root + fxml.attributeValue(FXML_PATH);
		HOTEL_MAINTAIN_CONFIRM_CSS = staff_root + css.attributeValue(CSS_PATH);
		
		//Hotel Promotion Change
		fxml = hotel_promotion_change.element("fxml");
		css = hotel_promotion_change.element("css");
		HOTEL_PROMOTION_CHANGE_FXML = staff_root + fxml.attributeValue(FXML_PATH);
		HOTEL_PROMOTION_CHANGE_CSS = staff_root + css.attributeValue(CSS_PATH);
		
		//Hotel Promotion Check
		fxml = hotel_promotion_check.element("fxml");
		css = hotel_promotion_check.element("css");
		HOTEL_PROMOTION_CHECK_FXML = staff_root + fxml.attributeValue(FXML_PATH);
		HOTEL_PROMOTION_CHECK_CSS = staff_root + css.attributeValue(CSS_PATH);
		
		//Hotel Promotion Create
		fxml = hotel_promotion_create.element("fxml");
		css = hotel_promotion_create.element("css");
		HOTEL_PROMOTION_CREATE_FXML = staff_root + fxml.attributeValue(FXML_PATH);
		HOTEL_PROMOTION_CREATE_CSS = staff_root + css.attributeValue(CSS_PATH);
		
		//Hotel Promotion
		fxml = hotel_promotion.element("fxml");
		css = hotel_promotion.element("css");
		HOTEL_PROMOTION_FXML = staff_root + fxml.attributeValue(FXML_PATH);
		HOTEL_PROMOTION_CSS = staff_root + css.attributeValue(CSS_PATH);
		
		//Maintain hotel
		fxml = maintain_hotel.element("fxml");
		css = maintain_hotel.element("css");
		MAINTAIN_HOTEL_FXML = staff_root + fxml.attributeValue(FXML_PATH);
		MAINTAIN_HOTEL_CSS = staff_root + css.attributeValue(CSS_PATH);
		
		//Order Check
		fxml = order_check.element("fxml");
		css = order_check.element("css");
		ORDER_CHECK_FXML = staff_root + fxml.attributeValue(FXML_PATH);
		ORDER_CHECK_CSS = staff_root + css.attributeValue(CSS_PATH);

		//Order Manager
		fxml = order_manage.element("fxml");
		css = order_manage.element("css");
		ORDER_MANAGE_FXML = staff_root + fxml.attributeValue(FXML_PATH);
		ORDER_MANAGE_CSS = staff_root + css.attributeValue(CSS_PATH);
		
		//Room Check
		fxml = room_check.element("fxml");
		css = room_check.element("css");
		ROOM_CHECK_FXML = staff_root + fxml.attributeValue(FXML_PATH);
		ROOM_CHECK_CSS = staff_root + css.attributeValue(CSS_PATH);
		
		//Room Create
		fxml = room_create.element("fxml");
		css = room_create.element("css");
		ROOM_CREATE_FXML = staff_root + fxml.attributeValue(FXML_PATH);
		ROOM_CREATE_CSS = staff_root + css.attributeValue(CSS_PATH);

		//Room Manage
		fxml = room_manage.element("fxml");
		css = room_manage.element("css");
		ROOM_MANAGE_FXML = staff_root + fxml.attributeValue(FXML_PATH);
		ROOM_MANAGE_CSS = staff_root + css.attributeValue(CSS_PATH);

		//Room Update
		fxml = room_update.element("fxml");
		css = room_update.element("css");
		ROOM_UPDATE_FXML = staff_root + fxml.attributeValue(FXML_PATH);
		ROOM_UPDATE_CSS = staff_root + css.attributeValue(CSS_PATH);
		
		//Room Create confirm
		fxml = room_create_confirm.element("fxml");
		css = room_create_confirm.element("css");
		ROOM_CREATE_CONFIRM_FXML = staff_root + fxml.attributeValue(FXML_PATH);
		ROOM_CREATE_CONFIRM_CSS = staff_root + css.attributeValue(CSS_PATH);
		
		//Room Update confirm
		fxml = room_update_confirm.element("fxml");
		css = room_update_confirm.element("css");
		ROOM_UPDATE_CONFIRM_FXML = staff_root + fxml.attributeValue(FXML_PATH);
		ROOM_UPDATE_CONFIRM_CSS = staff_root + css.attributeValue(CSS_PATH);
		
		//Main
		fxml = staff_main.element("fxml");
		css = staff_main.element("css");
		STAFF_MAIN_FXML = staff_root + fxml.attributeValue(FXML_PATH);
		STAFF_MAIN_CSS = staff_root + css.attributeValue(CSS_PATH);

	}
	
	public static URL staff_enterprise_input_fxml_url(){
		try {
			return new URL(path_combine(ENTERPRISE_INPUT_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_enterprise_input_css_url(){
		try {
			return new URL(path_combine(ENTERPRISE_INPUT_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_hotel_maintain_confirm_fxml_url(){
		try {
			return new URL(path_combine(HOTEL_MAINTAIN_CONFIRM_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_hotel_maintain_confirm_css_url(){
		try {
			return new URL(path_combine(HOTEL_MAINTAIN_CONFIRM_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_hotel_promotion_change_fxml_url(){
		try {
			return new URL(path_combine(HOTEL_PROMOTION_CHANGE_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_hotel_promotion_change_css_url(){
		try {
			return new URL(path_combine(HOTEL_PROMOTION_CHANGE_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_hotel_promotion_check_fxml_url(){
		try {
			return new URL(path_combine(HOTEL_PROMOTION_CHECK_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_hotel_promotion_check_css_url(){
		try {
			return new URL(path_combine(HOTEL_PROMOTION_CHECK_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_hotel_promotion_create_fxml_url(){
		try {
			return new URL(path_combine(HOTEL_PROMOTION_CREATE_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_hotel_promotion_create_css_url(){
		try {
			return new URL(path_combine(HOTEL_PROMOTION_CREATE_CSS));
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
	
	public static URL staff_order_check_fxml_url() {
		try {
			return new URL(path_combine(ORDER_CHECK_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_order_check_css_url() {
		try {
			return new URL(path_combine(ORDER_CHECK_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_order_manage_fxml_url() {
		try {
			return new URL(path_combine(ORDER_MANAGE_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_order_manage_css_url() {
		try {
			return new URL(path_combine(ORDER_MANAGE_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_room_check_fxml_url() {
		try {
			return new URL(path_combine(ROOM_CHECK_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_room_check_css_url() {
		try {
			return new URL(path_combine(ROOM_CHECK_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_room_create_fxml_url() {
		try {
			return new URL(path_combine(ROOM_CREATE_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_room_create_css_url() {
		try {
			return new URL(path_combine(ROOM_CREATE_CSS));
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

	public static URL staff_room_update_fxml_url() {
		try {
			return new URL(path_combine(ROOM_UPDATE_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_room_update_css_url() {
		try {
			return new URL(path_combine(ROOM_UPDATE_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_room_create_confirm_fxml_url() {
		try {
			return new URL(path_combine(ROOM_CREATE_CONFIRM_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_room_create_confirm_css_url() {
		try {
			return new URL(path_combine(ROOM_CREATE_CONFIRM_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_room_update_confirm_fxml_url() {
		try {
			return new URL(path_combine(ROOM_UPDATE_CONFIRM_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL staff_room_update_confirm_css_url() {
		try {
			return new URL(path_combine(ROOM_UPDATE_CONFIRM_CSS));
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
	
	private static String path_combine(String path) {
		return FILE_ROOT_PATH + path;
	}
	
}
