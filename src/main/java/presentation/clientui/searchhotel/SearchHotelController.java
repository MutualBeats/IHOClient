package presentation.clientui.searchhotel;


import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import presentation.utilui.WindowGrab;

public class SearchHotelController {

    @FXML
    private Button return_;

    @FXML
    private Button search;

    @FXML
    private Button check;

    @FXML
    private Label title;

    private static URL CLIENTMENU_FXML;
    private static URL CLIENTMENU_CSS;
    
    static{
    	try {
    		CLIENTMENU_FXML=new URL("file:src/main/resources/ui/clientui/fxml/clientmenu.fxml");
			CLIENTMENU_CSS=new URL("file:src/main/resources/ui/clientui/css/clientmenu.css");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    @FXML
    void on_search(ActionEvent event) {
    	
    }

    @FXML
    void check(ActionEvent event) {

    }
    @FXML
    void return_(ActionEvent event) {
    	Scene frame=WindowGrab .getScene(event);
    	WindowGrab.changeScene(CLIENTMENU_FXML, CLIENTMENU_CSS, frame);
    	Stage stage=WindowGrab.getStage(0);
    	stage.setTitle("Client Menu");
    }
}
