/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation.manageui.check;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class CheckMenuController {

	@FXML
    private Button cancel;

    @FXML
    private Button search;

    @FXML
    private Label check_title;

    @FXML
    private Button check;

    private static URL CHECK_FXML;
    private static URL CHECK_CSS;
    
    static{
    	try {
    		CHECK_FXML=new URL("file:src/main/resources/ui/manageui/fxml/check.fxml");
    		CHECK_CSS=new URL("file:src/main/resources/ui/manageui/css/check.css");
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    	
    }
   
    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void on_check(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "人员信息", CHECK_FXML,CHECK_CSS);
    }

    @FXML
    void on_search(ActionEvent event) {

    }

}


