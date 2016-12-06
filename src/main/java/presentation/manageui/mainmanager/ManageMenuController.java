package presentation.manageui.mainmanager;

import java.net.MalformedURLException;
import java.net.URL;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Window;
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
    
    private static URL ADD_HOTEL_FIRST_FXML;
    private static URL ADD_HOTEL_FIRST_CSS;
    private static URL ADD_PEOPLE_MENU_FXML;
    private static URL ADD_PEOPLE_MENU_CSS;
    private static URL CHANGE_FXML;
    private static URL CHANGE_CSS;
    private static URL CHECK_MENU_FXML;
    private static URL CHECK_MENU_CSS;
    
    static{
    	try {
    		ADD_HOTEL_FIRST_FXML = new URL("file:src/main/resources/ui/manageui/fxml/addhotel_one.fxml");
    		ADD_HOTEL_FIRST_CSS = new URL("file:src/main/resources/ui/manageui/css/addhotel_one.css");
			
			ADD_PEOPLE_MENU_FXML=new URL("file:src/main/resources/ui/manageui/fxml/addpeople.fxml");
			ADD_PEOPLE_MENU_CSS=new URL("file:src/main/resources/ui/manageui/css/addpeople.css");
			
			CHANGE_FXML=new URL("file:src/main/resources/ui/manageui/fxml/informationLookMarketer.fxml");
			CHANGE_CSS=new URL("file:src/main/resources/ui/manageui/css/informationLookMarketer.css");
			
			CHECK_MENU_FXML=new URL("file:src/main/resources/ui/manageui/fxml/check_menu.fxml");
			CHECK_MENU_CSS=new URL("file:src/main/resources/ui/manageui/css/check_menu.css");
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void on_check(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "查询人员信息", CHECK_MENU_FXML,CHECK_MENU_CSS);
    }

    @FXML
    void add_people(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "添加营销人员", ADD_PEOPLE_MENU_FXML,ADD_PEOPLE_MENU_CSS);
    }

    @FXML
    void on_change(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, "修改人员信息", CHANGE_FXML,CHANGE_CSS);    	
    }

    @FXML
    void add_hotel(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, "添加酒店", ADD_HOTEL_FIRST_FXML,ADD_HOTEL_FIRST_CSS); 
    }

}

