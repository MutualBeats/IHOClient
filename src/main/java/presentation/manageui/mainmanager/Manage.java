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
public class Manage extends Application {
    
       
     public static void main(String[] args) {  
        Application.launch(args);  
    }  
      
    @Override  
    public void start(Stage stage) throws Exception {  
        
        Parent root = FXMLLoader.load(getClass().getResource("manage.fxml"));  
  
        Scene scene = new Scene(root,1000, 750);  
        scene.getStylesheets().add(Manage.class.getResource("manageCSS.css").toExternalForm());
        stage.initStyle(StageStyle.DECORATED); 
        stage.setScene(scene);  
        stage.setTitle("管理人员信息");  
        stage.show();  
        
    }

}
