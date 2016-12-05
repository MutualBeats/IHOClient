package presentation.marketui.mainmarket;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainMarket extends Application{
	 public static void main(String[] args) {  
	        Application.launch(args);  
	    }  
	       
	   @Override  
	 public void start(Stage stage) throws Exception {
		 Parent root = FXMLLoader.load(new URL("file:src/main/resources/ui/marketui/fxml/marketmenu.fxml"));  
		 
		 Scene scene = new Scene(root,800, 600);  
		 scene.getStylesheets().add(new URL("file:src/main/resources/ui/marketui/css/marketmenu.css").toExternalForm());
		 stage.initStyle(StageStyle.DECORATED); 
		 stage.setScene(scene);  
		 stage.setResizable(false);
		 stage.setTitle("Market Menu");  
		 stage.show();  
	 }
}
