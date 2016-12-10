package presentation.utilcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import presentation.utilui.WindowGrab;

public class CheckController {

	@FXML
	private Label order_status;

	@FXML
	private Label actual_in;

	@FXML
	private Label children;

	@FXML
	private Label expect_leave_time;

	@FXML
	private Button back;

	@FXML
	private Label expect_check_in;

	@FXML
	private Label expect_population;

	@FXML
	private Label actual_out;

	@FXML
	private Label order_id;

	@FXML
	private Label hotel_name;

	@FXML
	private Label last_execute_time;

	@FXML
	void back(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}


}
