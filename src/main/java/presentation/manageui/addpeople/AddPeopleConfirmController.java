package presentation.manageui.addpeople;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.WindowEvent;
import presentation.utilui.WindowGrab;

public class AddPeopleConfirmController {

    @FXML
    private Button confirm;

    @FXML
    private Button cancel;

    @FXML
    void confirm(ActionEvent event) {
    	
    }

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

}
