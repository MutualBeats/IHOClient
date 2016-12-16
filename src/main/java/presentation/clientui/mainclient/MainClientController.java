package presentation.clientui.mainclient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogicservice.orderblservice.OrderBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Window;
import presentation.bundle.HotelListBundle;
import presentation.bundle.InformationBundle;
import presentation.bundle.OrderListBundle;
import presentation.utilui.WindowGrab;
import util.UserCache;
import util.exception.NetException;
import util.order.OrderState;
import vo.hotel.HotelVO;
import vo.order.OrderVO;
import vo.user.ClientVO;

public class MainClientController {

	@FXML
	private Button all;

	@FXML
	private Label hotel_one;

	@FXML
	private Label hotel_four;

	@FXML
	private Label user_name;

	@FXML
	private Label hotel_five;

	@FXML
	private Button history;

	@FXML
	private Label title;

	@FXML
	private Label hotel_six;

	@FXML
	private Button logout;

	@FXML
	private Button browse_order;

	@FXML
	private Button search;

	@FXML
	private Button member;

	@FXML
	private Button maintain_message;

	@FXML
	private Label hotel_three;

	@FXML
	private Label hotel_seven;

	@FXML
	private Label hotel_two;

	// 浏览订单
	private static URL BROWSE_ORDER_FXML;
	private static URL BROWSE_ORDER_CSS;

	// 注册会员
	private static URL MEMBER_FXML;
	private static URL MEMBER_CSS;

	// 维护个人信息
	private static URL MAINTAIN_MESSAGE_FXML;
	private static URL MAINTAIN_MESSAGE_CSS;

	// 搜索酒店
	private static URL SEARCH_HOTEL_FXML;
	private static URL SEARCH_HOTEL_CSS;

	// 历史记录
	private static URL HISTORY_FXML;
	private static URL HISTORY_CSS;

	static {
		try {
			BROWSE_ORDER_FXML = new URL("file:src/main/resources/ui/clientui/fxml/browse_order.fxml");
			BROWSE_ORDER_CSS = new URL("file:src/main/resources/ui/clientui/css/browse_order.css");

			MEMBER_FXML = new URL("file:src/main/resources/ui/clientui/fxml/member.fxml");
			MEMBER_CSS = new URL("file:src/main/resources/ui/clientui/css/member.css");

			MAINTAIN_MESSAGE_FXML = new URL("file:src/main/resources/ui/clientui/fxml/maintain_message.fxml");
			MAINTAIN_MESSAGE_CSS = new URL("file:src/main/resources/ui/clientui/css/maintain_message.css");

			SEARCH_HOTEL_FXML = new URL("file:src/main/resources/ui/clientui/fxml/search_hotel.fxml");
			SEARCH_HOTEL_CSS = new URL("file:src/main/resources/ui/clientui/css/search_hotel.css");

			HISTORY_FXML = new URL("file:src/main/resources/ui/clientui/fxml/hotel_list.fxml");
			HISTORY_CSS = new URL("file:src/main/resources/ui/clientui/css/hotel_list.css");

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void browse_order(ActionEvent event) {
		Scene frame = WindowGrab.getScene(event);
		Window window = WindowGrab.getWindowByScene(frame);
		OrderBLService service = null;
		try {
			service = ControllerFactory.getOrderBLServiceInstance();
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
			return;
		}

		String client_id = UserCache.getID();
		if (client_id == null) {
			WindowGrab.startErrorWindow(window, "当前无用户登陆");
			return;
		}
		try {
			System.out.println(client_id);
			ArrayList<OrderVO> total_list = service.queryUserOrder(client_id, OrderState.All);
			ArrayList<OrderVO> finish_list = service.queryUserOrder(client_id, OrderState.Finished);
			ArrayList<OrderVO> unexecute_list = service.queryUserOrder(client_id, OrderState.Unexecuted);
			ArrayList<OrderVO> revoked_list = service.queryUserOrder(client_id, OrderState.Canceled);
			ArrayList<OrderVO> exception_list = service.queryUserOrder(client_id, OrderState.Exception);
		
			ResourceBundle bundle = new OrderListBundle(total_list, finish_list, unexecute_list, revoked_list, exception_list); 
			WindowGrab.changeSceneWithBundle(BROWSE_ORDER_FXML, BROWSE_ORDER_CSS, frame, bundle);
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
		}
		// Stage stage=WindowGrab.getStage(0);
		// stage.setTitle("浏览订单");
	}

	@FXML
	void member(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, "注册会员", MEMBER_FXML, MEMBER_CSS);
	}

	@FXML
	void maintain_message(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		try {
			ClientVO info = ControllerFactory.getClientBLServiceInstance().getClientInfo(UserCache.getID());
			WindowGrab.startWindowWithBundle(window, "个人信息详情", MAINTAIN_MESSAGE_FXML, MAINTAIN_MESSAGE_CSS, new InformationBundle(info));
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
		}
	}

	@FXML
	void logout(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	void on_search(ActionEvent event) {
		Scene frame = WindowGrab.getScene(event);
		WindowGrab.changeScene(SEARCH_HOTEL_FXML, SEARCH_HOTEL_CSS, frame);
		// Stage stage=WindowGrab.getStage(0);
		// stage.setTitle("搜索酒店");

	}

	@FXML
	void history(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		try {
			ArrayList<OrderVO> vos = ControllerFactory.getOrderBLServiceInstance().queryUserOrder(UserCache.getID(), OrderState.All);
			System.out.println("Size" + vos.size());
			Map<String, String> hotel_ids = new HashMap<>();
			ArrayList<HotelVO> hotel_list = new ArrayList<>();
			for(OrderVO each : vos) {
				String hotelID = each.hotelID;
				if(!hotel_ids.containsKey(hotelID)) {
					hotel_ids.put(hotelID, hotelID);
					HotelVO hotel_info = ControllerFactory.getHotelBLServiceInstance().showHotelInfo(hotelID);
					hotel_list.add(hotel_info);
				}
			}
			HotelListBundle hotelListBundle = new HotelListBundle(hotel_list);
			Scene frame = WindowGrab.getScene(event);
			WindowGrab.changeSceneWithBundle(HISTORY_FXML, HISTORY_CSS, frame, hotelListBundle);
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
		}
	}
}
