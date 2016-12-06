package presentation.marketui.webpromotion;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import presentation.utilui.WindowGrab;

public class SpecialDiscountController {

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

