package presentation.manageui.addhotel;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import presentation.utilcontroller.LocationBoxController;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;
import vo.hotel.HotelVO;

public class AddHotelController extends LocationBoxController {

	@FXML
	private TextField address;

	@FXML
	private TextField hotel_name;

	@FXML
	private Label address_warning;

	@FXML
	private Label field_warning;

	@FXML
	private Label group_warning;

	@FXML
	private Button cancel;

	@FXML
	private Button next_step;

	@FXML
	private Label city_warning;

	@FXML
	private Label province_warning;

	@FXML
	private AnchorPane first_pane;

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
		boolean city_check = checkCitySelect();
		boolean province_check = checkProvinceSelect();
		boolean group_check = checkGroupSelect();
		boolean star_check = checkStarSelect();
		boolean field_check = checkFieldSelect();
		boolean hotelname_check = checkHotelName();
		boolean address_check = checkAddressName();

		return city_check && province_check && group_check && star_check && field_check && hotelname_check
				&& address_check;
	}

	private boolean checkHotelName() {
		boolean fill = CheckUtil.checkText(hotel_name);
		if (!fill) {
			name_warning.setText("请填写酒店名称");
		}
		return fill;
	}

	private boolean checkAddressName() {
		boolean fill = CheckUtil.checkText(address);
		if (!fill) {
			address_warning.setText("酒店地址");
		}
		return fill;
	}

	private boolean checkStarSelect() {
		boolean select = CheckUtil.checkSelect(star);
		if (!select) {
			star_warning.setText("请选择酒店星级");
		}
		return select;
	}

	private boolean checkProvinceSelect() {
		boolean select = CheckUtil.checkSelect(province);
		if (!select) {
			province_warning.setText("请选择酒店所在省份");
		}
		return select;
	}

	private boolean checkCitySelect() {
		boolean select = CheckUtil.checkSelect(city);
		if (!select) {
			city_warning.setText("请选择酒店所在城市");
		}
		return select;
	}

	private boolean checkGroupSelect() {
		boolean select = CheckUtil.checkSelect(group);
		if (!select) {
			group_warning.setText("请选择酒店所在商圈");
		}
		return select;
	}

	private boolean checkFieldSelect() {
		boolean select = CheckUtil.checkSelect(field);
		if (!select) {
			field_warning.setText("请选择酒店所在地区");
		}
		return select;
	}

	@FXML
	void nextStep(ActionEvent event) {
		if (checkInputFormater()) {
			// 更新缓存
			String group_name = group.getSelectionModel().getSelectedItem();
			String province_name = province.getSelectionModel().getSelectedItem().getProvinceName();
			String city_name = city.getSelectionModel().getSelectedItem().getCity_name();
			String field_name = field.getSelectionModel().getSelectedItem().getField_name();
			String region = province_name + " " + city_name + " " + field_name;
			Integer starLevel = star.getSelectionModel().getSelectedItem();
			HotelVO info = new HotelVO(null, hotel_name.getText(), address.getText(), region, group_name, starLevel, 0);
			ViewCache.initHotel(info);
			// 关闭当前窗口
			Scene curScene = WindowGrab.getScene(event);
			WindowGrab.changeScene(ADD_HOTEL_TWO_FXML, ADD_HOTEL_TWO_CSS, curScene);
		}
	}

	@FXML
	void cancel(ActionEvent event) {
		ViewCache.clearCache();
		WindowGrab.closeWindow(event);
	}

	@FXML
	void nameModify(MouseEvent event) {
		CheckUtil.checkWarningBefore(name_warning);
	}

	@FXML
	void provinceModify(MouseEvent event) {
		CheckUtil.checkWarningBefore(province_warning);
	}

	@FXML
	void cityModify(MouseEvent event) {
		CheckUtil.checkWarningBefore(city_warning);
	}

	@FXML
	void fieldModify(MouseEvent event) {
		CheckUtil.checkWarningBefore(field_warning);
	}

	@FXML
	void groupModify(MouseEvent event) {
		CheckUtil.checkWarningBefore(group_warning);
	}

	@FXML
	void addressModify(MouseEvent event) {
		CheckUtil.checkWarningBefore(address_warning);
	}

	@FXML
	void starModify(MouseEvent event) {
		CheckUtil.checkWarningBefore(star_warning);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
		// 检查是否已经有数据录入
		if (ViewCache.hotel_info != null) {
			// Init View
			System.out.println("Here");
			init();
		}
	}

	private void init() {
		// Info init
		HotelVO info = ViewCache.hotel_info;
		hotel_name.setText(info.hotelName);
		address.setText(info.address);

		// Box init
		int province_id = ViewCache.province_index;
		int city_id = ViewCache.city_index;
		int field_id = ViewCache.field_index;
		int group_id = ViewCache.group_index;
		int star_id = ViewCache.star_index;
		province.getSelectionModel().select(province_id);
		city.getSelectionModel().select(city_id);
		field.getSelectionModel().select(field_id);
		group.getSelectionModel().select(group_id);
		star.getSelectionModel().select(star_id);
	}

}
