/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.manageui.mainmanager;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import presentation.manageui.addPeople.addpeople;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.SplitPane;

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
        
        Parent root = FXMLLoader.load(getClass().getResource("MainUI.fxml"));  
  
        Scene scene = new Scene(root,1000, 750);  
        scene.getStylesheets().add(Manage.class.getResource("manageCSS.css").toExternalForm());
        stage.initStyle(StageStyle.DECORATED); 
        stage.setScene(scene);  
        stage.setTitle("管理人员信息");  
        stage.show();  
        
    }

}
