package presentation.clientui.searchhotel;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Window;
import presentation.clientui.utilui.SearchView;
import presentation.clientui.utilui.ViewUtil;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;
import vo.hotel.HotelVO;

/**
 * 
 * 搜索酒店界面控制器
 * 
 * @author heleninsa
 *
 */
public class SearchHotelController extends SearchView {

	@FXML
	private Button back;

	@FXML
	private Button info_look;

	@FXML
	private Button make_order;

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
	private TableColumn<HotelVO, Integer> star_col;

	@FXML
	private TableColumn<HotelVO, Double> score_col;

	@FXML
	private TableColumn<HotelVO, String> book_before;

//	private static URL HOTEL_FXML;
//	private static URL HOTEL_CSS;

	private static URL CLIENTMENU_FXML;
	private static URL CLIENTMENU_CSS;
//
//	private static URL MAKEORDER_FXML;
//	private static URL MAKEORDER_CSS;

	static {
		try {
//			HOTEL_FXML = new URL("file:src/main/resources/ui/clientui/fxml/hotel_info.fxml");
//			HOTEL_CSS = new URL("file:src/main/resources/ui/clientui/css/hotel_info.css");
			CLIENTMENU_FXML = new URL("file:src/main/resources/ui/clientui/fxml/clientmenu.fxml");
			CLIENTMENU_CSS = new URL("file:src/main/resources/ui/clientui/css/clientmenu.css");
//			MAKEORDER_FXML = new URL("file:src/main/resources/ui/clientui/fxml/makeorder.fxml");
//			MAKEORDER_CSS = new URL("file:src/main/resources/ui/clientui/css/makeorder.css");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
		@SuppressWarnings("unchecked")
		ArrayList<HotelVO> hotel_info = (ArrayList<HotelVO>) resources.getObject("hotel_list");
		hotel_list.getItems().addAll(hotel_info);
		province_col.setCellValueFactory(cellData -> cellData.getValue().getProvince_property());
		city_col.setCellValueFactory(cellData -> cellData.getValue().getCity_property());
		field_col.setCellValueFactory(cellData -> cellData.getValue().getField_property());
		group_col.setCellValueFactory(cellData -> cellData.getValue().getGroup_property());
		hotel_name_col.setCellValueFactory(cellData -> cellData.getValue().getName_property());
		star_col.setCellValueFactory(cellData -> cellData.getValue().getStar_property().asObject());
		score_col.setCellValueFactory(cellData -> cellData.getValue().getScore_property().asObject());
		book_before.setCellValueFactory(cellData -> cellData.getValue().getBook_before());
	}

	@FXML
	void info_look(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		if (CheckUtil.checkSelect(hotel_list)) {
			HotelVO hotel = hotel_list.getSelectionModel().getSelectedItem();
			ViewUtil.showHotelInfo(hotel, window);
		} else {
			WindowGrab.startNoticeWindow(window, "请选择你要查看的酒店信息");
		}
	}

	@FXML
	void back(ActionEvent event) {
		Scene frame = WindowGrab.getScene(event);
		WindowGrab.changeScene(CLIENTMENU_FXML, CLIENTMENU_CSS, frame);
	}

	@FXML
	void make_order(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		boolean select = CheckUtil.checkSelect(hotel_list);
		if (select) {
			HotelVO hotel_info = hotel_list.getSelectionModel().getSelectedItem();
			ViewUtil.orderMake(hotel_info, window);
		} else {
			WindowGrab.startNoticeWindow(window, "请选择要下单的酒店。");
		}
	}

	public void handle(ArrayList<HotelVO> hotel_vos) {
		hotel_list.getItems().clear();
		hotel_list.getItems().addAll(hotel_vos);
	}

}
