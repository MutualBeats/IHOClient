/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.manageui.mainmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author apple
 */
public class ManageMenu extends Application {
    
	 public static Stage stage;
     public static void main(String[] args) {  
        Application.launch(args);  
    }  
      
    @Override  
    public void start(Stage stage) throws Exception {  
    	this.stage=stage;
        Parent root = FXMLLoader.load(getClass().getResource("managemenu.fxml"));  
  
        Scene scene = new Scene(root,700, 500);  
        scene.getStylesheets().add(ManageMenu.class.getResource("managemenu.css").toExternalForm());
        stage.initStyle(StageStyle.DECORATED); 
        stage.setScene(scene);  
        stage.setTitle("Manager Menu");  
        stage.show();  
        
    }

}
