package presentation.marketui.credit;


import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import presentation.utilui.WindowGrab;

public class CreditExcuteController {

    @FXML
    private Button confirm;

    @FXML
    private Button cancel;

    private static URL CONFIRM_FXML;
    private static URL CONFIRM_CSS;
    
    static{
    	try {
    		
    		CONFIRM_FXML=new URL("file:src/main/resources/ui/marketui/fxml/confirm.fxml");
    		CONFIRM_CSS=new URL("file:src/main/resources/ui/marketui/css/confirm.css");
    		
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void confirm(ActionEvent event) {
     	Window window = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "确认", CONFIRM_FXML,CONFIRM_CSS);
    }

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

}

