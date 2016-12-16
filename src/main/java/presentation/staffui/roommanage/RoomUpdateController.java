package presentation.staffui.roommanage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class RoomUpdateController implements Initializable {
	
	@FXML
	private Label room_number;
	
	@FXML
	private Label room_type;
	
	@FXML
	private Label room_price;
	
	@FXML
	private Label room_state;

    @FXML
    private Button cancel;

    @FXML
    private Button confirm;

    private static URL ROOM_UPDATE_CONFIRM_FXML;
    private static URL ROOM_UPDATE_CONFIRM_CSS;
    
    static{
    	try {
    		ROOM_UPDATE_CONFIRM_FXML = new URL("file:src/main/resources/ui/staffui/fxml/roomupdate_confirm.fxml");
    		ROOM_UPDATE_CONFIRM_CSS = new URL("file:src/main/resources/ui/staffui/css/roomupdate_confirm.css");
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
    
    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void confirm(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window,"确认", ROOM_UPDATE_CONFIRM_FXML,ROOM_UPDATE_CONFIRM_CSS);
  
    }


}
