package config.urlconfig;

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

	//Staff main
	
	private static String STAFF_MAIN_FXML;
	
	private static String STAFF_MAIN_CSS;
	
	//Market : Credit Execute
	
	private static String CREDIT_EXCUTE_FXML;
	
	private static String CREDIT_EXCUTE_CSS;
	
	//Market : Credit
	
	private static String CREDIT_FXML;
	
	private static String CREDIT_CSS;
	
	//Market : Market menu
	
	private static String MARKET_MENU_FXML;
	
	private static String MARKET_MENU_CSS;
	
	//Market : Unusual order
	
	private static String UNUSUAL_ORDER_FXML;
	
	private static String UNUSUAL_ORDER_CSS;
	
	//Market : web promotion create
	
	private static String WEB_PROMOTION_CREATE_FXML;
	
	private static String WEB_PROMOTION_CREATE_CSS;
	
	//Market : web promotion update
	
	private static String WEB_PROMOTION_UPDATE_FXML;
	
	private static String WEB_PROMOTION_UPDATE_CSS;
	
	//Market : web promotion
	
	private static String WEB_PROMOTION_FXML;
	
	private static String WEB_PROMOTION_CSS;
	
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
	
	private static String INFO_LOOK_CLIENT_FXML;
	
	private static String INFO_LOOK_CLIENT_CSS;
	
	//Manage : information look marketer
	
	private static String INFO_LOOK_MARKETER_FXML;
	
	private static String INFO_LOOK_MARKETER_CSS;
	
	//Manage : information look staff
	
	private static String INFO_LOOK_STAFF_FXML;
	
	private static String INFO_LOOK_STAFF_CSS;
	
	//Manage menu
	
	private static String MANAGE_MENU_FXML;
	
	private static String MANAGE_MENU_CSS;
	
	//confirm
	
	private static String CONFIRM_FXML;
	
	private static String CONFIRM_CSS;
	
	//error
	
	private static String ERROR_FXML;
	
	private static String ERROR_CSS;
	
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
			Element market = root.element("market");
			Element manage = root.element("manage");
			Element confirm = root.element("confirm");
			Element error = root.element("error");
			
			login_init(login);
			signin_init(signin);
			staff_init(staff);
			market_init(market);
			manage_init(manage);
			confirm_init(confirm);
			error_init(error);
			
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
		Element staff_main = staff.element("staff_main");
		
		Element fxml;
		Element css;
		
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
		ROOM_MANAGE_CSS = staff_root + fxml.attributeValue(CSS_PATH);

		//Room Update
		fxml = room_update.element("fxml");
		css = room_update.element("css");
		ROOM_UPDATE_FXML = staff_root + fxml.attributeValue(FXML_PATH);
		ROOM_UPDATE_CSS = staff_root + css.attributeValue(CSS_PATH);
		
		//Main
		fxml = staff_main.element("fxml");
		css = staff_main.element("css");
		STAFF_MAIN_FXML = staff_root + fxml.attributeValue(FXML_PATH);
		STAFF_MAIN_CSS = staff_root + css.attributeValue(CSS_PATH);

	}
	
	private static void market_init(Element market){
		String market_root = market.attributeValue("market_root");
		
		Element credit_excute = market.element("credit_excute");
		Element credit = market.element("credit");
		Element market_menu = market.element("market_menu");
		Element unusual_order = market.element("unusual_order");
		Element web_promotion_create = market.element("web_promotion_create");
		Element web_promotion_update = market.element("web_promotion_update");
		Element web_promotion = market.element("web_promotion");
		
		Element fxml;
		Element css;
		
		//Credit Execute
		fxml = credit_excute.element("fxml");
		css = credit_excute.element("css");
		CREDIT_EXCUTE_FXML = market_root + fxml.attributeValue(FXML_PATH);
		CREDIT_EXCUTE_CSS = market_root + css.attributeValue(CSS_PATH);
		
		//Credit
		fxml = credit.element("fxml");
		css = credit.element("css");
		CREDIT_FXML = market_root + fxml.attributeValue(FXML_PATH);
		CREDIT_CSS = market_root + css.attributeValue(CSS_PATH);
		
		//market menu
		fxml = market_menu.element("fxml");
		css = market_menu.element("css");
		MARKET_MENU_FXML = market_root + fxml.attributeValue(FXML_PATH);
		MARKET_MENU_CSS = market_root + css.attributeValue(CSS_PATH);
		
		//unusual order
		fxml = unusual_order.element("fxml");
		css = unusual_order.element("css");
		UNUSUAL_ORDER_FXML = market_root + fxml.attributeValue(FXML_PATH);
		UNUSUAL_ORDER_CSS = market_root + css.attributeValue(CSS_PATH);
		
		//web promotion create
		fxml = web_promotion_create.element("fxml");
		css = web_promotion_create.element("css");
		WEB_PROMOTION_CREATE_FXML = market_root + fxml.attributeValue(FXML_PATH);
		WEB_PROMOTION_CREATE_CSS = market_root + css.attributeValue(CSS_PATH);
		
		//web promotion update
		fxml = web_promotion_update.element("fxml");
		css = web_promotion_update.element("css");
		WEB_PROMOTION_UPDATE_FXML = market_root + fxml.attributeValue(FXML_PATH);
		WEB_PROMOTION_UPDATE_CSS = market_root + css.attributeValue(CSS_PATH);
		
		//web promotion
		fxml = web_promotion.element("fxml");
		css = web_promotion.element("css");
		WEB_PROMOTION_FXML = market_root + fxml.attributeValue(FXML_PATH);
		WEB_PROMOTION_CSS = market_root + css.attributeValue(CSS_PATH);
		
	}
	
	private static void manage_init(Element manage){
		String manage_root = manage.attributeValue("manage_root");
		
		Element add_hotel_one = manage.element("add_hotel_one");
		Element add_hotel_three = manage.element("add_hotel_three");
		Element add_hotel_two = manage.element("add_hotel_two");
		Element add_people = manage.element("add_people");
		Element change_message = manage.element("change_message");
		Element check_menu = manage.element("check_menu");
		Element ID_input = manage.element("ID_input");
		Element info_look_client = manage.element("info_look_client");
		Element info_look_marketer = manage.element("info_look_marketer");
		Element info_look_staff = manage.element("info_look_staff");
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
		CHECK_MENU_FXML = manage_root + css.attributeValue(CSS_PATH);
		
		//ID input
		fxml = ID_input.element("fxml");
		css = ID_input.element("css");
		ID_INPUT_FXML = manage_root + fxml.attributeValue(FXML_PATH);
		ID_INPUT_CSS = manage_root + css.attributeValue(CSS_PATH);
		
		//info look client
		fxml = info_look_client.element("fxml");
		css = info_look_client.element("css");
		INFO_LOOK_CLIENT_FXML = manage_root + fxml.attributeValue(FXML_PATH);
		INFO_LOOK_CLIENT_CSS = manage_root + css.attributeValue(CSS_PATH);
		
		//info look marketer
		fxml = info_look_marketer.element("fxml");
		css = info_look_marketer.element("css");
		INFO_LOOK_MARKETER_FXML = manage_root + fxml.attributeValue(FXML_PATH);
		INFO_LOOK_MARKETER_CSS = manage_root + css.attributeValue(CSS_PATH);
		
		//info look staff
		fxml = info_look_staff.element("fxml");
		css = info_look_staff.element("css");
		INFO_LOOK_STAFF_FXML = manage_root + fxml.attributeValue(FXML_PATH);
		INFO_LOOK_STAFF_CSS = manage_root + css.attributeValue(CSS_PATH);
		
		//manage menu
		fxml = manage_menu.element("fxml");
		css = manage_menu.element("css");
		MANAGE_MENU_FXML = manage_root + fxml.attributeValue(FXML_PATH);
		MANAGE_MENU_CSS = manage_root + css.attributeValue(CSS_PATH);
		
	}
	
	private static void confirm_init(Element confirm){
		Element confirm_fxml = confirm.element("fxml");
		Element confirm_css = confirm.element("css");
		String confirm_root = confirm.attributeValue(ROOT_PATH);
		CONFIRM_FXML = confirm_root + confirm_fxml.attributeValue(FXML_PATH);
		CONFIRM_CSS = confirm_root + confirm_css.attributeValue(CSS_PATH);
	}
	
	private static void error_init(Element error){
		Element error_fxml = error.element("fxml");
		Element error_css = error.element("css");
		String error_root = error.attributeValue(ROOT_PATH);
		ERROR_FXML = error_root + error_fxml.attributeValue(FXML_PATH);
		ERROR_CSS = error_root + error_css.attributeValue(CSS_PATH);
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
	
	public static URL market_credit_excute_fxml_url(){
		try {
			return new URL(path_combine(CREDIT_EXCUTE_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL market_credit_excute_css_url(){
		try {
			return new URL(path_combine(CREDIT_EXCUTE_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL market_credit_fxml_url(){
		try {
			return new URL(path_combine(CREDIT_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL market_credit_css_url(){
		try {
			return new URL(path_combine(CREDIT_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL market_market_menu_fxml_url(){
		try {
			return new URL(path_combine(MARKET_MENU_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL market_market_menu_css_url(){
		try {
			return new URL(path_combine(MARKET_MENU_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL market_unusual_order_fxml_url(){
		try {
			return new URL(path_combine(UNUSUAL_ORDER_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL market_unusual_order_css_url(){
		try {
			return new URL(path_combine(UNUSUAL_ORDER_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL market_web_promotion_create_fxml_url(){
		try {
			return new URL(path_combine(WEB_PROMOTION_CREATE_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL market_web_promotion_create_css_url(){
		try {
			return new URL(path_combine(WEB_PROMOTION_CREATE_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL market_web_promotion_update_fxml_url(){
		try {
			return new URL(path_combine(WEB_PROMOTION_UPDATE_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL market_web_promotion_update_css_url(){
		try {
			return new URL(path_combine(WEB_PROMOTION_UPDATE_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL market_web_promotion_fxml_url(){
		try {
			return new URL(path_combine(WEB_PROMOTION_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL market_web_promotion_css_url(){
		try {
			return new URL(path_combine(WEB_PROMOTION_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
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
	
	public static URL manage_info_look_client_fxml(){
		try {
			return new URL(path_combine(INFO_LOOK_CLIENT_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL manage_info_look_client_css(){
		try {
			return new URL(path_combine(INFO_LOOK_CLIENT_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL manage_info_look_marketer_fxml(){
		try {
			return new URL(path_combine(INFO_LOOK_MARKETER_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL manage_info_look_marketer_css(){
		try {
			return new URL(path_combine(INFO_LOOK_MARKETER_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL manage_info_look_staff_fxml(){
		try {
			return new URL(path_combine(INFO_LOOK_STAFF_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL manage_info_look_staff_css(){
		try {
			return new URL(path_combine(INFO_LOOK_STAFF_CSS));
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
	
	public static URL confirm_fxml_url() {
		try {
			return new URL(path_combine(CONFIRM_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL confirm_css_url() {
		try {
			return new URL(path_combine(CONFIRM_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL error_fxml_url() {
		try {
			return new URL(path_combine(ERROR_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL error_css_url() {
		try {
			return new URL(path_combine(ERROR_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String path_combine(String path) {
		return FILE_ROOT_PATH + path;
	}
	
}
