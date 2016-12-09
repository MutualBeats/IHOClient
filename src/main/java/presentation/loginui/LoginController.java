package presentation.loginui;

import java.net.URL;
import java.util.ResourceBundle;

import config.urlconfig.LoginUIURLConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;

public class LoginController implements Initializable{
	
	@FXML Button signin;
	@FXML Button login;
	@FXML Button visit;
	@FXML Button exit;
	@FXML TextField user_name;
	@FXML PasswordField password;
	
	@FXML Label name_warning;
	@FXML Label pass_warning;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	@FXML
	public void signin(ActionEvent event) {
		URL fxml = LoginUIURLConfig.signin_fxml_url();
		URL css = LoginUIURLConfig.signin_css_url();
		Window owner = WindowGrab.getWindow(event);
		WindowGrab.startWindow(owner, "注册", fxml, css);
	}

	@FXML
	public void login(ActionEvent event) {
		String name = user_name.getText();
		String pass = password.getText();
		if(name.length() == 0) {
			name_warning.setText("请输入用户名");
		}
		if(pass.length() == 0) {
			pass_warning.setText("请输入密码");
		}
		//TODO : check the internet
		
		//TODO : change to the user stage
	}
	
	@FXML
	public void visit(ActionEvent event) {
		//TODO : Change to user stage 
//		ObservableList<Stage> stage = FXRobotHelper.getStages();
//		Dialog dialog = new Dialog("Test", stage.get(0), "Test");
//		dialog.showDialog();
	}
	
	@FXML
	public void exit(ActionEvent event) {
		System.exit(0);
	}
	
	@FXML
	public void userNameModify(MouseEvent event) {
		CheckUtil.checkWarningBefore(name_warning);
	}
	
	@FXML
	public void passwordModify(MouseEvent event) {
		if(CheckUtil.checkWarningBefore(pass_warning)) {
			password.setText("");
		}
	}

	
}
