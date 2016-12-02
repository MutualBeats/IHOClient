package presentation.manageui.mainmanager;

import java.net.MalformedURLException;
import java.net.URL;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private Button Look;

    @FXML
    private Label managerName;
    
    private static URL ADD_HOTEL_FXML;
    private static URL ADD_HOTEL_CSS;
    private static URL ADD_PEOPLE_MENU_FXML;
    private static URL ADD_PEOPLE_MENU_CSS;
    private static URL CHANGE_FXML;
    private static URL CHANGE_CSS;
    static{
    	try {
			ADD_HOTEL_FXML = new URL("file:src/main/resources/ui/manageui/fxml/addhotel.fxml");
			ADD_HOTEL_CSS = new URL("file:src/main/resources/ui/manageui/css/addhotel.css");
			ADD_PEOPLE_MENU_FXML=new URL("file:src/main/resources/ui/manageui/fxml/addpeoplemenu.fxml");
			ADD_PEOPLE_MENU_CSS=new URL("file:src/main/resources/ui/manageui/css/addpeoplemenu.css");
			CHANGE_FXML=new URL("file:src/main/resources/ui/manageui/fxml/changemessage.fxml");
			CHANGE_CSS=new URL("file:src/main/resources/ui/manageui/css/changemessage.css");
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void faf9eb(ActionEvent event) {

    }

    @FXML
    void on_look(ActionEvent event) {

    }

    @FXML
    void add_people(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, ADD_PEOPLE_MENU_FXML,ADD_PEOPLE_MENU_CSS); 
    	
    }

    @FXML
    void on_change(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, CHANGE_FXML,CHANGE_CSS);    	
    }

    @FXML
    void add_hotel(ActionEvent event) {

    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, ADD_HOTEL_FXML,ADD_HOTEL_CSS); 
    }

}

