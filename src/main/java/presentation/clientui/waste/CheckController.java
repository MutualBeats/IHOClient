package presentation.clientui.waste;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import presentation.utilui.WindowGrab;

public class CheckController {

	@FXML
    private Label order_status;

    @FXML
    private Button return_;

    @FXML
    private Label order_id7;

    @FXML
    private Label expect_leave_time;

    @FXML
    private Label expect_check_in;

    @FXML
    private Label expect_population;

    @FXML
    private Label order_id;

    @FXML
    private Label hotel_name;


    @FXML
    void return_(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

}
