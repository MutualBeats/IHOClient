package presentation.loginui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class LoginController implements Initializable{
	
	@FXML Button signin;
	@FXML Button login;
	@FXML Button visit;
	@FXML Button exit;
	@FXML TextField user_name;
	@FXML PasswordField password;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	@FXML
	public void signin(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		try {
			WindowGrab.startWindow(window, getClass().getResource("signin.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void login(ActionEvent event) {
		String name = user_name.getText();
		String pass = password.getText();
		
	}
	
	@FXML
	public void visit(ActionEvent event) {
		
	}
	
	@FXML
	public void exit(ActionEvent event) {
		System.exit(0);
	}
	
}
