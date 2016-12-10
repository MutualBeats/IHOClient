package presentation.clientui.maintainmessage;


import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import presentation.utilui.WindowGrab;

public class CreditController {

    @FXML
    private Button cancel;
    
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

}

