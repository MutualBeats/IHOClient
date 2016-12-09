package presentation.clientui.browseorder;


import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class BrowseOrderController {

	
    @FXML
    private Button unexecuted_revoke;

    @FXML
    private Button executed_order;

    @FXML
    private Pane executed_pane;
    
    @FXML
    private Button all_order;

    @FXML
    private Pane all_pane;

    @FXML
    private Button check;

    @FXML
    private Label title;

    @FXML
    private Button unexecuted_check;

    @FXML
    private Button revoked_order;

    @FXML
    private Button return_;

    @FXML
    private Button unusual_order;

    @FXML
    private Pane unexecuted_pane;

    @FXML
    private Button unexecuted_return;

    @FXML
    private Button unexecuted_order;

    @FXML
    private Button executed_check;
    
    @FXML
    private Button executed_return;

    private static URL CHECK_FXML;
    private static URL CHECK_CSS;
    
    private static URL EXECUTE_CHECK_FXML;
    private static URL EXECUTE_CHECK_CSS;
    
    private static URL CLIENTMENU_FXML;
    private static URL CLIENTMENU_CSS;
    
    static{
    	try {
			
			CHECK_FXML=new URL("file:src/main/resources/ui/clientui/fxml/check.fxml");
			CHECK_CSS=new URL("file:src/main/resources/ui/clientui/css/check.css");
			
			CLIENTMENU_FXML=new URL("file:src/main/resources/ui/clientui/fxml/clientmenu.fxml");
			CLIENTMENU_CSS=new URL("file:src/main/resources/ui/clientui/css/clientmenu.css");
			
			EXECUTE_CHECK_FXML=new URL("file:src/main/resources/ui/clientui/fxml/executed_check.fxml");
			EXECUTE_CHECK_CSS=new URL("file:src/main/resources/ui/clientui/css/executed_check.css");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
    @FXML
    void all_order(ActionEvent event) {
    	executed_pane.setVisible(false);
    	unexecuted_pane.setVisible(false);
    	all_pane.setVisible(true);
    }


    @FXML
    void executed_order(ActionEvent event) {
    	unexecuted_pane.setVisible(false);
    	all_pane.setVisible(false);
    	executed_pane.setVisible(true);
    }

    @FXML
    void unexecuted_order(ActionEvent event) {
    	executed_pane.setVisible(false);
    	all_pane.setVisible(false);
    	unexecuted_pane.setVisible(true);
    }

    @FXML
    void revoked_order(ActionEvent event) {
    	executed_pane.setVisible(false);
    	unexecuted_pane.setVisible(false);
    	all_pane.setVisible(true);
    }


    @FXML
    void unusual_order(ActionEvent event) {
    	executed_pane.setVisible(false);
    	unexecuted_pane.setVisible(false);
    	all_pane.setVisible(true);
    }

    @FXML
    void check(ActionEvent event){
    	Window window=WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "查看订单详情", CHECK_FXML, CHECK_CSS);
    }

    @FXML
    void return_(ActionEvent event) {
    	Scene frame=WindowGrab .getScene(event);
    	WindowGrab.changeScene(CLIENTMENU_FXML, CLIENTMENU_CSS, frame);
    }


    @FXML
    void unexecuted_revoke(ActionEvent event) {

    }
    
    @FXML
    void executed_check(ActionEvent event) {
    	Window window=WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "查看订单详情", EXECUTE_CHECK_FXML, EXECUTE_CHECK_CSS);
    
    }
}

