package presentation.clientui.createorder;

import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogicservice.orderblservice.OrderBLService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import presentation.clientui.utilui.ViewUtil;
import presentation.utilcontroller.Confirm;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;
import util.Time;
import util.UserCache;
import util.exception.NetException;
import util.exception.TimeConflictException;
import vo.hotel.HotelVO;
import vo.order.OrderMakeVO;
import vo.order.OrderVO;
import vo.room.RoomRecordVO;
import vo.room.RoomVO;
import vo.user.ClientVO;

public class MakeOrderController implements Initializable, Confirm {

	@FXML
	private ComboBox<Integer> hotel_star;

	@FXML
	private TableColumn<RoomVO, String> room_number;

	@FXML
	private Button back;

	@FXML
	private TextArea hotel_address;

	@FXML
	private DatePicker ou_time;

	@FXML
	private TextField hotel_name;

	@FXML
	private DatePicker in_time;

	@FXML
	private TextField people_num;

	@FXML
	private CheckBox children;

	@FXML
	private TableColumn<RoomVO, Integer> price;

	@FXML
	private TextField contact;

	@FXML
	private TextField name;

	@FXML
	private TextField value;

	@FXML
	private TextField promotion;

	@FXML
	private Button make;

	@FXML
	private TableView<RoomVO> room_list;

	@FXML
	private TableColumn<RoomVO, String> room_type;

	private String hotel_id;

	private ArrayList<RoomVO> rooms;

	private OrderVO order_waiting_to_make;

	@SuppressWarnings({ "unchecked" })
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/* 固定信息初始化 */
		HotelVO hotel_info = (HotelVO) resources.getObject("hotel_info");
		ClientVO client_info = (ClientVO) resources.getObject("client_info");
		rooms = (ArrayList<RoomVO>) resources.getObject("room_list");
		name.setText(client_info.name);
		contact.setText(client_info.contactWay);
		hotel_name.setText(hotel_info.hotelName);
		hotel_id = hotel_info.hotelID;
		hotel_star.getItems().add(hotel_info.starLevel);
		hotel_star.getSelectionModel().select(0);
		hotel_address.setText(hotel_info.address);
		/* 列表信息初始化 */
		room_type.setCellValueFactory(cellData -> cellData.getValue().getRoomTypeProperty());
		room_number.setCellValueFactory(cellData -> cellData.getValue().getRoomNumberProperty());
		price.setCellValueFactory(cellData -> cellData.getValue().getRoomPriceProperty().asObject());

		room_list.getItems().addAll(rooms);
		room_list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		/* DatePicker初始化 */
		CheckUtil.init(in_time, ou_time, LocalDate.now(), LocalDate.now());
		action_init();
	}

	private void action_init() {
		RoomUpdateHandle handle = new RoomUpdateHandle();
		in_time.setOnAction(handle);
		ou_time.setOnAction(handle);
		room_list.getSelectionModel().selectedItemProperty().addListener(new PriceCalHandle());
	}

	@FXML
	void make(ActionEvent event) {
		boolean nums = CheckUtil.checkValue(people_num.getText());
		boolean select_rooms = room_list.getSelectionModel().getSelectedItems().size() != 0;
		Window window = WindowGrab.getWindow(event);
		if (nums && select_rooms) {
			WindowGrab.startConfirmWindow(window, this, "是否确认订单信息无误？");
		} else if (!nums) {
			WindowGrab.startErrorWindow(window, "请填写入住人数");
		} else {
			WindowGrab.startErrorWindow(window, "请选择入住房间");
		}
	}

	@FXML
	void back(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

	@Override
	public void confirm() {
		Window window = WindowGrab.getWindowByStage(1);
		try {
			OrderBLService service = ControllerFactory.getOrderBLServiceInstance();
			String order_id = service.makeOrder(order_waiting_to_make);
			OrderVO vo = service.queryOrderById(order_id);
			String hotel_n = hotel_name.getText();
			/* 订单生成窗口关闭 */
			WindowGrab.closeWindow(window);
			Window info_window = WindowGrab.getWindowByStage(0);
			ViewUtil.showOrder(vo, hotel_n, info_window);
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
		}
	}

	private class RoomUpdateHandle implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			Window window = WindowGrab.getWindow(event);
			updateRoom(window);
		}

	}

	private class PriceCalHandle implements ChangeListener<RoomVO> {

		@Override
		public void changed(ObservableValue<? extends RoomVO> observable, RoomVO oldValue, RoomVO newValue) {
			// 生成订单信息
			String clientID = UserCache.getID();
			ObservableList<RoomVO> room_nl = room_list.getSelectionModel().getSelectedItems();
			ArrayList<String> roomNumberList = new ArrayList<>();
			for (RoomVO each : room_nl)
				roomNumberList.add(each.roomNumber);

			int numOfPeople = Integer.parseInt(people_num.getText());
			boolean be_children = children.isSelected();

			String checkInDate = in_time.getEditor().getText();
			String estimateCheckOutDate = ou_time.getEditor().getText();

			OrderMakeVO makeVO = new OrderMakeVO(clientID, hotel_id, roomNumberList, checkInDate, estimateCheckOutDate,
					numOfPeople, be_children);
			Window window = WindowGrab.getWindowByStage(1);
			try {
				OrderVO vo = ControllerFactory.getOrderBLServiceInstance().getOrderVOBeforeMake(makeVO);
				order_waiting_to_make = vo;
				value.setText(vo.value + " 元");
				String promotion_name = "无可用促销策略";
				if (vo.promotionIDList.size() != 0) {

					promotion_name = ControllerFactory.getPromotionBLServiceInstance()
							.getPromotionById(vo.promotionIDList.get(0)).promotionName;

				}
				promotion.setText(promotion_name);
			} catch (NetException e) {
				WindowGrab.startNetErrorWindow(window);
			} catch (TimeConflictException e1) {
				WindowGrab.startErrorWindow(window, "对不起，所选房间时间有冲突");
			}
		}

	}

	/**
	 * 更新时间选择后房间列表
	 * 
	 * @param window
	 *            : 错误信息承载窗口
	 */
	private void updateRoom(Window window) {
		String es_in_time = in_time.getEditor().getText();
		String es_out_time = ou_time.getEditor().getText();

		ArrayList<RoomVO> satisfy_rooms = new ArrayList<>();

		/* 房间列表更新 */
		for (RoomVO each : rooms) {
			try {
				ArrayList<RoomRecordVO> records = ControllerFactory.getRoomBLServiceInstance().getOrderRecord(hotel_id,
						each.roomNumber);
				boolean ok = true;
				for (RoomRecordVO record : records) {
					boolean later = Time.deltaDate(es_out_time, record.checkInDate) > 0;
					boolean earlier = Time.deltaDate(record.estimateCheckOutDate, es_in_time) > 0;
					if (!(later && earlier)) {
						ok = false;
						break;
					}
				}
				if (ok) {
					satisfy_rooms.add(each);
				}
			} catch (NetException e) {
				WindowGrab.startNetErrorWindow(window);
				break;
			} catch (ParseException e) {
				WindowGrab.startErrorWindow(window, "时间格式错误");
				break;
			}
		}

		/* Update */
		room_list.getItems().clear();
		room_list.getItems().addAll(satisfy_rooms);
	}

}
