package presentation.manageui.change;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import presentation.manageui.mainmanager.ManageMenu;

public class Confirm {
	 public static Stage stage;
     
    public void start(Stage stage) throws Exception {  
    	this.stage=stage;
    	Parent root = FXMLLoader.load(getClass().getResource("confirm.fxml"));  
	    Scene scene = new Scene(root,350, 225);  
	    scene.getStylesheets().add(Confirm.class.getResource("confirm.css").toExternalForm());
	    stage.initStyle(StageStyle.DECORATED); 
	    stage.setScene(scene);  
	    stage.setTitle("Confirm");  
	    stage.show();  
		 
    }
}
