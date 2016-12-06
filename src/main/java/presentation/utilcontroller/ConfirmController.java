package presentation.utilcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import presentation.utilui.WindowGrab;

public class ConfirmController implements Initializable{

	@FXML
	private Button confirm;

	@FXML
	private Button cancel;
	
	private Confirm owner;
	
	@FXML
	void confirm(ActionEvent event) {
		owner.confirm();
		WindowGrab.closeWindow(event);
	}

	@FXML
	void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		owner = (Confirm) resources.getObject("confirm");
	}

}
