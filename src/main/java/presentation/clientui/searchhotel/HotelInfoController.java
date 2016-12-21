package presentation.clientui.searchhotel;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
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
import javafx.stage.Window;
import presentation.bundle.OrderInfoBundle;
import presentation.clientui.utilui.ViewUtil;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;
import util.exception.NetException;
import vo.hotel.HotelVO;
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
	private ComboBox<String> hotel_group;

	@FXML
	private ComboBox<String> hotel_city;

	@FXML
	private ComboBox<String> hotel_province;

	@FXML
	private ComboBox<Integer> hotel_star;

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
	private Button back;

	private HotelVO hotel_info;
	
	@FXML
    private Button check_evaluate;

	private static URL CHECK_FXML;
	private static URL CHECK_CSS;
//
//	private static URL MAKEORDER_FXML;
//	private static URL MAKEORDER_CSS;

	static {
		try {

			CHECK_FXML = new URL("file:src/main/resources/ui/utilui/fxml/order_information.fxml");
			CHECK_CSS = new URL("file:src/main/resources/ui/utilui/css/order_information.css");

//			MAKEORDER_FXML = new URL("file:src/main/resources/ui/clientui/fxml/makeorder.fxml");
//			MAKEORDER_CSS = new URL("file:src/main/resources/ui/clientui/css/makeorder.css");

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void check(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		if (CheckUtil.checkSelect(order_list)) {
			OrderVO vo = order_list.getSelectionModel().getSelectedItem();
			try {
				String promotion_name = ControllerFactory.getPromotionBLServiceInstance()
						.getPromotionById(vo.promotionIDList.get(0)).promotionName;
				OrderInfoBundle bundle = new OrderInfoBundle(vo, hotel_name.getText(), promotion_name);
				WindowGrab.startWindowWithBundle(window, "订单详情", CHECK_FXML, CHECK_CSS, bundle);
			} catch (NetException e) {
				WindowGrab.startNetErrorWindow(window);
			}

		} else {
			WindowGrab.startNoticeWindow(window, "请选择要查看的订单");
		}
	}

	@FXML
	void back(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

	@FXML
	void order(ActionEvent event) {
		WindowGrab.closeWindow(event);
		Window window = WindowGrab.getWindowByStage(0);
		ViewUtil.orderMake(hotel_info, window);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		hotel_info = (HotelVO) resources.getObject("hotel");
		@SuppressWarnings("unchecked")
		ArrayList<OrderVO> orderList = (ArrayList<OrderVO>) resources.getObject("order_list");

		String locate[] = hotel_info.region.split("\\s");
		System.out.println(hotel_info.region);
		System.out.println(locate.length);
		hotel_province.getItems().add(locate[0]);
		hotel_province.getSelectionModel().select(0);
		hotel_city.getItems().add(locate[1]);
		hotel_city.getSelectionModel().select(0);
		hotel_field.getItems().add(locate[2]);
		hotel_field.getSelectionModel().select(0);
		hotel_group.getItems().add(hotel_info.businessDistrict);
		hotel_group.getSelectionModel().select(0);
		hotel_star.getItems().add(hotel_info.starLevel);
		hotel_star.getSelectionModel().select(0);
		hotel_id.setText(hotel_info.hotelID);
		hotel_address.setText(hotel_info.address);
		hotel_name.setText(hotel_info.hotelName);
		hotel_score.setText(hotel_info.score + "");

		order_list.getItems().addAll(orderList);

		make_time.setCellValueFactory(cellData -> cellData.getValue().getMake_time_property());
		finish_time.setCellValueFactory(cellData -> cellData.getValue().getFinish_time_property());
		state.setCellValueFactory(cellData -> cellData.getValue().getState_property());
		order_id.setCellValueFactory(cellData -> cellData.getValue().getId_property());
	}

}
