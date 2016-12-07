package config.urlconfig;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class UtilUIURLConfig {
	
	private final static String UI_CFG_PATH = "src/main/resources/config/url_config.xml";
	
	private final static String FXML_PATH = "fxml_path";
	
	private final static String CSS_PATH = "css_path";
	
	private final static String ROOT_PATH = "root_path";
	
	private static String FILE_ROOT_PATH;
	
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
			Element confirm = root.element("confirm");
			Element error = root.element("error");
			
			confirm_init(confirm);
			error_init(error);
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
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
