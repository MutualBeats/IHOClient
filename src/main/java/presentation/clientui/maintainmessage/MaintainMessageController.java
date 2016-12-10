package presentation.clientui.maintainmessage;


import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class MaintainMessageController {

    @FXML
    private Button logout;

    @FXML
    private Label phone;

    @FXML
    private Label user_name;

    @FXML
    private Button change;
    
    @FXML
    private Button return_;

    @FXML
    private Label name_real;

    @FXML
    private Label name;

    @FXML
    private Label title;

    @FXML
    private Label credit;

    @FXML
    private Button credit_history;
    
    
    private static URL CHANGE_FXML;
    private static URL CHANGE_CSS;
    
    private static URL CREDIT_FXML;
    private static URL CREDIT_CSS;
    
    static{
    	try {
			CHANGE_FXML=new URL("file:src/main/resources/ui/clientui/fxml/change.fxml");
			CHANGE_CSS=new URL("file:src/main/resources/ui/clientui/css/change.css");
			
			CREDIT_FXML=new URL("file:src/main/resources/ui/clientui/fxml/credit.fxml");
			CREDIT_CSS=new URL("file:src/main/resources/ui/clientui/css/credit.css");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

    @FXML
    void change(ActionEvent event) {
    	Scene frame=WindowGrab.getScene(event);
    	WindowGrab.changeScene(CHANGE_FXML, CHANGE_CSS, frame);
    	
    }
    
    @FXML
    void return_(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void credit_history(ActionEvent event) {
    	Scene frame =WindowGrab.getScene(event);
    	WindowGrab.changeScene(CREDIT_FXML, CREDIT_CSS, frame);
    	
    }
}
