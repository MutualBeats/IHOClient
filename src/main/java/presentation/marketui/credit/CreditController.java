package presentation.marketui.credit;

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
import presentation.utilui.WindowGrab;

public class CreditController {

    @FXML
    private Button cancel;

    @FXML
    private Button search;

    @FXML
    private Button excute;
    
    Stage stage=new Stage();


    @FXML
    void excute(ActionEvent event) {
        
    }

    @FXML
    void search(ActionEvent event) {
        
    }
    
    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

}
