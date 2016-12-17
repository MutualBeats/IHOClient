package presentation.marketui.webpromotion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import presentation.utilcontroller.Confirm;
import presentation.utilui.WindowGrab;

public class WebPromotionCreateController implements Confirm{

    @FXML
    private Button confirm;

    @FXML
    private Button cancel;

    
    @FXML
    void confirm(ActionEvent event) {

    }

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

	@Override
	public void confirm() {
		// TODO Auto-generated method stub
		
	}

}

