/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.staffui.roommanage;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class RoomManageController {

    @FXML
    private Button cancel;

    @FXML
    private Label promotion_title;

    @FXML
    private Button change;

    @FXML
    private Button create;

    @FXML
    private Button look;


    private static URL ROOM_CREATE_FXML;
    private static URL ROOM_CREATE_CSS;
    
    private static URL ROOM_CHECK_FXML;
    private static URL ROOM_CHECK_CSS;
    
    private static URL ROOM_UPDATE_FXML;
    private static URL ROOM_UPDATE_CSS;
    
    static{
    	try {
    		ROOM_CREATE_FXML = new URL("file:src/main/resources/ui/staffui/fxml/room_create.fxml");
    		ROOM_CREATE_CSS = new URL("file:src/main/resources/ui/staffui/css/room_create.css");
    		
    		ROOM_CHECK_FXML = new URL("file:src/main/resources/ui/staffui/fxml/room_check.fxml");
    		ROOM_CHECK_CSS = new URL("file:src/main/resources/ui/staffui/css/room_check.css");
    		
    		ROOM_UPDATE_FXML = new URL("file:src/main/resources/ui/staffui/fxml/room_update.fxml");
    		ROOM_UPDATE_CSS = new URL("file:src/main/resources/ui/staffui/css/room_update.css");
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void change(ActionEvent event) {	
    	Window window = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "修改客房信息",ROOM_UPDATE_FXML,ROOM_UPDATE_CSS);   
	   }

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void look(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, "查看客房信息",ROOM_CHECK_FXML,ROOM_CHECK_CSS);   
    }

    @FXML
    void create(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, "录入客房",ROOM_CREATE_FXML,ROOM_CREATE_CSS);   
    }

}
