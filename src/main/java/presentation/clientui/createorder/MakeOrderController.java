package presentation.clientui.createorder;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
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
import presentation.bundle.OrderInfoBundle;
import presentation.utilcontroller.Confirm;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;
import util.Time;
import util.UserCache;
import util.exception.NetException;
import vo.hotel.HotelVO;
import vo.order.OrderMakeVO;
import vo.order.OrderVO;
import vo.room.RoomRecordVO;
import vo.room.RoomVO;
import vo.user.ClientVO;

public class MakeOrderController implements Initializable, Confirm {

	@FXML
	private Button make;

	@FXML
	private Button back;

	@FXML
	private ComboBox<Integer> hotel_star;

	@FXML
	private TextField name;

	@FXML
	private TextField contact;

	@FXML
	private TextArea hotel_address;

	@FXML
	private TextField hotel_name;

	@FXML
	private DatePicker in_time;

	@FXML
	private DatePicker ou_time;

	@FXML
	private TextField people_num;

	@FXML
	private CheckBox children;

	@FXML
	private TableView<RoomVO> room_list;

	@FXML
	private TableColumn<RoomVO, String> room_type;

	@FXML
	private TableColumn<RoomVO, String> room_number;

	@FXML
	private TableColumn<RoomVO, Integer> price;

	private String hotel_id;

	private ArrayList<RoomVO> rooms;

	private static URL CHECK_FXML;
	private static URL CHECK_CSS;

	static {
		try {

			CHECK_FXML = new URL("file:src/main/resources/ui/utilui/fxml/order_information.fxml");
			CHECK_CSS = new URL("file:src/main/resources/ui/utilui/css/order_information.css");

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/* 固定信息初始化 */
		HotelVO hotel_info = (HotelVO) resources.getObject("hotel_info");
		ClientVO client_info = (ClientVO) resources.getObject("client_info");
		rooms = (ArrayList<RoomVO>) resources.getObject("room_list");
		name.setText(client_info.name);
		contact.setText(client_info.contactWay);
		hotel_id = hotel_info.hotelID;
		hotel_star.getEditor().setText(hotel_info.starLevel + "");
		hotel_address.setText(hotel_info.address);
		/* 列表信息初始化 */
		room_list.getItems().addAll(rooms);
		room_list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		room_type.setCellValueFactory(cellData -> cellData.getValue().getRoomTypeProperty());
		room_number.setCellValueFactory(cellData -> cellData.getValue().getRoomNumberProperty());
		price.setCellValueFactory(cellData -> cellData.getValue().getRoomPriceProperty().asObject());

		/* DatePicker初始化 */
		CheckUtil.init(in_time, ou_time, LocalDate.now(), LocalDate.now());
		action_init();
	}

	private void action_init() {
		RoomUpdateHandle handle = new RoomUpdateHandle();
		in_time.setOnAction(handle);
		ou_time.setOnAction(handle);
	}

	@FXML
	void make(ActionEvent event) {
		boolean nums = CheckUtil.checkValue(people_num.getText());
		boolean select_rooms = room_list.getSelectionModel().getSelectedItems().size() != 0;
		Window window = WindowGrab.getWindow(event);
		if (nums && select_rooms) {
			WindowGrab.startConfirmWindow(window, this, "是否确认订单信息无误？");
		} else if (!nums) {
			WindowGrab.startNoticeWindow(window, "请填写入住人数，入住人数应为正整数。");
		} else {
			WindowGrab.startNoticeWindow(window, "请选择入住房间");
		}
	}

	@FXML
	void back(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

	@Override
	public void confirm() {
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
			OrderVO vo = ControllerFactory.getOrderBLServiceInstance().makeOrder(makeVO);
			String hotel_n = hotel_name.getText();
			/*订单生成窗口关闭*/
			WindowGrab.closeWindow(window);
			Window info_window = WindowGrab.getWindowByStage(0);
			try {
				String promotion_name = ControllerFactory.getPromotionBLServiceInstance()
						.getPromotionById(vo.promotionIDList.get(0)).promotionName;
				OrderInfoBundle bundle = new OrderInfoBundle(vo, hotel_name.getText(), promotion_name);
				WindowGrab.startWindowWithBundle(info_window, "订单详情", CHECK_FXML, CHECK_CSS, bundle);
			} catch (NetException e) {
				WindowGrab.startNetErrorWindow(info_window);
			}
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
		}
		// checkInDate, estimateCheckOutDate, numOfPeople, children)
	}

	private class RoomUpdateHandle implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			String es_in_time = in_time.getEditor().getText();
			String es_out_time = ou_time.getEditor().getText();

			ArrayList<RoomVO> satisfy_rooms = new ArrayList<>();

			/* 房间列表更新 */
			for (RoomVO each : rooms) {
				try {
					ArrayList<RoomRecordVO> records = ControllerFactory.getRoomBLServiceInstance()
							.getOrderRecord(hotel_id, each.roomNumber);
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
					Window window = WindowGrab.getWindow(event);
					WindowGrab.startNetErrorWindow(window);
					break;
				} catch (ParseException e) {
					Window window = WindowGrab.getWindow(event);
					WindowGrab.startErrorWindow(window, "时间格式错误");
					break;
				}
			}

			/* Update */
			room_list.getItems().clear();
			room_list.getItems().addAll(satisfy_rooms);

		}

	}

}
