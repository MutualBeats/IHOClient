package presentation.loginui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import presentation.utilui.WindowGrab;

public class SigninController implements Initializable{
	
	@FXML Button confirm;
	@FXML Button cancel;
	@FXML TextField user_name;
	@FXML TextField name;
	@FXML TextField phone;
	@FXML PasswordField ps;
	@FXML PasswordField ps_again;
	@FXML Label user_name_warning;
	@FXML Label name_waning;
	@FXML Label phone_waning;
	@FXML Label ps_waning;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	@FXML
	public void confirm(ActionEvent event) {
		checkInputFormatter();
	}
	
	private void checkInputFormatter() {
		checkUserName();
		checkName();
		checkPhone();
		checkPassword();
	}
	
	//TODO : Connect the server and check the user_name is used or not
	@FXML
	private void checkUserName() {
		
	}
	
	/**
	 * Check the name formatter
	 */
	@FXML
	private void checkName() {
		
	}
	
	/**
	 * Check the phone formatter
	 */
	@FXML
	private void checkPhone() {
		
	}
	
	/**
	 * Check the password formatter
	 * Check the password input twice.
	 */
	@FXML
	private void checkPassword() {	
	}
	
	@FXML
	public void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}
	@FXML
    void b22e2e(ActionEvent event) {

    }

}
