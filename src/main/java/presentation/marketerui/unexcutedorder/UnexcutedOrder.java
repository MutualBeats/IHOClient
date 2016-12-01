/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.marketerui.unexcutedorder;

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
public class UnexcutedOrder extends Application {
  public static void main(String[] args) {  
        Application.launch(UnexcutedOrder.class, args);  
    }  
      
    @Override  
    public void start(Stage stage) throws Exception {  
        Parent root = FXMLLoader.load(getClass().getResource("UnexcutedOrder.fxml"));  
  
        Scene scene = new Scene(root,1000,750);  
        scene.getStylesheets().add(UnexcutedOrder.class.getResource("UnexcutedOrderCSS.css").toExternalForm());
        stage.initStyle(StageStyle.DECORATED);  
        stage.setScene(scene);  
        stage.setTitle("查看未执行订单");  
        stage.show();  
    } 
}
