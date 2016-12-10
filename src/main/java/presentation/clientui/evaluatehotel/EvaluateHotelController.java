package presentation.clientui.evaluatehotel;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Window;
import presentation.utilcontroller.Confirm;
import presentation.utilui.WindowGrab;

public class EvaluateHotelController implements Confirm{

	@FXML
    private Button confirm;

    @FXML
    private Button cancel;

    @FXML
    private Label title;

    @FXML
    void confirm(ActionEvent event) {
    	Window window=WindowGrab.getWindow(event);
    	WindowGrab.startModifyConfirmWindow(window, this);
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

