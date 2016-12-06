package presentation.marketui.webpromotion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import presentation.utilui.WindowGrab;

public class PromotionChooseController {

    @FXML
    void create(ActionEvent event) {

    }

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

}

