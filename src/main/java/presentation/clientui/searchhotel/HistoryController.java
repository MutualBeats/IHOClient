package presentation.clientui.searchhotel;

import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.utilui.WindowGrab;

public class HistoryController {

	@FXML
    private Button history_hotel;

    @FXML
    private Button all;

    @FXML
    private Button check_order;

    @FXML
    private Pane history_all_pane;

    @FXML
    private Pane history_hotel_pane;

    @FXML
    private Pane history_order_pane;

    @FXML
    private Label title;

    @FXML
    private Button check_all;

    @FXML
    private Button check_hotel;

    @FXML
    private Button history_order;

    
    @FXML
    private Button cancel;
    
    
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
    void history_hotel(ActionEvent event) {
    	history_all_pane.setVisible(false);
    	history_order_pane.setVisible(false);
    	history_hotel_pane.setVisible(true);
    }

    @FXML
    void history_order(ActionEvent event) {
    	history_all_pane.setVisible(false);
    	history_hotel_pane.setVisible(false);
    	history_order_pane.setVisible(true);
    }

    @FXML
    void all(ActionEvent event) {
    	history_order_pane.setVisible(false);
    	history_hotel_pane.setVisible(false);
    	history_all_pane.setVisible(true);
    }

    @FXML
    void check_all(ActionEvent event) {

    }

    @FXML
    void check_hotel(ActionEvent event) {

    }

    @FXML
    void check_order(ActionEvent event) {

    }
    
    @FXML
    void cancel(ActionEvent event) {
    	Scene frame=WindowGrab .getScene(event);
    	WindowGrab.changeScene(CLIENTMENU_FXML, CLIENTMENU_CSS, frame);
    	Stage stage=WindowGrab.getStage(0);
    	stage.setTitle("Client Menu");
    }
}
