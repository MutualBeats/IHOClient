/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.manageui.addPeople;

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


/**
 *
 * @author apple
 */
public class addpeople extends Application {
//    
//    public static void main(String[] args) {  
//        Application.launch(addpeople.class, args);  
//    }  
//      
    @Override  
    public void start(Stage stage) throws Exception {  
        Parent root = FXMLLoader.load(getClass().getResource("addpeople.fxml"));  
  
        Scene scene = new Scene(root, 460 , 475);  
        scene.getStylesheets().add(addpeople.class.getResource("addpeopleCSS.css").toExternalForm());
        stage.initStyle(StageStyle.DECORATED);  
        stage.setScene(scene);  
        stage.setTitle("添加酒店");  
        stage.show();  
    }  

}
