package presentation.manageui.addhotel;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;
import vo.hotel.HotelVO;

public class AddHotelController {

	@FXML
	private TextField address;

	@FXML
	private ComboBox<?> star;

	@FXML
	private ComboBox<?> city;

	@FXML
	private Label address_warning;

	@FXML
	private TextField hotel_name;

	@FXML
	private Label field_warning;

	@FXML
	private Label group_warning;

	@FXML
	private Button cancel;

	@FXML
	private ComboBox<?> province;

	@FXML
	private ComboBox<?> field;

	@FXML
	private Button next_step;

	@FXML
	private Label city_warning;

	@FXML
	private Label province_warning;

	@FXML
	private AnchorPane first_pane;

	@FXML
	private ComboBox<?> group;

	@FXML
	private Label name_warning;

	@FXML
	private Label star_warning;

	private static URL ADD_HOTEL_TWO_FXML;
	private static URL ADD_HOTEL_TWO_CSS;
	static {
		try {
			ADD_HOTEL_TWO_FXML = new URL("file:src/main/resources/ui/manageui/fxml/addhotel_two.fxml");
			ADD_HOTEL_TWO_CSS = new URL("file:src/main/resources/ui/manageui/css/addhotel_two.css");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void nextStep(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, "完善人员信息", ADD_HOTEL_TWO_FXML, ADD_HOTEL_TWO_CSS);
	}

	@FXML
	void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

	@FXML
	void nameModify(ActionEvent event) {

	}

	@FXML
	void provinceModify(ActionEvent event) {

	}

	@FXML
	void cityModify(ActionEvent event) {

	}

	@FXML
	void fieldModify(ActionEvent event) {

	}

	@FXML
	void groupModify(ActionEvent event) {

	}

	@FXML
	void addressModify(ActionEvent event) {

	}

	@FXML
	void starModify(ActionEvent event) {

	}
	
//	class HotelInforBundle extends ResourceBundle {
//
//		private HotelVO hotel_info;
//		
//		private final static String HOTEL_KEY = "hotel_info";
//		
//		@Override
//		protected Object handleGetObject(String key) {
//			if(HOTEL_KEY.equals(key)) {
//				return hotel_info;
//			} else {
//				return null;
//			}
//		}
//
//		@Override
//		public Enumeration<String> getKeys() {
//			return null;
//		}
//		
//	}

}
