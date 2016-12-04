package presentation.manageui.addhotel;

import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class AddHotelController {

    @FXML
    private Button first_cancel;

    @FXML
    private Button first_confirm;

    @FXML
    private AnchorPane first_pane;

    private static URL ADD_HOTEL_TWO_FXML;
    private static URL ADD_HOTEL_TWO_CSS;
    static{
    	try {
    		ADD_HOTEL_TWO_FXML = new URL("file:src/main/resources/ui/manageui/fxml/addhotel_two.fxml");
    		ADD_HOTEL_TWO_CSS = new URL("file:src/main/resources/ui/manageui/css/addhotel_two.css");
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void first_confirm(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, "完善人员信息", ADD_HOTEL_TWO_FXML,ADD_HOTEL_TWO_CSS);   
    }

    @FXML
    void first_cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

}
