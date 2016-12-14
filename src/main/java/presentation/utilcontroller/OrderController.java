package presentation.utilcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import presentation.utilui.WindowGrab;
import vo.order.OrderVO;

public class OrderController implements Initializable {

	@FXML
	private Label make_time;

	@FXML
	private Button back;

	@FXML
	private Label expect_check_in;

	@FXML
	private Label actual_out;

	@FXML
	private Label finish_time;

	@FXML
	private Label hotel_name;

	@FXML
	private Label order_status;

	@FXML
	private Label people_num;

	@FXML
	private Label actual_in;

	@FXML
	private Label children;

	@FXML
	private Label expect_leave_time;

	@FXML
	private Label order_id;

	@FXML
	private Label last_execute_time;

	@FXML
	void back(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		OrderVO order_info = (OrderVO) resources.getObject("info");
	}

}
