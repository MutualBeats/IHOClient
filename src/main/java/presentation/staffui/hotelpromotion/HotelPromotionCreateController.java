package presentation.staffui.hotelpromotion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import presentation.utilui.WindowGrab;

public class HotelPromotionCreateController {

    @FXML
    private Button cancel;

    @FXML
    private Button confirm;

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void confirm(ActionEvent event) {
    	
    }

}