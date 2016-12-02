package presentation.manageui.addpeople;

import java.io.IOException;
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

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }
    
    @FXML
    void confirm(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	try {
			WindowGrab.startWindow(window, new URL("file:src/main/resources/ui/manageui/fxml/addpeopleconfirm.fxml"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
