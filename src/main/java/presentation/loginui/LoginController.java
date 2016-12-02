package presentation.loginui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
//			WindowGrab.startWindow(window, getClass().getResource("signin.fxml"));
			Stage primaryStage=new Stage();
			Parent root = FXMLLoader.load(new URL("file:src/main/resources/ui/loginui/fxml/signin.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(new URL("file:src/main/resources/ui/loginui/css/signin.css").toExternalForm());
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
		
	}
	
	@FXML
	public void visit(ActionEvent event) {
		
	}
	
	@FXML
	public void exit(ActionEvent event) {
		System.exit(0);
	}
	
}
