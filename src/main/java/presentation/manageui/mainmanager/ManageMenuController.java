package presentation.manageui.mainmanager;

import java.net.MalformedURLException;
import java.net.URL;

import config.urlconfig.ManageUIURLConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Window;
import presentation.bundle.ManageIDInputHandle;
import presentation.utilui.WindowGrab;

public class ManageMenuController {

	@FXML
    private Button addhotel;

    @FXML
    private Button addpeople;

    @FXML
    private Button change;

    @FXML
    private Label manageID;

    @FXML
    private Pane hotel_pane;

    @FXML
    private Pane people_pane;

    @FXML
    private Button check;

    @FXML
    private Label managerName;

    @FXML
    private Label title;

    private static URL menu_fxml ;
    private static URL menu_css ;
    
    static {
    	
    	try {
    		menu_fxml = new URL("file:src/main/resources/ui/manageui/fxml/check_menu.fxml");
			menu_css = new URL("file:src/main/resources/ui/manageui/css/check_menu.css");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void on_check(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "查询人员信息",  menu_fxml,menu_css);
    }

    @FXML
    void add_people(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "添加营销人员", ManageUIURLConfig.manage_add_people_fxml(),ManageUIURLConfig.manage_add_people_css());
    }

    @FXML
    void on_change(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	WindowGrab.startIDInputWindow(window, new ManageIDInputHandle());  	
    }

    @FXML
    void add_hotel(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, "添加酒店", ManageUIURLConfig.manage_add_hotel_one_fxml(),ManageUIURLConfig.manage_add_hotel_one_css()); 
    }

}

