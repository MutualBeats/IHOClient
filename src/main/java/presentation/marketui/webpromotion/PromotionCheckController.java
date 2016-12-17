package presentation.marketui.webpromotion;


import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;
import util.exception.NetException;

public class PromotionCheckController {

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
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void promotion_ID(ActionEvent event) {
    	promotion_ID.setText();
    }

    @FXML
    void promotion_name(ActionEvent event) {
    	promotion_name.setText();
    }

    @FXML
    void time_start(ActionEvent event) {
    	time_start.setText();
    }

    @FXML
    void time_end(ActionEvent event) {
    	time_end.setText();
    }

    @FXML
    void discount(ActionEvent event) {
    	try {
			discount.setText();
		} catch (NetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}

