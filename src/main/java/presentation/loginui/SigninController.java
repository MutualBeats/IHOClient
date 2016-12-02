package presentation.loginui;

import java.net.URL;
import java.util.ResourceBundle;

import config.NumberConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
	@FXML Label name_warning;
	@FXML Label phone_warning;
	@FXML Label ps_warning;
	
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
	private boolean checkUserName() {
		String user = user_name.getText();
		int name_length = user.length();
		if(name_length == 0) {
			//Name shouldn't be empty
			user_name_warning.setText("Please Input Your User Name");
			return false;
		}
		boolean user_name_check = NumberConfig.userNameFormatterCheck(user);
		if(!user_name_check) {
			//name formatter check
			user_name_warning.setText("Your user name should be 8 ~ 12 bits and can only use 0~9 and a~z");
		}
		return user_name_check;
	}
	
	/**
	 * Check the name formatter
	 */
	private boolean checkName() {
		String c_name = name.getText();
		if(c_name.length() == 0) {
			name_warning.setText("Please Input Your Name");
			return false;
		}
		boolean name_check = NumberConfig.nameFormatterCheck(c_name);
		if(!name_check) {
			name_warning.setText("Your name should be 1~12 bits and empty char is not permit");
		}
		return name_check;
		
	}
	
	/**
	 * Check the phone formatter
	 */
	private boolean checkPhone() {
		String ph = phone.getText();
		if(ph.length() == 0) {
			phone_warning.setText("Please input your phone");
			return false;
		}
		boolean ph_check = NumberConfig.phoneFormatterCheck(ph);
		if(!ph_check) {
			phone_warning.setText("Your phone number should be 11 bit, and only number permit");
		}
		return ph_check;
	}
	
	/**
	 * Check the password formatter
	 * Check the password input twice.
	 */
	private boolean checkPassword() {	
		String pass = ps.getText();
		String pass_again = ps_again.getText();
		if(pass.length() == 0) {
			ps_warning.setText("Please Input Your Password");
			return false;
		}
		boolean ps_check = NumberConfig.passFormatterCheck(pass);
		if(!ps_check) {
			ps_warning.setText("Your password should be 8~16 bits, and empty char is not permit");
			return false;
		}
		if(!pass.equals(pass_again)) {
			ps_warning.setText("The password must be the same.");
			return false;
		}
		return true;
	}
	
	@FXML
	public void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}
	@FXML
    void b22e2e(ActionEvent event) {

    }
	
	@FXML
	public void nameModify(MouseEvent event){
		checkWarningBefore(name_warning);
	}
	
	@FXML
	public void userNameModify(MouseEvent event){
		checkWarningBefore(user_name_warning);
	}
	
	@FXML
	public void phoneModify(MouseEvent event){
		checkWarningBefore(phone_warning);
	}
	
	@FXML
	public void passwordModify(MouseEvent event){
		checkWarningBefore(ps_warning);
		ps.setText("");
	}
	
	private void checkWarningBefore(Label label) {
		String warning = label.getText();
		if(warning.length() != 0) {
			label.setText("");
		}
	}

}
