package presentation.marketui.utilui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import presentation.utilui.WindowGrab;
import vo.order.OrderVO;

public abstract class OrderListView implements Initializable {

	@FXML
	private Label unexcuted_order_title;

	@FXML
	private Button cancel;

	@FXML
	private TextField id_text;

	@FXML
	private Button search;

	@FXML
	private Button check;
	
	@FXML
	private TableView<OrderVO> order_list;

	@FXML
	private TableColumn<OrderVO, String> user_name;

	@FXML
	private TableColumn<OrderVO, String> contact;

	@FXML
	private TableColumn<OrderVO, String> id;

	@FXML
	private TableColumn<OrderVO, String> hotelname;

	@FXML
	void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

	@FXML
	void on_check(ActionEvent event) {

	}

	@FXML
	void on_search(ActionEvent event) {

	}

}
