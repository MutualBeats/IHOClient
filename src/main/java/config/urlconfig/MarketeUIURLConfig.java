package config.urlconfig;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class MarketeUIURLConfig {

	private final static String UI_CFG_PATH = "src/main/resources/config/url_config.xml";
	
	private final static String FXML_PATH = "fxml_path";
	
	private final static String CSS_PATH = "css_path";
	
	private final static String ROOT_PATH = "root_path";
	
	private static String FILE_ROOT_PATH;
	
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
			Element market = root.element("market");

			market_init(market);
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
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
	
	private static String path_combine(String path) {
		return FILE_ROOT_PATH + path;
	}
	
	
}