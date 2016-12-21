package presentation.clientui.searchhotel;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Window;
import presentation.clientui.utilui.ViewUtil;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;
import vo.hotel.HotelVO;

public class HotelListController implements Initializable {

	@FXML
	private Button back;

	@FXML
	protected TableView<HotelVO> hotel_list;

	@FXML
	protected TableColumn<HotelVO, String> province;

	@FXML
	protected TableColumn<HotelVO, String> field;

	@FXML
	protected TableColumn<HotelVO, String> city;

	@FXML
	protected TableColumn<HotelVO, String> name;

	@FXML
	protected TableColumn<HotelVO, String> group;

	@FXML
	private Button info_look;

	@FXML
	private Label title;

//	private static URL HOTEL_FXML;
//	private static URL HOTEL_CSS;

	private static URL CLIENTMENU_FXML;
	private static URL CLIENTMENU_CSS;

	static {
		try {
//			HOTEL_FXML = new URL("file:src/main/resources/ui/clientui/fxml/hotel_info.fxml");
//			HOTEL_CSS = new URL("file:src/main/resources/ui/clientui/css/hotel_info.css");
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		@SuppressWarnings("unchecked")
		ArrayList<HotelVO> hotel_info = (ArrayList<HotelVO>) resources.getObject("hotel_list");
		hotel_list.getItems().addAll(hotel_info);

		province.setCellValueFactory(cellData -> cellData.getValue().getProvince_property());
		city.setCellValueFactory(cellData -> cellData.getValue().getCity_property());
		field.setCellValueFactory(cellData -> cellData.getValue().getField_property());
		group.setCellValueFactory(cellData -> cellData.getValue().getGroup_property());
		name.setCellValueFactory(cellData -> cellData.getValue().getName_property());
	}
}
