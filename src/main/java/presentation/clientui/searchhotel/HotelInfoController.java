package presentation.clientui.searchhotel;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import presentation.utilui.WindowGrab;
import vo.order.OrderVO;

public class HotelInfoController implements Initializable {

	@FXML
	private TableColumn<OrderVO, String> make_time;

	@FXML
	private TableColumn<OrderVO, String> finish_time;

	@FXML
	private TableColumn<OrderVO, String> state;

	@FXML
	private TableView<OrderVO> order_list;

	@FXML
	private TableColumn<OrderVO, String> order_id;

	@FXML
	private ComboBox<String> hotel_field;

	@FXML
	private ComboBox<String> hotel_town;

	@FXML
	private ComboBox<String> hotel_city;

	@FXML
	private ComboBox<String> hotel_province;

	@FXML
	private TextField hotel_star;

	@FXML
	private TextField hotel_id;

	@FXML
	private TextArea hotel_address;

	@FXML
	private TextField hotel_name;

	@FXML
	private Label hotel_maintain_title;

	@FXML
	private TextField hotel_score;

	@FXML
	private Button order;

	@FXML
	private Button check;

	@FXML
	private Button cancel;

	@FXML
	void check(ActionEvent event) {

	}

	@FXML
	void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

	@FXML
	void order(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
