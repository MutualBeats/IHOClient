package presentation.clientui.maintainmessage;


import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    private static URL LOGIN_FXML;
    private static URL LOGIN_CSS;
    
    private static URL CHANGE_FXML;
    private static URL CHANGE_CSS;
    
    
    static{
    	try {
			LOGIN_FXML=new URL("file:src/main/resources/ui/loginui/fxml/login.fxml");
			LOGIN_CSS=new URL("file:src/main/resources/ui/loginui/css/login.css");
			
			CHANGE_FXML=new URL("file:src/main/resources/ui/clientui/fxml/change.fxml");
			CHANGE_CSS=new URL("file:src/main/resources/ui/clientui/css/change.css");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @FXML
    void logout(ActionEvent event) {
    	Window window=WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "登录", LOGIN_FXML, LOGIN_CSS);
    }

    @FXML
    void change(ActionEvent event) {
    	Window window=WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "修改个人信息", CHANGE_FXML, CHANGE_CSS);
    }
    
    @FXML
    void return_(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

}
