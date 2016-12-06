package presentation.marketui.unusualorder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import presentation.utilui.WindowGrab;

public class UnusualOrderController {

    @FXML
    private Label unusualorder_title;

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void check(ActionEvent event) {

    }

    @FXML
    void on_search(ActionEvent event) {

    }
}
