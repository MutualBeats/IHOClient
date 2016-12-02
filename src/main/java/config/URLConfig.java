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
	
	private static String LOGIN_FXML;
	
	private static String SIGNIN_FXML;
	
	private static String LOGIN_CSS;
	
	private static String SIGNIN_CSS;
	
	
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
			
			login_init(login);
			signin_init(signin);
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
	
	public static URL login_fxml_url() {
		try {
			return new URL(FILE_ROOT_PATH + LOGIN_FXML);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL login_css_url() {
		try {
			return new URL(FILE_ROOT_PATH + LOGIN_CSS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL signin_fxml_url() {
		try {
			return new URL(FILE_ROOT_PATH + SIGNIN_FXML);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL signin_css_url() {
		try {
			return new URL(FILE_ROOT_PATH + SIGNIN_CSS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
