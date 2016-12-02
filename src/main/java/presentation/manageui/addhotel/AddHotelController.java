/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.manageui.addhotel;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class AddHotelController implements Initializable{

    @FXML
    private Button confirm;
    
    @FXML
    private Button cancel;
    
    private static URL ADD_HOTEL_CONFIRM_FXML;
    private static URL ADD_HOTEL_CONFIRM_CSS;
    static{
    	try {
    		ADD_HOTEL_CONFIRM_FXML = new URL("file:src/main/resources/ui/manageui/fxml/addhotelconfirm.fxml");
    		ADD_HOTEL_CONFIRM_CSS = new URL("file:src/main/resources/ui/manageui/css/addhotelconfirm.css");
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	// TODO Auto-generated method stub
    	
    }
    @FXML
    void confirm(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, ADD_HOTEL_CONFIRM_FXML,ADD_HOTEL_CONFIRM_CSS);   
    }
    @FXML
    public void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

}
