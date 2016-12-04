package presentation.manageui.addhotel;

import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class AddHotelController_two {

    @FXML
    private AnchorPane second_pane;

    @FXML
    private Button second_cancel;

    @FXML
    private Button second_confirm;

    private static URL ADD_HOTEL_THREE_FXML;
    private static URL ADD_HOTEL_THREE_CSS;
    static{
    	try {
    		ADD_HOTEL_THREE_FXML = new URL("file:src/main/resources/ui/manageui/fxml/addhotel_three.fxml");
    		ADD_HOTEL_THREE_CSS = new URL("file:src/main/resources/ui/manageui/css/addhotel_three.css");
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void second_confirm(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, ADD_HOTEL_THREE_FXML,ADD_HOTEL_THREE_CSS); 
    }

    @FXML
    void second_cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

}
