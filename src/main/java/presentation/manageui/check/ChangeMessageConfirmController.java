package presentation.manageui.check;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import presentation.utilui.WindowGrab;

public class ChangeMessageConfirmController {

    @FXML
    private Button confirm;

    @FXML
    private Button cancel;

    @FXML
    void confirm(ActionEvent event) {
    	InformationLookController.controller.toInfoState();
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

}
