package presentation.marketerui.Credit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Image;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author apple
 */
public class Credit extends Application {
     public static void main(String[] args) {  
        Application.launch(Credit.class, args);  
    }  
      
    @Override  
    public void start(Stage stage) throws Exception {  
        Parent root = FXMLLoader.load(getClass().getResource("Credit.fxml"));  
        
        Scene scene = new Scene(root,1000, 750); 
        scene.getStylesheets().add(Credit.class.getResource("creditCSS.css").toExternalForm());
        stage.initStyle(StageStyle.DECORATED);  
        stage.setScene(scene);  
        stage.setTitle("充值信用");  
        stage.show();  
    }  
    
}
