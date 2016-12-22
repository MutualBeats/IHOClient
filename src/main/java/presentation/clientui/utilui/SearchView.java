package presentation.clientui.utilui;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Window;
import presentation.utilcontroller.LocationBoxController;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;
import util.UserCache;
import util.exception.NetException;
import util.hotel.SearchCondition;
import util.order.OrderState;
import util.room.RoomType;
import vo.hotel.HotelVO;
import vo.order.OrderVO;

/**
 * 
 * 酒店搜索界面
 * 
 * @author heleninsa
 *
 */
public abstract class SearchView extends LocationBoxController implements Initializable {

	@FXML
	private Label title;

	@FXML
	private Button search;

	@FXML
	private RadioButton all;

	@FXML
	private RadioButton history;

	@FXML
	private ComboBox<RoomType> room_type;

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
		CheckUtil.inAndOutDatePickerInit(es_in, es_leave, LocalDate.now(), LocalDate.now());
		room_type.getItems().add(RoomType.Single);
		room_type.getItems().add(RoomType.Double);
		room_type.getItems().add(RoomType.Triple);
		room_type.getItems().add(RoomType.Four);
		ToggleGroup toggle = new ToggleGroup();
		all.setToggleGroup(toggle);
		history.setToggleGroup(toggle);
		all.setSelected(true);
	}

	@FXML
	void on_search(ActionEvent event) {
		boolean pro_sele = CheckUtil.checkSelect(province);
		boolean city_sele = CheckUtil.checkSelect(city);
		boolean field_sele = CheckUtil.checkSelect(field);
		boolean group_sele = CheckUtil.checkSelect(group);

		Window window = WindowGrab.getWindow(event);
		// Must select
		if (pro_sele && city_sele && field_sele && group_sele) {
			SearchCondition condition = create_condition();
			if (condition != null) {
				try {
					ArrayList<HotelVO> hotelVOs = ControllerFactory.getHotelBLServiceInstance()
							.getHotelsSatisfyCondition(condition);
					// 酒店是否曾预定判断
					ArrayList<OrderVO> vos = ControllerFactory.getOrderBLServiceInstance()
							.queryUserOrder(UserCache.getID(), OrderState.All);
					
					Map<String, String> hotel_ids = new HashMap<>();
					for (OrderVO each : vos) {
						String hotelID = each.hotelID;
						if (!hotel_ids.containsKey(hotelID)) {
							hotel_ids.put(hotelID, hotelID);
						}
					}
					
					for (HotelVO each : hotelVOs) {
						each.setBook_before(hotel_ids.containsKey(each.hotelID));
					}

					handle(hotelVOs);
				} catch (NetException e) {
					WindowGrab.startNetErrorWindow(window);
				}
			} else {
				WindowGrab.startNoticeWindow(window, "请输入正整数，并且最低价格应不高于最高价格");
			}
		} else {
			WindowGrab.startNoticeWindow(window, "请选择地址、商圈");
		}

	}

	/**
	 * 生成搜索条件
	 * 
	 * @return 若价格信息错误返回为null
	 */
	private SearchCondition create_condition() {
		String province_name = province.getSelectionModel().getSelectedItem().getProvinceName();
		String city_name = city.getSelectionModel().getSelectedItem().getCity_name();
		String field_name = field.getSelectionModel().getSelectedItem().getField_name();
		String group_name = group.getSelectionModel().getSelectedItem();
		String region = province_name + " " + city_name + " " + field_name;
		String hotelName = CheckUtil.checkText(hotel_name) ? hotel_name.getText() : null;
		int star_le = CheckUtil.checkSelect(star) ? star.getSelectionModel().getSelectedItem() : -1;
		double scor = CheckUtil.checkScore(score.getText()) ? Double.parseDouble(score.getText()) : -1;
		RoomType type = CheckUtil.checkSelect(room_type) ? room_type.getSelectionModel().getSelectedItem()
				: RoomType.ALL;

		boolean min_p = CheckUtil.checkValue(low_price.getText());
		boolean max_p = CheckUtil.checkValue(hi_price.getText());
		int min_price = min_p ? Integer.parseInt(low_price.getText()) : -1;
		int max_price = max_p ? Integer.parseInt(hi_price.getText()) : Integer.MAX_VALUE;

		String in_time = es_in.getEditor().getText();
		String out_time = es_in.getEditor().getText();
		if (min_price <= max_price) {
			SearchCondition condition = new SearchCondition(UserCache.getID(), region, group_name, hotelName, star_le,
					scor, in_time, out_time, min_price, max_price, type, history.isSelected());
			return condition;
		} else {
			return null;
		}
	}

	public abstract void handle(ArrayList<HotelVO> hotel_vos);

}
