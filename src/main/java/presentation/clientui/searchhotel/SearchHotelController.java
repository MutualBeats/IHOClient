package presentation.clientui.searchhotel;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import config.location.Province;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import presentation.bundle.HotelInfoBundle;
import presentation.utilcontroller.LocationBoxController;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;
import util.UserCache;
import util.exception.NetException;
import vo.hotel.HotelVO;
import vo.order.OrderVO;

public class SearchHotelController extends LocationBoxController implements Initializable {

	@FXML
	private Label title;

	@FXML
	private Button search;

	@FXML
	private Button back;

	@FXML
	private Button info_look;

	@FXML
	private ComboBox<String> room_type;

	@FXML
	private TextField hotel_name;

	@FXML
	private DatePicker es_in;

	@FXML
	private DatePicker es_leave;

	@FXML
	private TextField score;

	@FXML
	private TextField low_price;

	@FXML
	private TextField hi_price;

	@FXML
	private TableView<HotelVO> hotel_list;

	@FXML
	private TableColumn<HotelVO, String> hotel_name_col;

	@FXML
	private TableColumn<HotelVO, String> province_col;

	@FXML
	private TableColumn<HotelVO, String> field_col;

	@FXML
	private TableColumn<HotelVO, String> city_col;

	@FXML
	private TableColumn<HotelVO, String> group_col;

	@FXML
	private TableColumn<HotelVO, String> star_col;

	@FXML
	private TableColumn<HotelVO, String> score_col;

	@FXML
	private TableColumn<HotelVO, String> book_before;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
	}

	private static URL HOTEL_FXML;
	private static URL HOTEL_CSS;

	private static URL CLIENTMENU_FXML;
	private static URL CLIENTMENU_CSS;

	static {
		try {
			HOTEL_FXML = new URL("file:src/main/resources/ui/clientui/fxml/hotel_info.fxml");
			HOTEL_CSS = new URL("file:src/main/resources/ui/clientui/css/hotel_info.css");
			CLIENTMENU_FXML = new URL("file:src/main/resources/ui/clientui/fxml/clientmenu.fxml");
			CLIENTMENU_CSS = new URL("file:src/main/resources/ui/clientui/css/clientmenu.css");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void info_look(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		if (CheckUtil.checkSelect(hotel_list)) {
			HotelVO hotel = hotel_list.getSelectionModel().getSelectedItem();
			try {
				ArrayList<OrderVO> order_list = ControllerFactory.getOrderBLServiceInstance()
						.queryOrderByHotel(hotel.hotelID, UserCache.getID());
				HotelInfoBundle bundle = new HotelInfoBundle(hotel, order_list);
				WindowGrab.startWindowWithBundle(window, "", HOTEL_FXML, HOTEL_CSS, bundle);
			} catch (NetException e) {
				WindowGrab.startNetErrorWindow(window);
			}
		} else {
			WindowGrab.startNoticeWindow(window, "请选择你要查看的酒店信息");
		}
	}

	@FXML
	void back(ActionEvent event) {
		Scene frame = WindowGrab.getScene(event);
		WindowGrab.changeScene(CLIENTMENU_FXML, CLIENTMENU_CSS, frame);
	}

}
