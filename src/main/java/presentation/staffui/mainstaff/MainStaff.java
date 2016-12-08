/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.staffui.mainstaff;

import config.urlconfig.StaffUIURLConfig;
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
public class MainStaff extends Application {

     public static void main(String[] args) {  
        Application.launch(args);  
    }  
      
    @Override  
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(StaffUIURLConfig.staff_main_fxml_url());  
  
        Scene scene = new Scene(root,800, 600);  
        scene.getStylesheets().add(StaffUIURLConfig.staff_main_css_url().toExternalForm());
        stage.initStyle(StageStyle.DECORATED); 
        stage.setScene(scene);  
        stage.setTitle("Staff Menu");  
        stage.show();  
        
    }

}
