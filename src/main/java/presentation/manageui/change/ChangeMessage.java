/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.manageui.change;

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
public class ChangeMessage extends Application {


	public static Stage stage;
    @Override  
    public void start(Stage stage) throws Exception { 
    	this.stage=stage;
        Parent root = FXMLLoader.load(getClass().getResource("changemessage.fxml"));  
  
        Scene scene = new Scene(root, 460 , 475);  
        scene.getStylesheets().add(ChangeMessage.class.getResource("changemessageCSS.css").toExternalForm());
        stage.initStyle(StageStyle.DECORATED);  
        stage.setScene(scene);  
        stage.setTitle("修改人员信息");  
        stage.show();  
    }  

}
