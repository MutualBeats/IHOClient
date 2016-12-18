package presentation.utilcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import presentation.utilui.WindowGrab;

public class ConfirmController implements Initializable{

	@FXML
	private Button confirm;

	@FXML
	private Button cancel;
	
	@FXML
    private Label confirm_text;
	
	private Confirm owner;
	
	@FXML
	void confirm(ActionEvent event) {
		WindowGrab.closeWindow(event);
		owner.confirm();
	}

	@FXML
	void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		owner = (Confirm) resources.getObject("confirm");
		String message = resources.getString("message");
		if(message != null) {
			confirm_text.setText(message);
		}
	}

}
