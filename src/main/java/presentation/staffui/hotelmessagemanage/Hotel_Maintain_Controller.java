package presentation.staffui.hotelmessagemanage;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class Hotel_Maintain_Controller {

    @FXML
    private Button cancel;

    @FXML
    private Label hotel_maintain_title;

    @FXML
    private Button update;

    private static URL CONFIRM_FXML;
    private static URL CONFIRM_CSS;
    static{
    	try {
    		CONFIRM_FXML = new URL("file:src/main/resources/ui/staffui/fxml/hotel_maintain_confirm.fxml");
    		CONFIRM_CSS = new URL("file:src/main/resources/ui/staffui/css/hotel_maintain_confirm.css");
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void update(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window,"确认", CONFIRM_FXML,CONFIRM_CSS);
    }

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }


}
