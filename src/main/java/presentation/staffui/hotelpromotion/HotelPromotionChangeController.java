package presentation.staffui.hotelpromotion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import presentation.utilui.WindowGrab;

public class HotelPromotionChangeController {

    @FXML
    private Button cancel;

    @FXML
    private Button change;

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void change(ActionEvent event) {
    	
    }

}