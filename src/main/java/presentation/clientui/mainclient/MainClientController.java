package presentation.clientui.mainclient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogicservice.orderblservice.OrderBLService;
import config.urlconfig.LoginUIURLConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Window;
import presentation.bundle.HotelListBundle;
import presentation.bundle.InformationBundle;
import presentation.bundle.OrderListBundle;
import presentation.clientui.utilui.SearchView;
import presentation.clientui.utilui.ViewUtil;
import presentation.utilui.WindowGrab;
import util.UserCache;
import util.exception.NetException;
import util.order.OrderState;
import util.user.MemberType;
import vo.hotel.HotelVO;
import vo.order.OrderVO;
import vo.user.ClientVO;

/**
 * 
 * 客户端主界面
 * 
 * @author heleninsa
 *
 */
public class MainClientController extends SearchView {

	@FXML
	private Button first;

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
	private Button history_hotel;

	@FXML
	private Label user_name;

	@FXML
	private Label title;

	@FXML
	private Button hotel_one;
	
	@FXML
	private Button hotel_two;
	
	@FXML
	private Button hotel_three;

	@FXML
	private Button hotel_four;
	
	@FXML
	private Button hotel_five;

	@FXML
	private Button hotel_six;

	@FXML
	private Button hotel_seven;

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
		hotel_one.setUserData("00000001");
		hotel_two.setUserData("00000002");
		hotel_three.setUserData("00000003");
		hotel_four.setUserData("00000004");
		hotel_five.setUserData("00000005");
		hotel_six.setUserData("00000006");
		hotel_seven.setUserData("00000007");
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
		/*
		 *订单列表获取 
		 */
		try {
			ArrayList<OrderVO> total_list = service.queryUserOrder(client_id, OrderState.All);
			ArrayList<OrderVO> finish_list = service.queryUserOrder(client_id, OrderState.Finished);
			ArrayList<OrderVO> unexecute_list = service.queryUserOrder(client_id, OrderState.Unexecuted);
			ArrayList<OrderVO> revoked_list = service.queryUserOrder(client_id, OrderState.Canceled);
			ArrayList<OrderVO> exception_list = service.queryUserOrder(client_id, OrderState.Exception);

			ResourceBundle bundle = new OrderListBundle(total_list, finish_list, unexecute_list, revoked_list,
					exception_list);
			WindowGrab.changeSceneWithBundle(BROWSE_ORDER_FXML, BROWSE_ORDER_CSS, frame, bundle);
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
		}
	}

	@FXML
	void lookHotHotel(ActionEvent event) {
		String hot_hotel_id = (String) ((Node) event.getSource()).getUserData();
		Window window = WindowGrab.getWindow(event);
		try {
			HotelVO hotel = ControllerFactory.getHotelBLServiceInstance().showHotelInfo(hot_hotel_id);
			ViewUtil.showHotelInfo(hotel, window);
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
		}
	}

	@FXML
	void member(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		try {
			/*判断是否已是会员*/
			if (ControllerFactory.getClientBLServiceInstance()
					.getClientInfo(UserCache.getID()).memberType == MemberType.Not) {
				WindowGrab.startWindow(window, "注册会员", MEMBER_FXML, MEMBER_CSS);
			} else {
				WindowGrab.startNoticeWindow(window, "您已是会员，无需重复注册");
			}
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
		}
	}

	@FXML
	void maintain_message(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		try {
			ClientVO info = ControllerFactory.getClientBLServiceInstance().getClientInfo(UserCache.getID());
			WindowGrab.startWindowWithBundle(window, "个人信息详情", MAINTAIN_MESSAGE_FXML, MAINTAIN_MESSAGE_CSS,
					new InformationBundle(info));
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
		}
	}

	@FXML
	void logout(ActionEvent event) {
		WindowGrab.changeScene(LoginUIURLConfig.login_fxml_url(), LoginUIURLConfig.login_css_url(), event);
	}

	@FXML
	void history(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		try {
			ArrayList<OrderVO> vos = ControllerFactory.getOrderBLServiceInstance().queryUserOrder(UserCache.getID(),
					OrderState.All);
			//酒店Hashmap，避免重复酒店
			Map<String, String> hotel_ids = new HashMap<>();
			ArrayList<HotelVO> hotel_list = new ArrayList<>();
			//筛选 
			for (OrderVO each : vos) {
				String hotelID = each.hotelID;
				if (!hotel_ids.containsKey(hotelID)) {
					//重复检测
					hotel_ids.put(hotelID, hotelID);
					HotelVO hotel_info = ControllerFactory.getHotelBLServiceInstance().showHotelInfo(hotelID);
					hotel_list.add(hotel_info);
					hotel_info.setBook_before(true);
				}
			}
			HotelListBundle hotelListBundle = new HotelListBundle(hotel_list);
			Scene frame = WindowGrab.getScene(event);
			WindowGrab.changeSceneWithBundle(HISTORY_FXML, HISTORY_CSS, frame, hotelListBundle);
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
		}
	}

	@Override
	public void handle(ArrayList<HotelVO> hotel_vos) {
		Scene frame = WindowGrab.getSceneByStage(0);
		HotelListBundle bundle = new HotelListBundle(hotel_vos);
		WindowGrab.changeSceneWithBundle(SEARCH_HOTEL_FXML, SEARCH_HOTEL_CSS, frame, bundle);
	}
}
