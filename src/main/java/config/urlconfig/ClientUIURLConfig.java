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
	
	//Client : client menu
	
	private static String CLIENT_MENU_FXML;
	
	private static String CLIENT_MENU_CSS;
	
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
		
		Element client_menu = client.element("client_menu");
		
		Element fxml;
		Element css;
		
		//client menu
		fxml = client_menu.element("fxml");
		css = client_menu.element("css");
		CLIENT_MENU_FXML = client_root + fxml.attributeValue(FXML_PATH);
		CLIENT_MENU_CSS = client_root + css.attributeValue(CSS_PATH);
		
	}
	
	
	public URL client_menu_fxml_url(){
		try {
			return new URL(path_combine(CLIENT_MENU_FXML));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public URL client_menu_css_url(){
		try {
			return new URL(path_combine(CLIENT_MENU_CSS));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String path_combine(String path) {
		return FILE_ROOT_PATH + path;
	}
	
}
