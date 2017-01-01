package presentation.loginui;

import config.urlconfig.LoginUIURLConfig;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Login extends Application{

	public static void main(String[] args) {
		Application.launch(Login.class);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(LoginUIURLConfig.login_fxml_url());
		Scene scene = new Scene(root);
		scene.getStylesheets().add(LoginUIURLConfig.login_css_url().toExternalForm());
		primaryStage.setTitle("Login");
		primaryStage.getIcons().add(new Image("file:src/main/resources/image/staff/photo.png"));
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
	}
	
}
