/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.staffui.roommanage;

import config.URLConfig;
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
public class RoomManage extends Application {
    
    public static void main(String[] args) {  
        Application.launch(RoomManage.class, args);  
    }  
      
    @Override  
    public void start(Stage stage) throws Exception {  
        Parent root = FXMLLoader.load(URLConfig.staff_room_manage_fxml_url());  
        Scene scene = new Scene(root,750, 550);  
        scene.getStylesheets().add(URLConfig.staff_room_manage_css_url().toExternalForm());
        stage.initStyle(StageStyle.DECORATED);  
        stage.setScene(scene);  
        stage.setTitle("更新客房信息");  
        stage.show();  
    }  
    
}
