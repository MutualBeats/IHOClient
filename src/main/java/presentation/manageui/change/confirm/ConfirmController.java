package presentation.manageui.change.confirm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ConfirmController {

    @FXML
    private Button confirm;

    @FXML
    private Button cancel;

    @FXML
    void confirm(ActionEvent event) {
    	
    }

    @FXML
    void cancel(ActionEvent event) {
    	Confirm.stage.close();
    }

}
