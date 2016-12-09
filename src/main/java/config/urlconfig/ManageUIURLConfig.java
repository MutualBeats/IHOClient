package config.urlconfig;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ManageUIURLConfig {
	
	private final static String UI_CFG_PATH = "src/main/resources/config/url_config.xml";
	
	private final static String FXML_PATH = "fxml_path";
	
	private final static String CSS_PATH = "css_path";
	
	private final static String ROOT_PATH = "root_path";
	
	private static String FILE_ROOT_PATH;
	
	//Manage : add hotel one
	
	private static String ADD_HOTEL_ONE_FXML;
		
	private static String ADD_HOTEL_ONE_CSS;
		
	//Manage : add hotel three
		
	private static String ADD_HOTEL_THREE_FXML;
		
	private static String ADD_HOTEL_THREE_CSS;
		
	//Manage : add hotel two
		
	private static String ADD_HOTEL_TWO_FXML;
		
	private static String ADD_HOTEL_TWO_CSS;
	
	//Manage : add people
		
	private static String ADD_PEOPLE_FXML;
		
	private static String ADD_PEOPLE_CSS;
		
	//Manage : change message
		
	private static String CHANGE_MESSAGE_FXML;
		
	private static String CHANGE_MESSAGE_CSS;
		
	//Manage : check menu
		
	private static String CHECK_MENU_FXML;
		
	private static String CHECK_MENU_CSS;
		
	//Manage : ID input
		
	private static String ID_INPUT_FXML;
		
	private static String ID_INPUT_CSS;
		
	//Manage : information look client
		
	private static String INFO_LOOK_FXML;
		
	private static String INFO_LOOK_CSS;
		
	//Manage menu
		
	private static String MANAGE_MENU_FXML;
		
	private static String MANAGE_MENU_CSS;
	
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
			Element manage = root.element("manage");

			manage_init(manage);
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	private static void manage_init(Element manage){
		String manage_root = manage.attributeValue(ROOT_PATH);
		
		Element add_hotel_one = manage.element("add_hotel_one");
		Element add_hotel_three = manage.element("add_hotel_three");
		Element add_hotel_two = manage.element("add_hotel_two");
		Element add_people = manage.element("add_people");
		Element change_message = manage.element("change_message");
		Element check_menu = manage.element("check_menu");
		Element ID_input = manage.element("ID_input");
		Element info_look = manage.element("info_look");
		Element manage_menu = manage.element("manage_menu");
		
		Element fxml;
		Element css;
		
		//add hotel one
		fxml = add_hotel_one.element("fxml");
		css = add_hotel_one.element("css");
		ADD_HOTEL_ONE_FXML = manage_root + fxml.attributeValue(FXML_PATH);
		ADD_HOTEL_ONE_CSS = manage_root + css.attributeValue(CSS_PATH);
		
		//add hotel three
		fxml = add_hotel_three.element("fxml");
		css = add_hotel_three.element("css");
		ADD_HOTEL_THREE_FXML = manage_root + fxml.attributeValue(FXML_PATH);
		ADD_HOTEL_THREE_CSS = manage_root + css.attributeValue(CSS_PATH);
		
		//add hotel two
		fxml = add_hotel_two.element("fxml");
		css = add_hotel_two.element("css");
		ADD_HOTEL_TWO_FXML = manage_root + fxml.attributeValue(FXML_PATH);
		ADD_HOTEL_TWO_CSS = manage_root + css.attributeValue(CSS_PATH);
		
		//add people
		fxml = add_people.element("fxml");
		css = add_people.element("css");
		ADD_PEOPLE_FXML = manage_root + fxml.attributeValue(FXML_PATH);
		ADD_PEOPLE_CSS = manage_root + css.attributeValue(CSS_PATH);
		
		//change message
		fxml = change_message.element("fxml");
		css = change_message.element("css");
		CHANGE_MESSAGE_FXML = manage_root + fxml.attributeValue(FXML_PATH);
		CHANGE_MESSAGE_CSS = manage_root + css.attributeValue(CSS_PATH);
		
		//check menu
		fxml = check_menu.element("fxml");
		css = check_menu.element("css");
		CHECK_MENU_FXML = manage_root + fxml.attributeValue(FXML_PATH);
		CHECK_MENU_CSS = manage_root + css.attributeValue(CSS_PATH);
		
		//ID input
		fxml = ID_input.element("fxml");
		css = ID_input.element("css");
		ID_INPUT_FXML = manage_root + fxml.attributeValue(FXML_PATH);
		ID_INPUT_CSS = manage_root + css.attributeValue(CSS_PATH);
		
		//info look client
		fxml = info_look.element("fxml");
		css = info_look.element("css");
		INFO_LOOK_FXML = manage_root + fxml.attributeValue(FXML_PATH);
		INFO_LOOK_CSS = manage_root + css.attributeValue(CSS_PATH);
		
		//manage menu
		fxml = manage_menu.element("fxml");
		css = manage_menu.element("css");
		MANAGE_MENU_FXML = manage_root + fxml.attributeValue(FXML_PATH);
		MANAGE_MENU_CSS = manage_root + css.attributeValue(CSS_PATH);
		
	}
	
	public static URL manage_add_hotel_one_fxml(){
		try {
			return new URL(path_combine(ADD_HOTEL_ONE_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL manage_add_hotel_one_css(){
		try {
			return new URL(path_combine(ADD_HOTEL_ONE_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL manage_add_hotel_three_fxml(){
		try {
			return new URL(path_combine(ADD_HOTEL_THREE_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL manage_add_hotel_three_css(){
		try {
			return new URL(path_combine(ADD_HOTEL_THREE_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL manage_add_hotel_two_fxml(){
		try {
			return new URL(path_combine(ADD_HOTEL_TWO_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL manage_add_hotel_two_css(){
		try {
			return new URL(path_combine(ADD_HOTEL_TWO_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL manage_add_people_fxml(){
		try {
			return new URL(path_combine(ADD_PEOPLE_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL manage_add_people_css(){
		try {
			return new URL(path_combine(ADD_PEOPLE_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL manage_change_message_fxml(){
		try {
			return new URL(path_combine(CHANGE_MESSAGE_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL manage_change_message_css(){
		try {
			return new URL(path_combine(CHANGE_MESSAGE_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL manage_check_menu_fxml(){
		try {
			return new URL(path_combine(CHECK_MENU_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL manage_check_menu_css(){
		try {
			return new URL(path_combine(CHECK_MENU_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL manage_ID_input_fxml(){
		try {
			return new URL(path_combine(ID_INPUT_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL manage_ID_input_css(){
		try {
			return new URL(path_combine(ID_INPUT_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL manage_info_look_fxml(){
		try {
			return new URL(path_combine(INFO_LOOK_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL manage_info_look_css(){
		try {
			return new URL(path_combine(INFO_LOOK_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL manage_menu_fxml(){
		try {
			return new URL(path_combine(MANAGE_MENU_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL manage_menu_css(){
		try {
			return new URL(path_combine(MANAGE_MENU_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	private static String path_combine(String path) {
		return FILE_ROOT_PATH + path;
	}
	
}

