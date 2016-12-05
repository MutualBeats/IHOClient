package presentation.marketerui.mainmarket;

import config.URLConfig;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainMarket {
    public static void main(String[] args) {  
        Application.launch(args);  
    }  
      
    public void start(Stage stage) throws Exception {
    	
        Parent root = FXMLLoader.load(URLConfig.staff_main_fxml_url());  
        Scene scene = new Scene(root,800, 600);  
        scene.getStylesheets().add(URLConfig.staff_main_css_url().toExternalForm());
        stage.initStyle(StageStyle.DECORATED); 
        stage.setScene(scene);  
        stage.setTitle("Market Menu");  
        stage.show();  
        
    }

}
