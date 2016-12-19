package config.urlconfig;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class MarketUIURLConfig {

	private final static String UI_CFG_PATH = "src/main/resources/config/url_config.xml";
	
	private final static String FXML_PATH = "fxml_path";
	
	private final static String CSS_PATH = "css_path";
	
	private final static String ROOT_PATH = "root_path";
	
	private static String FILE_ROOT_PATH;
	
	//Market : appeal credit
	
	private static String APPEAL_CREDIT_FXML;
	
	private static String APPEAL_CREDIT_CSS;
	
	//Market : Credit Execute
	
	private static String CREDIT_EXCUTE_FXML;
		
	private static String CREDIT_EXCUTE_CSS;
		
	//Market : field promotion 
	
	private static String FIELD_PROMOTION_FXML;
		
	private static String FIELD_PROMOTION_CSS;
		
	//Market : Market menu
	
	private static String MARKET_MENU_FXML;
	
	private static String MARKET_MENU_CSS;
	
	//Market : member level
	
	private static String MEMBER_LEVEL_FXML;
	
	private static String MEMBER_LEVEL_CSS;
	
	//Market : Promotion check
	
	private static String PROMOTION_CHECK_FXML;
	
	private static String PROMOTION_CHECK_CSS;
	
	//Market : time promotion
	
	private static String TIME_PROMOTION_FXML;
	
	private static String TIME_PROMOTION_CSS;
		
	//Market : not executed order
	
	private static String UNEXECUTED_ORDER_FXML;
	
	private static String UNEXECUTED_ORDER_CSS;
	
	//Market : Unusual order
		
	private static String UNUSUAL_ORDER_FXML;
		
	private static String UNUSUAL_ORDER_CSS;
		
	//Market : web promotion choose
		
	private static String WEB_PROMOTION_CHOOSE_FXML;
		
	private static String WEB_PROMOTION_CHOOSE_CSS;
		
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
		String market_root = market.attributeValue(ROOT_PATH);
		
		Element appeal_credit = market.element("appeal_credit");
		Element credit_excute = market.element("credit_excute");
		Element field_promotion = market.element("field_promotion");
		Element market_menu = market.element("market_menu");
		Element member_level = market.element("member_level");
		Element promotion_check = market.element("promotion_check");
		Element time_promotion = market.element("time_promotion");
		Element unexecuted_order = market.element("unexecuted_order");
		Element unusual_order = market.element("unusual_order");
		Element web_promotion_choose = market.element("web_promotion_choose");
		Element web_promotion = market.element("web_promotion");
		
		Element fxml;
		Element css;
		
		//appeal credit
		fxml = appeal_credit.element("fxml");
		css = appeal_credit.element("css");
		APPEAL_CREDIT_FXML = market_root + fxml.attributeValue(FXML_PATH);
		APPEAL_CREDIT_CSS = market_root + css.attributeValue(CSS_PATH);
		
		//Credit Execute
		fxml = credit_excute.element("fxml");
		css = credit_excute.element("css");
		CREDIT_EXCUTE_FXML = market_root + fxml.attributeValue(FXML_PATH);
		CREDIT_EXCUTE_CSS = market_root + css.attributeValue(CSS_PATH);
		
		//field promotion
		fxml = field_promotion.element("fxml");
		css = field_promotion.element("css");
		FIELD_PROMOTION_FXML = market_root + fxml.attributeValue(FXML_PATH);
		FIELD_PROMOTION_CSS = market_root + css.attributeValue(CSS_PATH);
		
		//market menu
		fxml = market_menu.element("fxml");
		css = market_menu.element("css");
		MARKET_MENU_FXML = market_root + fxml.attributeValue(FXML_PATH);
		MARKET_MENU_CSS = market_root + css.attributeValue(CSS_PATH);
		
		//member level
		fxml = member_level.element("fxml");
		css = member_level.element("css");
		MEMBER_LEVEL_FXML = market_root + fxml.attributeValue(FXML_PATH);
		MEMBER_LEVEL_CSS = market_root + css.attributeValue(CSS_PATH);
		
		//promotion check
		fxml = promotion_check.element("fxml");
		css = promotion_check.element("css");
		PROMOTION_CHECK_FXML = market_root + fxml.attributeValue(FXML_PATH);
		PROMOTION_CHECK_CSS = market_root + css.attributeValue(CSS_PATH);
		
		//time promotion
		fxml = time_promotion.element("fxml");
		css = time_promotion.element("css");
		TIME_PROMOTION_FXML = market_root + fxml.attributeValue(FXML_PATH);
		TIME_PROMOTION_CSS = market_root + css.attributeValue(CSS_PATH);
		
		//not executed order
		fxml = unexecuted_order.element("fxml");
		css = unexecuted_order.element("css");
		UNEXECUTED_ORDER_FXML = market_root + fxml.attributeValue(FXML_PATH);
		UNEXECUTED_ORDER_CSS = market_root + css.attributeValue(CSS_PATH);
		
		//unusual order
		fxml = unusual_order.element("fxml");
		css = unusual_order.element("css");
		UNUSUAL_ORDER_FXML = market_root + fxml.attributeValue(FXML_PATH);
		UNUSUAL_ORDER_CSS = market_root + css.attributeValue(CSS_PATH);
		
		//web promotion choose
		fxml = web_promotion_choose.element("fxml");
		css = web_promotion_choose.element("css");
		WEB_PROMOTION_CHOOSE_FXML = market_root + fxml.attributeValue(FXML_PATH);
		WEB_PROMOTION_CHOOSE_CSS = market_root + css.attributeValue(CSS_PATH);
		
		//web promotion
		fxml = web_promotion.element("fxml");
		css = web_promotion.element("css");
		WEB_PROMOTION_FXML = market_root + fxml.attributeValue(FXML_PATH);
		WEB_PROMOTION_CSS = market_root + css.attributeValue(CSS_PATH);
		
	}
	
	public static URL market_appeal_credit_fxml_url(){
		try {
			return new URL(path_combine(APPEAL_CREDIT_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL market_appeal_credit_css_url(){
		try {
			return new URL(path_combine(APPEAL_CREDIT_CSS));
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
	
	public static URL market_field_promotion_fxml_url(){
		try {
			return new URL(path_combine(FIELD_PROMOTION_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL market_field_promotion_css_url(){
		try {
			return new URL(path_combine(FIELD_PROMOTION_CSS));
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
	
	public static URL market_member_level_fxml_url(){
		try {
			return new URL(path_combine(MEMBER_LEVEL_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL market_member_level_css_url(){
		try {
			return new URL(path_combine(MEMBER_LEVEL_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL market_promotion_check_fxml_url(){
		try {
			return new URL(path_combine(PROMOTION_CHECK_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL market_promotion_check_css_url(){
		try {
			return new URL(path_combine(PROMOTION_CHECK_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL market_time_promotion_fxml_url(){
		try {
			return new URL(path_combine(TIME_PROMOTION_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL market_time_promotion_css_url(){
		try {
			return new URL(path_combine(TIME_PROMOTION_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL market_unexecuted_order_fxml_url(){
		try {
			return new URL(path_combine(UNEXECUTED_ORDER_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL market_unexecuted_order_css_url(){
		try {
			return new URL(path_combine(UNEXECUTED_ORDER_CSS));
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
	
	public static URL market_web_promotion_choose_fxml_url(){
		try {
			return new URL(path_combine(WEB_PROMOTION_CHOOSE_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL market_web_promotion_choose_css_url(){
		try {
			return new URL(path_combine(WEB_PROMOTION_CHOOSE_CSS));
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
