package presentation.manageui.addpeople;

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

public class AddPeopleController implements Initializable{
	
    @FXML
    private Button cancel;
    private static URL ADD_PEOPLE_CONFIRM_FXML;
    private static URL ADD_PEOPLE_CONFIRM_CSS;
    static{
    	try {
    		ADD_PEOPLE_CONFIRM_FXML = new URL("file:src/main/resources/ui/manageui/fxml/addpeopleconfirm.fxml");
    		ADD_PEOPLE_CONFIRM_CSS = new URL("file:src/main/resources/ui/manageui/css/add_people_confirm.css");
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }
    
    @FXML
    void confirm(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window,ADD_PEOPLE_CONFIRM_FXML,ADD_PEOPLE_CONFIRM_CSS);		   	
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
