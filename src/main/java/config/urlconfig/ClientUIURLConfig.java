package config.urlconfig;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ClientUIURLConfig {

	private final static String UI_CFG_PATH = "src/main/resources/config/url_config.xml";
	
	private final static String FXML_PATH = "fxml_path";
	
	private final static String CSS_PATH = "css_path";
	
	private final static String ROOT_PATH = "root_path";
	
	private static String FILE_ROOT_PATH;
	
	//Client : browse order
	
	private static String BROWSE_ORDER_FXML;
	
	private static String BROWSE_ORDER_CSS;
	
	//Client : change
	
	private static String CHANGE_FXML;
	
	private static String CHANGE_CSS;
	
	//Client : check
	
	private static String CHECK_FXML;
	
	private static String CHECK_CSS;

	//Client : client menu
	
	private static String CLIENT_MENU_FXML;
	
	private static String CLIENT_MENU_CSS;
	
	//Client : create order confirm
	
	private static String CREATE_ORDER_CONFIRM_FXML;
	
	private static String CREATE_ORDER_CONFIRM_CSS;
	
	//Client : credit
	
	private static String CREDIT_FXML;
	
	private static String CREDIT_CSS;
	
	//Client : evaluate hotel
	
	private static String EVALUATE_HOTEL_FXML;
	
	private static String EVALUATE_HOTEL_CSS;
	
	//Client : executed check
	
	private static String EXECUTED_CHECK_FXML;
	
	private static String EXECUTED_CHECK_CSS;
	
	//Client : history
	
	private static String HISTORY_FXML;
	
	private static String HISTORY_CSS;
	
	//Client : maintain message
	
	private static String MAINTAIN_MESSAGE_FXML;
	
	private static String MAINTAIN_MESSAGE_CSS;
	
	//Client : member
	
	private static String MEMBER_FXML;
	
	private static String MEMBER_CSS;
	
	//Client : revoke order
	
	private static String REVOKE_ORDER_FXML;
	
	private static String REVOKE_ORDER_CSS;
	
	//Client : search hotel
	
	private static String SEARCH_HOTEL_FXML;
	
	private static String SEARCH_HOTEL_CSS;
	
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
			Element client = root.element("client");
			
			client_init(client);
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	private static void client_init(Element client){
		String client_root = client.attributeValue("root_path");
		
		Element browse_order = client.element("browse_order");
		Element change = client.element("change");
		Element check = client.element("check");
		Element client_menu = client.element("client_menu");
		Element create_order_confirm = client.element("create_order_confirm");
		Element credit = client.element("credit");
		Element evaluate_hotel = client.element("evaluate_hotel");
		Element executed_check = client.element("executed_check");
		Element history = client.element("history");
		Element maintain_message = client.element("maintain_message");
		Element member = client.element("member");
		Element revoke_order = client.element("revoke_order");
		Element search_hotel = client.element("search_hotel");
		
		Element fxml;
		Element css;
		
		//browse order
		fxml = browse_order.element("fxml");
		css = browse_order.element("css");
		BROWSE_ORDER_FXML = client_root + fxml.attributeValue(FXML_PATH);
		BROWSE_ORDER_CSS = client_root + css.attributeValue(CSS_PATH);
		
		//change
		fxml = change.element("fxml");
		css = change.element("css");
		CHANGE_FXML = client_root + fxml.attributeValue(FXML_PATH);
		CHANGE_CSS = client_root + css.attributeValue(CSS_PATH);
		
		//check
		fxml = check.element("fxml");
		css = check.element("css");
		CHECK_FXML = client_root + fxml.attributeValue(FXML_PATH);
		CHECK_CSS = client_root + css.attributeValue(CSS_PATH);
		
		//client menu
		fxml = client_menu.element("fxml");
		css = client_menu.element("css");
		CLIENT_MENU_FXML = client_root + fxml.attributeValue(FXML_PATH);
		CLIENT_MENU_CSS = client_root + css.attributeValue(CSS_PATH);
		
		//create order confirm
		fxml = create_order_confirm.element("fxml");
		css = create_order_confirm.element("css");
		CREATE_ORDER_CONFIRM_FXML = client_root + fxml.attributeValue(FXML_PATH);
		CREATE_ORDER_CONFIRM_CSS = client_root + css.attributeValue(CSS_PATH);
		
		//credit
		fxml = credit.element("fxml");
		css = credit.element("css");
		CREDIT_FXML = client_root + fxml.attributeValue(FXML_PATH);
		CREDIT_CSS = client_root + css.attributeValue(CSS_PATH);
		
		//evaluate hotel
		fxml = evaluate_hotel.element("fxml");
		css = evaluate_hotel.element("css");
		EVALUATE_HOTEL_FXML = client_root + fxml.attributeValue(FXML_PATH);
		EVALUATE_HOTEL_CSS = client_root + css.attributeValue(CSS_PATH);
		
		//executed check
		fxml = executed_check.element("fxml");
		css = executed_check.element("css");
		EXECUTED_CHECK_FXML = client_root + fxml.attributeValue(FXML_PATH);
		EXECUTED_CHECK_CSS = client_root + css.attributeValue(CSS_PATH);
		
		//history
		fxml = history.element("fxml");
		css = history.element("css");
		HISTORY_FXML = client_root + fxml.attributeValue(FXML_PATH);
		HISTORY_CSS = client_root + css.attributeValue(CSS_PATH);
		
		//maintain message
		fxml = maintain_message.element("fxml");
		css = maintain_message.element("css");
		MAINTAIN_MESSAGE_FXML = client_root + fxml.attributeValue(FXML_PATH);
		MAINTAIN_MESSAGE_CSS = client_root + css.attributeValue(CSS_PATH);
		
		//member
		fxml = member.element("fxml");
		css = member.element("css");
		MEMBER_FXML = client_root + fxml.attributeValue(FXML_PATH);
		MEMBER_CSS = client_root + css.attributeValue(CSS_PATH);
		
		//revoke order
		fxml = revoke_order.element("fxml");
		css = revoke_order.element("css");
		REVOKE_ORDER_FXML = client_root + fxml.attributeValue(FXML_PATH);
		REVOKE_ORDER_CSS = client_root + css.attributeValue(CSS_PATH);
		
		//search hotel
		fxml = search_hotel.element("fxml");
		css = search_hotel.element("css");
		SEARCH_HOTEL_FXML = client_root + fxml.attributeValue(FXML_PATH);
		SEARCH_HOTEL_CSS = client_root + css.attributeValue(CSS_PATH);
		
	}
	
	public static URL client_browse_order_fxml_url(){
		try {
			return new URL(path_combine(BROWSE_ORDER_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL client_browse_order_css_url(){
		try {
			return new URL(path_combine(BROWSE_ORDER_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL client_change_fxml_url(){
		try {
			return new URL(path_combine(CHANGE_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL client_change_css_url(){
		try {
			return new URL(path_combine(CHANGE_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL client_check_fxml_url(){
		try {
			return new URL(path_combine(CHECK_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL client_check_css_url(){
		try {
			return new URL(path_combine(CHECK_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL client_menu_fxml_url(){
		try {
			return new URL(path_combine(CLIENT_MENU_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL client_menu_css_url(){
		try {
			return new URL(path_combine(CLIENT_MENU_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL client_create_order_confirm_fxml_url(){
		try {
			return new URL(path_combine(CREATE_ORDER_CONFIRM_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL client_create_order_confirm_css_url(){
		try {
			return new URL(path_combine(CREATE_ORDER_CONFIRM_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL client_credit_fxml_url(){
		try {
			return new URL(path_combine(CREDIT_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL client_credit_css_url(){
		try {
			return new URL(path_combine(CREDIT_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL client_evaluate_hotel_fxml_url(){
		try {
			return new URL(path_combine(EVALUATE_HOTEL_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL client_evaluate_hotel_css_url(){
		try {
			return new URL(path_combine(EVALUATE_HOTEL_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL client_executed_check_fxml_url(){
		try {
			return new URL(path_combine(EXECUTED_CHECK_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL client_executed_check_css_url(){
		try {
			return new URL(path_combine(EXECUTED_CHECK_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL client_history_fxml_url(){
		try {
			return new URL(path_combine(HISTORY_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL client_history_css_url(){
		try {
			return new URL(path_combine(HISTORY_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL client_maintain_message_fxml_url(){
		try {
			return new URL(path_combine(MAINTAIN_MESSAGE_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL client_maintain_message_css_url(){
		try {
			return new URL(path_combine(MAINTAIN_MESSAGE_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL client_member_fxml_url(){
		try {
			return new URL(path_combine(MEMBER_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL client_member_css_url(){
		try {
			return new URL(path_combine(MEMBER_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL client_revoke_order_fxml_url(){
		try {
			return new URL(path_combine(REVOKE_ORDER_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL client_revoke_order_css_url(){
		try {
			return new URL(path_combine(REVOKE_ORDER_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL client_search_hotel_fxml_url(){
		try {
			return new URL(path_combine(SEARCH_HOTEL_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL client_search_hotel_css_url(){
		try {
			return new URL(path_combine(SEARCH_HOTEL_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String path_combine(String path) {
		return FILE_ROOT_PATH + path;
	}
	
}
