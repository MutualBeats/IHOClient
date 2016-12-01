package presentation.loginui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import presentation.utilui.WindowGrab;

public class SigninController implements Initializable{
	
	@FXML Button confirm;
	@FXML Button cancel;
	@FXML TextField user_name;
	@FXML TextField name;
	@FXML TextField phone;
	@FXML PasswordField ps;
	@FXML PasswordField ps_again;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	@FXML
	public void confirm(ActionEvent event) {
		
	}
	
	@FXML
	public void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}
	

}
