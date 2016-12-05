/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.manageui.mainmanager;

import java.net.URL;

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

     public static void main(String[] args) {  
        Application.launch(args);  
    }  
      
    @Override  
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(new URL("file:src/main/resources/ui/manageui/fxml/managemenu.fxml"));  
  
        Scene scene = new Scene(root,800, 600);  
        scene.getStylesheets().add(new URL("file:src/main/resources/ui/manageui/css/managemenu.css").toExternalForm());
        stage.initStyle(StageStyle.DECORATED); 
        stage.setScene(scene);  
        stage.setResizable(false);
        stage.setTitle("Manager Menu");  
        stage.show();  
        
    }

}
