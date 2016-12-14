package presentation.clientui.browseorder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;
import util.Time;
import util.exception.NetException;
import util.order.OrderState;
import util.resultmessage.ResultMessage_Order;
import vo.order.OrderVO;

public class BrowseOrderController implements Initializable {
	@FXML
	private TableColumn<OrderVO, String> make_time;

	@FXML
	private TableColumn<OrderVO, String> finish_time;

	@FXML
	private TableColumn<OrderVO, String> hotel;

	@FXML
	private TableColumn<OrderVO, String> state;

	@FXML
	private TableColumn<OrderVO, String> order_id;

	@FXML
	private TableView<OrderVO> order_list;

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
	private Button exception_order;

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

			CHECK_FXML = new URL("file:src/main/resources/ui/utilui/fxml/order_information.fxml");
			CHECK_CSS = new URL("file:src/main/resources/ui/utilui/css/order_information.css");

			CLIENTMENU_FXML = new URL("file:src/main/resources/ui/clientui/fxml/clientmenu.fxml");
			CLIENTMENU_CSS = new URL("file:src/main/resources/ui/clientui/css/clientmenu.css");

			EXECUTE_CHECK_FXML = new URL("file:src/main/resources/ui/clientui/fxml/executed_check.fxml");
			EXECUTE_CHECK_CSS = new URL("file:src/main/resources/ui/clientui/css/executed_check.css");

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private ObservableList<OrderVO> total_list;
	private ObservableList<OrderVO> executed_list;
	private ObservableList<OrderVO> unexecuted_list;
	private ObservableList<OrderVO> revoked_list;
	private ObservableList<OrderVO> exception_list;

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Initialize order list
		ArrayList<OrderVO> total = (ArrayList<OrderVO>) resources.getObject("total");
		ArrayList<OrderVO> executed = (ArrayList<OrderVO>) resources.getObject("excuted");
		ArrayList<OrderVO> unexecuted = (ArrayList<OrderVO>) resources.getObject("unexecuted");
		ArrayList<OrderVO> revoked = (ArrayList<OrderVO>) resources.getObject("revoked");
		ArrayList<OrderVO> exception = (ArrayList<OrderVO>) resources.getObject("exception");
		total_list.addAll(total);
		executed_list.addAll(executed);
		unexecuted_list.addAll(unexecuted);
		revoked_list.addAll(revoked);
		exception_list.addAll(exception);

		order_list.setItems(total_list);

		// init column
		initColumn();

		// Revoke button default
		revoke.setVisible(false);
		revoke.setDisable(true);

	}

	private void initColumn() {
		make_time.setCellValueFactory(cellData -> cellData.getValue().getMake_time_property());
		finish_time.setCellValueFactory(cellData -> cellData.getValue().getFinish_time_property());
		state.setCellValueFactory(cellData -> cellData.getValue().getState_property());
		order_id.setCellValueFactory(cellData -> cellData.getValue().getId_property());
		// Hotel Name
		hotel.setCellValueFactory(cellData -> {
			try {
				return new SimpleStringProperty(ControllerFactory.getHotelBLServiceInstance()
						.showHotelInfo(cellData.getValue().getHotel_property().getValue()).hotelName);
			} catch (NetException e) {
				WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(0));
				return new SimpleStringProperty("");
			}
		});
	}

	private void hideRevoke() {
		revoke.setVisible(false);
		revoke.setDisable(true);
	}

	@FXML
	void all_order(ActionEvent event) {
		hideRevoke();
		order_list.setItems(total_list);
	}

	@FXML
	void executed_order(ActionEvent event) {
		hideRevoke();
		order_list.setItems(executed_list);
	}

	@FXML
	void unexecuted_order(ActionEvent event) {
		// Represent the button
		revoke.setVisible(true);
		revoke.setDisable(false);
		order_list.setItems(unexecuted_list);
	}

	@FXML
	void revoked_order(ActionEvent event) {
		hideRevoke();
		order_list.setItems(revoked_list);
	}

	@FXML
	void exception_order(ActionEvent event) {
		hideRevoke();
		order_list.setItems(exception_list);
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
	}

	@FXML
	void unexecuted_revoke(ActionEvent event) {
		OrderVO select = order_list.getSelectionModel().getSelectedItem();
		Window window = WindowGrab.getWindow(event);
		if (select != null) {
			try {
				ResultMessage_Order result = ControllerFactory.getOrderBLServiceInstance().cancelOrder("");
				if (result == ResultMessage_Order.Cancel_Successful) {
					WindowGrab.startNoticeWindow(window, "撤销订单成功");
					// 界面暂时更新
					unexecuted_list.remove(select);
					select.setFinishTimeProperty(Time.getCurrentTime());
					select.setStateProperty(OrderState.Canceled);
					revoked_list.add(0, select);

				} else {
					WindowGrab.startNoticeWindow(window, "撤销订单失败");
				}
			} catch (NetException e) {
				WindowGrab.startNetErrorWindow(window);
			}
		} else {
			WindowGrab.startNoticeWindow(window, "请选择要查看的订单");
		}
	}

	@FXML
	void executed_check(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, "查看订单详情", EXECUTE_CHECK_FXML, EXECUTE_CHECK_CSS);

	}

}
