package presentation.manageui.addhotel;

import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;

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
	
	private boolean checkInputFormater() {
		boolean city_check = CheckUtil.checkSelect(city);
		boolean province_check = CheckUtil.checkSelect(province);
		boolean group_check = CheckUtil.checkSelect(group);
		boolean star_check = CheckUtil.checkSelect(star);
		boolean field_check = CheckUtil.checkSelect(field);
		boolean hotelname_check = hotel_name.getText().length() == 0;
		
		return false;
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
		CheckUtil.checkWarningBefore(name_warning);
	}

	@FXML
	void provinceModify(ActionEvent event) {
		CheckUtil.checkWarningBefore(province_warning);
	}

	@FXML
	void cityModify(ActionEvent event) {
		CheckUtil.checkWarningBefore(city_warning);
	}

	@FXML
	void fieldModify(ActionEvent event) {
		CheckUtil.checkWarningBefore(field_warning);
	}

	@FXML
	void groupModify(ActionEvent event) {
		CheckUtil.checkWarningBefore(group_warning);
	}

	@FXML
	void addressModify(ActionEvent event) {
		CheckUtil.checkWarningBefore(address_warning);
	}

	@FXML
	void starModify(ActionEvent event) {
		CheckUtil.checkWarningBefore(star_warning);
	}
	

}
