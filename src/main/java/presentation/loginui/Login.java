package presentation.loginui;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application{

	public static void main(String[] args) {
		Application.launch(Login.class);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(new URL("file:src/main/resources/ui/loginui/fxml/login.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(new URL("file:src/main/resources/ui/loginui/css/login.css").toExternalForm());
		primaryStage.setTitle("Login");
		
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
	}
	

}
