package presentation.staffui.hotelpromotion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import presentation.utilui.WindowGrab;

public class HotelPromotionLookController {

    @FXML
    private Button cancel;

    @FXML
    private Label promotion_name;

    @FXML
    private Label time_start;

    @FXML
    private Label discount;

    @FXML
    private Label promotion_ID;

    @FXML
    private Label time_end;

    @FXML
    private Label hotel_name;

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void promotion_ID(ActionEvent event) {

    }

    @FXML
    void hotel_name(ActionEvent event) {

    }

    @FXML
    void promotion_name(ActionEvent event) {

    }

    @FXML
    void time_start(ActionEvent event) {

    }

    @FXML
    void time_end(ActionEvent event) {

    }

    @FXML
    void discount(ActionEvent event) {

    }

}
