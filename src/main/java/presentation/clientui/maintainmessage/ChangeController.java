package presentation.clientui.maintainmessage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void confirm(ActionEvent event) {
    	Window window=WindowGrab.getWindow(event);
    	WindowGrab.startConfirmWindow(window, this);
    }

	@Override
	public void confirm() {
		// TODO Auto-generated method stub
		
	}

}

