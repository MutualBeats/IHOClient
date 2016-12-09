package presentation.clientui.browseorder;


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

public class BrowseOrderController {


    @FXML
    private Button revoked_order;

    @FXML
    private Button executed_order;

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
    
    private static URL CLIENTMENU_FXML;
    private static URL CLIENTMENU_CSS;
    
    static{
    	try {
			
			CHECK_FXML=new URL("file:src/main/resources/ui/clientui/fxml/check.fxml");
			CHECK_CSS=new URL("file:src/main/resources/ui/clientui/css/check.css");
			
			CLIENTMENU_FXML=new URL("file:src/main/resources/ui/clientui/fxml/clientmenu.fxml");
			CLIENTMENU_CSS=new URL("file:src/main/resources/ui/clientui/css/clientmenu.css");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
   
    @FXML
    void return_(ActionEvent event) {
    	Scene frame=WindowGrab .getScene(event);
    	WindowGrab.changeScene(CLIENTMENU_FXML, CLIENTMENU_CSS, frame);
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

