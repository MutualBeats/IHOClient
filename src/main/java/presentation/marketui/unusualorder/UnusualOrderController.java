package presentation.marketui.unusualorder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Window;
import presentation.bundle.PromotionBundle;
import presentation.bundle.SingleOrderListBundle;
import presentation.marketui.credit.CreditIDInputHandle;
import presentation.marketui.utilui.OrderListView;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Order;
import vo.order.OrderVO;
import vo.promotion.PromotionVO;

public class UnusualOrderController extends OrderListView implements Initializable, ChooseCredit {

	@FXML
	private Button revoke;

	@FXML
	private TableColumn<OrderVO, String> user_name;

	@FXML
	private TableColumn<OrderVO, String> contact;

	@FXML
	private Button web_promotion;

	@FXML
	private Button unusual_order;

	@FXML
	private Button unexecuted_order;

	@FXML
	private TableColumn<OrderVO, String> order_id;

	@FXML
	private TableView<OrderVO> order_list;

	@FXML
	private Label unusualorder_title;

	@FXML
	private TableColumn<OrderVO, String> hotelname;

	@FXML
	private Button credit;

	@FXML
	private Button peopleInfo;
	
	@FXML
    private Pane pane;

	private ObservableList<OrderVO> unusual_orderlist;
	final ToggleGroup buttom_group = new ToggleGroup();

	private static URL APPEAL_FXML;
	private static URL APPEAL_CSS;

	private static URL UNEXCUTED_ORDER_FXML;
	private static URL UNEXCUTED_ORDER_CSS;

	private static URL WEB_PROMOTION_FXML;
	private static URL WEB_PROMOTION_CSS;

	private static URL MENU_FXML;
	private static URL MENU_CSS;

	static {
		try {
			APPEAL_FXML = new URL("file:src/main/resources/ui/marketui/fxml/appeal_credit.fxml");
			APPEAL_CSS = new URL("file:src/main/resources/ui/marketui/css/appeal_credit.css");

			WEB_PROMOTION_FXML = new URL("file:src/main/resources/ui/marketui/fxml/web_promotion.fxml");
			WEB_PROMOTION_CSS = new URL("file:src/main/resources/ui/marketui/css/web_promotion.css");

			UNEXCUTED_ORDER_FXML = new URL("file:src/main/resources/ui/marketui/fxml/unexecuted_order.fxml");
			UNEXCUTED_ORDER_CSS = new URL("file:src/main/resources/ui/marketui/css/unexecuted_order.css");

			MENU_FXML = new URL("file:src/main/resources/ui/marketui/fxml/marketmenu.fxml");
			MENU_CSS = new URL("file:src/main/resources/ui/marketui/css/marketmenu.css");

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ArrayList<OrderVO> unusual = (ArrayList<OrderVO>) resources.getObject("order_list");

		unusual_orderlist = FXCollections.observableArrayList();
		unusual_orderlist.addAll(unusual);
		order_list.setItems(unusual_orderlist);

		initColumn();
	}

	private void initColumn() {
		order_id.setCellValueFactory(celldata -> celldata.getValue().getId_property());

		user_name.setCellValueFactory(cellData -> {
			try {
				return ControllerFactory.getClientBLServiceInstance().getClientInfo(cellData.getValue().clientID)
						.getName_property();
			} catch (NetException e) {
				return new SimpleStringProperty("");
			}
		});

		contact.setCellValueFactory(celldata -> {
			try {
				return ControllerFactory.getClientBLServiceInstance().getClientInfo(celldata.getValue().clientID)
						.getContact_property();
			} catch (NetException e) {
				return new SimpleStringProperty("");
			}
		});

		hotelname.setCellValueFactory(celldata -> {
			try {
				return new SimpleStringProperty(ControllerFactory.getHotelBLServiceInstance()
						.showHotelInfo(celldata.getValue().getHotel_property().getValue()).hotelName);
			} catch (NetException e) {
				return new SimpleStringProperty("");
			}
		});
	}

	@FXML
	void on_revoke(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		if (CheckUtil.checkSelect(order_list)) {
			// Revoke Order
			WindowGrab.startWindowWithBundle(window, "恢复信用值", APPEAL_FXML, APPEAL_CSS, new ChooseBundle(this));
		} else {
			WindowGrab.startNoticeWindow(window, "请选择要撤销的订单");
		}
	}

	public void choose(boolean all) {
		Window window = WindowGrab.getWindowByStage(0);

		String order_ID = order_list.getSelectionModel().getSelectedItem().orderID;
		ResultMessage_Order result = ResultMessage_Order.Appeal_Successful;
		System.out.println(order_ID);
		try {
			result = ControllerFactory.getOrderBLServiceInstance().appeal(order_ID, all);
		} catch (NetException e) {
			// TODO Auto-generated catch block
			WindowGrab.startNetErrorWindow(window);
			return;
		}
		if (result == ResultMessage_Order.Appeal_Successful) {
			WindowGrab.startNoticeWindow(window, "撤销订单成功！");
		} else {
			WindowGrab.startNoticeWindow(window, "撤销订单失败！");

		}

	}

	@FXML
	void unexecuted_order(ActionEvent event) {
		Scene frame = WindowGrab.getScene(event);
		ArrayList<OrderVO> order_info = null;
		try {
			order_info = ControllerFactory.getOrderBLServiceInstance().queryUnexecutedOrder(util.Time.getCurrentDate());
		} catch (NetException e) {
			Window window = WindowGrab.getWindow(event);
			WindowGrab.startNetErrorWindow(window);
		}
		ResourceBundle bundle = new SingleOrderListBundle(order_info);
		WindowGrab.changeSceneWithBundle(UNEXCUTED_ORDER_FXML, UNEXCUTED_ORDER_CSS, frame, bundle);

	}

	@FXML
	void web_promotion(ActionEvent event) {
		Scene frame = WindowGrab.getScene(event);
		ArrayList<PromotionVO> promotionList = null;
		try {
			promotionList = ControllerFactory.getPromotionBLServiceInstance().getWebPromotion();
		} catch (NetException e) {
			Window window = WindowGrab.getWindow(event);
			WindowGrab.startNetErrorWindow(window);
		}
		ResourceBundle bundle = new PromotionBundle(promotionList);
		WindowGrab.changeSceneWithBundle(WEB_PROMOTION_FXML, WEB_PROMOTION_CSS, frame, bundle);

	}

	@FXML
	void on_credit(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		WindowGrab.startIDInputWindow(window, new CreditIDInputHandle());
	}

	@FXML
	void peopleInfo(ActionEvent event) {
		WindowGrab.changeScene(MENU_FXML, MENU_CSS, event);
	}

}
