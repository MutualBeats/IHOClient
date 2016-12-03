package presentation.loginui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import config.URLConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.utilui.WarningLabel;

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
		try {
			Stage primaryStage=new Stage();
			Parent root = FXMLLoader.load(URLConfig.signin_fxml_url());
			Scene scene = new Scene(root);
			scene.getStylesheets().add(URLConfig.signin_css_url().toExternalForm());
			primaryStage.setTitle("SignIn");
			
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	}
	
	@FXML
	public void exit(ActionEvent event) {
		System.exit(0);
	}
	
	@FXML
	public void userNameModify(MouseEvent event) {
		WarningLabel.checkWarningBefore(name_warning);
	}
	
	@FXML
	public void passwordModify(MouseEvent event) {
		if(WarningLabel.checkWarningBefore(pass_warning)) {
			password.setText("");
		}
	}

	
}
