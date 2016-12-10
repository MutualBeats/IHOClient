package presentation.clientui.browseorder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;
import util.order.OrderState;
import vo.order.OrderVO;

public class BrowseOrderController implements Initializable {
	@FXML
	private TableColumn<OrderVO, String> make_time;

	@FXML
	private TableColumn<OrderVO, String> finish_time;

	@FXML
	private TableColumn<OrderVO, String> hotel;

	@FXML
	private TableColumn<OrderVO, OrderState> state;

	@FXML
	private TableColumn<OrderVO, String> order_id;

	@FXML
	private Button executed_order;

	@FXML
	private Button back;

	@FXML
	private Button revoke;

	@FXML
	private Button all_order;

	@FXML
	private Button check;

	@FXML
	private Label title;

	@FXML
	private Button revoked_order;

	@FXML
	private Button unusual_order;

	@FXML
	private Button unexecuted_order;

	private static URL CHECK_FXML;
	private static URL CHECK_CSS;

	private static URL EXECUTE_CHECK_FXML;
	private static URL EXECUTE_CHECK_CSS;

	private static URL CLIENTMENU_FXML;
	private static URL CLIENTMENU_CSS;

	static {
		try {

			CHECK_FXML = new URL("file:src/main/resources/ui/utilui/fxml/check.fxml");
			CHECK_CSS = new URL("file:src/main/resources/ui/clientui/css/check.css");

			CLIENTMENU_FXML = new URL("file:src/main/resources/ui/clientui/fxml/clientmenu.fxml");
			CLIENTMENU_CSS = new URL("file:src/main/resources/ui/clientui/css/clientmenu.css");

			EXECUTE_CHECK_FXML = new URL("file:src/main/resources/ui/clientui/fxml/executed_check.fxml");
			EXECUTE_CHECK_CSS = new URL("file:src/main/resources/ui/clientui/css/executed_check.css");

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	void all_order(ActionEvent event) {

	}

	@FXML
	void executed_order(ActionEvent event) {

	}

	@FXML
	void unexecuted_order(ActionEvent event) {

	}

	@FXML
	void revoked_order(ActionEvent event) {

	}

	@FXML
	void unusual_order(ActionEvent event) {

	}

	@FXML
	void check(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, "查看订单详情", CHECK_FXML, CHECK_CSS);
	}

	@FXML
	void back(ActionEvent event) {
		Scene frame = WindowGrab.getScene(event);
		WindowGrab.changeScene(CLIENTMENU_FXML, CLIENTMENU_CSS, frame);
		Stage stage = WindowGrab.getStage(0);
		stage.setTitle("Client Menu");
	}

	@FXML
	void unexecuted_revoke(ActionEvent event) {

	}

	@FXML
	void executed_check(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, "查看订单详情", EXECUTE_CHECK_FXML, EXECUTE_CHECK_CSS);

	}

}
