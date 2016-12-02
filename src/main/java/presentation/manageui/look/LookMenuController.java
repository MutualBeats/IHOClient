/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation.manageui.look;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class LookMenuController {

    @FXML
    private Button search;

    @FXML
    private Button look;

    @FXML
    private Label addtitle;
    
    private static URL LOOK_FXML;
    private static URL LOOK_CSS;
    
    static{
    	try {
			LOOK_FXML=new URL("file:src/main/resources/ui/manageui/fxml/look.fxml");
			LOOK_CSS=new URL("file:src/main/resources/ui/manageui/css/look.css");
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    	
    }
    
    @FXML
    void fffbe5(ActionEvent event) {

    }

    @FXML
    void bfbe97(ActionEvent event) {

    }

    @FXML
    void d9a96a(ActionEvent event) {

    }

    @FXML
    void bfe5a5(ActionEvent event) {

    }

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void on_Look(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, LOOK_FXML,LOOK_CSS);
    }

}


