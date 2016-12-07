package presentation.utilcontroller;

import config.NumberConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;

public abstract class RegistCheckController {
	
	@FXML
	protected Button confirm;
	@FXML
	protected Button cancel;
	
	@FXML
	protected TextField user_name;
	@FXML
	protected TextField name;
	@FXML
	protected TextField phone;
	@FXML
	protected PasswordField ps;
	@FXML
	protected PasswordField ps_again;
	@FXML
	protected Label user_name_warning;
	@FXML
	protected Label name_warning;
	@FXML 
	protected Label phone_warning;
	@FXML 
	protected Label ps_warning;
	
	
	@FXML
	protected abstract void confirm(ActionEvent event);
	
	@FXML
	public void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}
	
	public boolean checkInputFormatter() {
		boolean user_name_check = checkUserName();
		boolean name_check = checkName();
		boolean phone_check = checkPhone();
		boolean pass_check = checkPassword();
		return user_name_check && name_check && phone_check && pass_check;
	}
	
	//TODO : Connect the server and check the user_name is used or not
	private boolean checkUserName() {
		String user = user_name.getText();
		int name_length = user.length();
		if(name_length == 0) {
			//Name shouldn't be empty
			user_name_warning.setText("请输入用户名");
			return false;
		}
		boolean user_name_check = NumberConfig.userNameFormatterCheck(user);
		if(!user_name_check) {
			//name formatter check
			user_name_warning.setText("用户名应为8～12位数字或字母");
		}
		return user_name_check;
	}
	
	/**
	 * Check the name formatter
	 */
	private boolean checkName() {
		String c_name = name.getText();
		if(c_name.length() == 0) {
			name_warning.setText("请输入您的姓名");
			return false;
		}
		boolean name_check = NumberConfig.nameFormatterCheck(c_name);
		if(!name_check) {
			name_warning.setText("姓名应为1～12位，不包含空格等特殊字符");
		}
		return name_check;
		
	}
	
	/**
	 * Check the phone formatter
	 */
	private boolean checkPhone() {
		String ph = phone.getText();
		if(ph.length() == 0) {
			phone_warning.setText("请输入手机");
			return false;
		}
		boolean ph_check = NumberConfig.phoneFormatterCheck(ph);
		if(!ph_check) {
			phone_warning.setText("手机号应为11位数字");
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
			ps_warning.setText("请输入密码");
			return false;
		}
		boolean ps_check = NumberConfig.passFormatterCheck(pass);
		if(!ps_check) {
			ps_warning.setText("密码应为8～16位，且不含空格等特殊字符");
			return false;
		}
		if(!pass.equals(pass_again)) {
			ps_warning.setText("两次密码不相同");
			return false;
		}
		return true;
	}
	
	@FXML
	public void nameModify(MouseEvent event){
		CheckUtil.checkWarningBefore(name_warning);
	}
	
	@FXML
	public void userNameModify(MouseEvent event){
		CheckUtil.checkWarningBefore(user_name_warning);
	}
	
	@FXML
	public void phoneModify(MouseEvent event){
		CheckUtil.checkWarningBefore(phone_warning);
	}
	
	@FXML
	public void passwordModify(MouseEvent event){
		boolean warn_before = CheckUtil.checkWarningBefore(ps_warning);
		if(warn_before) {
			ps.setText("");
			ps_again.setText("");
		}
	}
	
	@FXML
	public void passwordAgainModify(MouseEvent event){
		boolean warn_before = CheckUtil.checkWarningBefore(ps_warning);
		if(warn_before) {
			ps_again.setText("");
		}
	}
	
}
