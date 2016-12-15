package presentation.clientui.searchhotel;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.hotelbl.Hotel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.utilui.WindowGrab;
import vo.hotel.HotelVO;

public class HistoryController implements Initializable{

	@FXML
	private Button cancel;

	@FXML
	private TableView<HotelVO> hotel_list;

	@FXML
	private TableColumn<HotelVO, String> province;

	@FXML
	private TableColumn<HotelVO, String> field;

	@FXML
	private TableColumn<HotelVO, String> city;

	@FXML
	private TableColumn<HotelVO, String> name;

	@FXML
	private TableColumn<HotelVO, String> group;

	@FXML
	private Button info_look;

	@FXML
	private Label title;

	private static URL CHECK_FXML;
	private static URL CHECK_CSS;

	private static URL CLIENTMENU_FXML;
	private static URL CLIENTMENU_CSS;

	static {

		try {

			CHECK_FXML = new URL("file:src/main/resources/ui/clientui/fxml/check.fxml");
			CHECK_CSS = new URL("file:src/main/resources/ui/clientui/css/check.css");

			CLIENTMENU_FXML = new URL("file:src/main/resources/ui/clientui/fxml/clientmenu.fxml");
			CLIENTMENU_CSS = new URL("file:src/main/resources/ui/clientui/css/clientmenu.css");

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void info_look(ActionEvent event) {
		
	}

	@FXML
	void cancel(ActionEvent event) {
		Scene frame = WindowGrab.getScene(event);
		WindowGrab.changeScene(CLIENTMENU_FXML, CLIENTMENU_CSS, frame);
//		Stage stage = WindowGrab.getStage(0);
//		stage.setTitle("Client Menu");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		@SuppressWarnings("unchecked")
		ArrayList<HotelVO> hotel_info = (ArrayList<HotelVO>) resources.getObject("hotel_list");
		hotel_list.getItems().addAll(hotel_info);
		
		province.setCellValueFactory(cellData->cellData.getValue().getProvince_property());
		city.setCellValueFactory(cellData->cellData.getValue().getCity_property());
		field.setCellValueFactory(cellData->cellData.getValue().getField_property());
		group.setCellValueFactory(cellData->cellData.getValue().getGroup_property());
		name.setCellValueFactory(cellData->cellData.getValue().getName_property());
	}
}
