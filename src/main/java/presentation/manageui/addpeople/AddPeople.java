/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.manageui.addpeople;

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
public class AddPeople extends Application {
	
//    public static void main(String[] args) {  
//        Application.launch(AddPeople.class, args);  
//    }  
	

    @Override  
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("addpeople.fxml"));  
  
        Scene scene = new Scene(root, 460 , 475);  
        scene.getStylesheets().add(AddPeople.class.getResource("addpeople.css").toExternalForm());
        stage.initStyle(StageStyle.DECORATED);  
        stage.setScene(scene);  
        stage.setTitle("添加人员");  
        stage.show();  
    }  

}
