package presentation.staffui.roommanage;

import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class RoomCheckController {

    @FXML
    private Button cancel;

    @FXML
    private Button check;

    private static URL ROOM_UPDATE_FXML;
    private static URL ROOM_UPDATE_CSS;
    
    static{
    	try {
    		ROOM_UPDATE_FXML = new URL("file:src/main/resources/ui/staffui/fxml/room_update.fxml");
    		ROOM_UPDATE_CSS = new URL("file:src/main/resources/ui/staffui/css/room_update.css");
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void check(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window,"更新客房信息", ROOM_UPDATE_FXML,ROOM_UPDATE_CSS);   
  
    }

}
