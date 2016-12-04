package presentation.manageui.check;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class CheckController implements Initializable{
	
    @FXML
    private Button cancel;
    
    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }
    @FXML
    private Button change;

    private static URL CHANGE_FXML;
    private static URL CHANGE_CSS;
    
    static{
    	try {
    		CHANGE_FXML=new URL("file:src/main/resources/ui/manageui/fxml/changemessage.fxml");
			CHANGE_CSS=new URL("file:src/main/resources/ui/manageui/css/changemessage.css");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    	
    }
    @FXML
    void change(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, "修改人员信息", CHANGE_FXML,CHANGE_CSS);  
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	   
}
