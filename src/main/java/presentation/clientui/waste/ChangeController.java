package presentation.clientui.waste;

import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Window;
import presentation.utilcontroller.Confirm;
import presentation.utilui.WindowGrab;

public class ChangeController implements Confirm {

	@FXML
    private Button cancel;

    @FXML
    private Button confirm;

    @FXML
    private Label credit;

    private static URL MAINTAIN_MESSAGE_FXML;
    private static URL MAINTAIN_MESSAGE_CSS;
    
    
    static{
    	try {
    		MAINTAIN_MESSAGE_FXML=new URL("file:src/main/resources/ui/clientui/fxml/maintain_message.fxml");
    		MAINTAIN_MESSAGE_CSS=new URL("file:src/main/resources/ui/clientui/css/maintain_message.css");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void cancel(ActionEvent event) {
    	Scene frame=WindowGrab.getScene(event);
    	WindowGrab.changeScene(MAINTAIN_MESSAGE_FXML, MAINTAIN_MESSAGE_CSS, frame);
     }

    @FXML
    void confirm(ActionEvent event) {
    	Window window=WindowGrab.getWindow(event);
    	WindowGrab.startConfirmWindow(window, this, "是否确认修改？");
    }

	@Override
	public void confirm() {
		// TODO Auto-generated method stub
		
	}

}

