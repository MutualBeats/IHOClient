package presentation.staffui.hotelpromotion;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HotelPromotionLookController implements Initializable {

    @FXML
    private Button cancel;

    @FXML
    private Label end_date;

    @FXML
    private Label promotion_type;

    @FXML
    private Label promotion_name;

    @FXML
    private Label promotion_ID;

    @FXML
    private Label hotel_name;

    @FXML
    private Label start_date;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

    @FXML
    void cancel(ActionEvent event) {

    }

}
