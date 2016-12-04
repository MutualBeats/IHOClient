package presentation.manageui.change;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class ChangeMessageController implements Initializable{
	
    @FXML
    private Button cancel;

    private static URL CHANGE_MESSAGE_CONFIRM_FXML;
    private static URL CHANGE_MESSAGE_CONFIRM_CSS;
    static{
    	try {
    		CHANGE_MESSAGE_CONFIRM_FXML = new URL("file:src/main/resources/ui/manageui/fxml/changemessageconfirm.fxml");
    		CHANGE_MESSAGE_CONFIRM_CSS = new URL("file:src/main/resources/ui/manageui/css/changemessageconfirm.css");
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    	
    }
    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }
    
    @FXML
    void add_people(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "修改人员信息",CHANGE_MESSAGE_CONFIRM_FXML,CHANGE_MESSAGE_CONFIRM_CSS);
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
