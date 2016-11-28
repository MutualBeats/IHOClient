package presentation.marketerui.Credit;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CreditController {

    @FXML
    private Button cancel;

    @FXML
    private Button search;

    @FXML
    private Button excute;
    
    Stage stage=new Stage();

    @FXML
    void fffbe5(ActionEvent event) {

    }

    @FXML
    void bfbe97(ActionEvent event) {

    }

    @FXML
    void bfe5a5(ActionEvent event) {

    }

    @FXML
    void c3ba84(ActionEvent event) {

    }

    @FXML
    void cancel(ActionEvent event) {
        System.out.println("Cancel !");
    }

    @FXML
    void excute(ActionEvent event) {
        try {  
                Parent root = FXMLLoader.load(getClass().getResource("newCredit.fxml")); 
                Scene scene = new Scene(root,460, 475);
                scene.getStylesheets().add(Credit.class.getResource("newCreditCSS.css").toExternalForm());
                stage.initStyle(StageStyle.DECORATED);  
                stage.setScene(scene);  
                stage.setTitle("充值信用");  
                stage.show();
                
            } catch (IOException ex) {
                Logger.getLogger(Credit.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    void search(ActionEvent event) {
        
    }

}
