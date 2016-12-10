package presentation.clientui.browseorder;


import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class ExecuteCheckController {

    @FXML
    private Label order_status;

    @FXML
    private Button return_;

    @FXML
    private Label order_id7;

    @FXML
    private Label expect_leave_time;

    @FXML
    private Label expect_check_in;

    @FXML
    private Label expect_population;

    @FXML
    private Label order_id;

    @FXML
    private Button evaluate;

    @FXML
    private Label hotel_name;

    @FXML
    private Label last_execute_time;
    
    
    private static URL EVALUATE_HOTEL_FXML;
    private static URL EVALUATE_HOTEL_CSS;
    
    static{
    	try {
			
    		EVALUATE_HOTEL_FXML=new URL("file:src/main/resources/ui/clientui/fxml/evaluate_hotel.fxml");
    		EVALUATE_HOTEL_CSS=new URL("file:src/main/resources/ui/clientui/css/evaluate_hotel.css");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    @FXML
    void return_(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void evaluate(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    	Window window=WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "评价酒店", EVALUATE_HOTEL_FXML, EVALUATE_HOTEL_CSS);
    }

}

