package presentation.manageui.addhotel;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import bussinesslogic.orderbl.HotelInfo;
import config.StarConfig;
import config.location.City;
import config.location.Field;
import config.location.Province;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;
import vo.hotel.HotelVO;

public class AddHotelController implements Initializable {

	@FXML
	private ComboBox<Integer> star;

	@FXML
	private ComboBox<City> city;
	
	@FXML
	private ComboBox<Province> province;

	@FXML
	private ComboBox<Field> field;

	@FXML
	private ComboBox<String> group;
	
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
		boolean city_check = CheckUtil.checkSelect(city);
		boolean province_check = CheckUtil.checkSelect(province);
		boolean group_check = CheckUtil.checkSelect(group);
		boolean star_check = CheckUtil.checkSelect(star);
		boolean field_check = CheckUtil.checkSelect(field);
		boolean hotelname_check = CheckUtil.checkText(hotel_name);
		boolean address_check = CheckUtil.checkText(address);
		
		return city_check&&province_check&&group_check&&star_check&&field_check&&hotelname_check&&address_check;
	}
	
	

	@FXML
	void nextStep(ActionEvent event) {
		if(checkInputFormater()) {
			//更新缓存
			String group_name = group.getSelectionModel().getSelectedItem();
			String province_name = province.getSelectionModel().getSelectedItem().getProvinceName();
//			HotelVO info = new HotelVO(null, hotel_name.getText(), address.getText(), null, grou, starLevel, score)
			//关闭当前窗口
			WindowGrab.closeWindow(event);
			Stage stage = WindowGrab.getStage(0);
			WindowGrab.startWindow(stage, "完善人员信息", ADD_HOTEL_TWO_FXML, ADD_HOTEL_TWO_CSS);
		}
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



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initView();
		//检查是否已经有数据录入
		if(ViewCache.hotel_info != null) {
			//Init View
			init();
		}
	}
	
	private void initView() {
		province.getItems().addAll(Province.getProvince());
		star.getItems().addAll(StarConfig.STAR_SEPERATE);
	}

	private void init() {
		//Info init
		HotelVO info = ViewCache.hotel_info;
		hotel_name.setText(info.hotelName);
		address.setText(info.address);
		
		//Box init
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
		
		//Clear Unuse Info
		ViewCache.clearHotelCache();
	}

}
