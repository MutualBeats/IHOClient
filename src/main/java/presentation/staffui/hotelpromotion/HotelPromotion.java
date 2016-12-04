/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.staffui.hotelpromotion;

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
public class HotelPromotion extends Application {
    
         
     public static void main(String[] args) {  
        Application.launch(HotelPromotion.class, args);  
    }  
      
    @Override  
    public void start(Stage stage) throws Exception {  
        Parent root = FXMLLoader.load(URLConfig.staff_hotel_promotion_fxml_url());  
        Scene scene = new Scene(root,1000, 750);  
        scene.getStylesheets().add(URLConfig.staff_hotel_promotion_css_url().toExternalForm());
        stage.initStyle(StageStyle.DECORATED);  
        stage.setScene(scene);  
        stage.setTitle("制定酒店促销策略");  
        stage.show();  
    }  
    
}
