package presentation.clientui.createorder;

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

public class CreateOrderController {

    @FXML
    private Button confirm;

    @FXML
    private Button cancel;

    @FXML
    private Label title;

  //搜索酒店
    private static URL SEARCH_HOTEL_FXML;
    private static URL SEARCH_HOTEL_CSS;
    
   
    static{
    	try {
    		SEARCH_HOTEL_FXML=new URL("file:src/main/resources/ui/clientui/fxml/search_hotel.fxml");
			SEARCH_HOTEL_CSS=new URL("file:src/main/resources/ui/clientui/css/search_hotel.css");
			
    	} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void confirm(ActionEvent event) {
    	Scene frame =WindowGrab.getScene(event);
    	WindowGrab.changeScene(SEARCH_HOTEL_FXML, SEARCH_HOTEL_CSS, frame);
    	Stage stage=WindowGrab.getStage(0);
    	stage.setTitle("搜索酒店");
    }

    @FXML
    void cancel(ActionEvent event) {
    	Scene frame =WindowGrab.getScene(event);
    	WindowGrab.changeScene(SEARCH_HOTEL_FXML, SEARCH_HOTEL_CSS, frame);
    	Stage stage=WindowGrab.getStage(0);
    	stage.setTitle("搜索酒店");
    }

}

