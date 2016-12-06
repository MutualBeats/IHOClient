package presentation.manageui.change;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import presentation.utilui.WindowGrab;

public class IDInputController {

    @FXML
    private Button cancel;

    @FXML
    private Button search;

    @FXML
    void on_search(ActionEvent event) {

    }

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

}
