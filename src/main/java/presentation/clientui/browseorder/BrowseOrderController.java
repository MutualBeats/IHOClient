package presentation.clientui.browseorder;


import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class BrowseOrderController {

	@FXML
    private Button logout;

    @FXML
    private Button revoked_order;

    @FXML
    private Button executed_order;

    @FXML
    private Label user_name;

    @FXML
    private Button unusual_order;

    @FXML
    private Button all_order;

    @FXML
    private Label title;
    
    @FXML
    private Button unexcuted_order;
    
    @FXML
    private Button unexecuted_order;
    
    @FXML
    private Button check;
    
    @FXML
    private Button return_;
    
    private static URL CHECK_FXML;
    private static URL CHECK_CSS;
    
    private static URL LOGIN_FXML;
    private static URL LOGIN_CSS;
    
    static{
    	try {
			LOGIN_FXML=new URL("file:src/main/resources/ui/loginui/fxml/login.fxml");
			LOGIN_CSS=new URL("file:src/main/resources/ui/loginui/css/login.css");
			
			CHECK_FXML=new URL("file:src/main/resources/ui/clientui/fxml/check.fxml");
			CHECK_CSS=new URL("file:src/main/resources/ui/clientui/css/check.css");
			
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
    void return_(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }
    
    
    @FXML
    void check(ActionEvent event){
    	Window window=WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "查看订单详情", CHECK_FXML, CHECK_CSS);
    }
    @FXML
    void all_order(ActionEvent event) {

    }

    @FXML
    void executed_order(ActionEvent event) {

    }

    @FXML
    void unexecuted_order(ActionEvent event) {

    }

    @FXML
    void revoked_order(ActionEvent event) {

    }

    @FXML
    void unusual_order(ActionEvent event) {

    }
    
    
}

