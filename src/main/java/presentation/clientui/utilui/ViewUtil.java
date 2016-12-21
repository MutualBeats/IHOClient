package presentation.clientui.utilui;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.stage.Window;
import presentation.bundle.HotelInfoBundle;
import presentation.bundle.OrderMakeBundle;
import presentation.utilui.WindowGrab;
import util.UserCache;
import util.exception.NetException;
import vo.hotel.HotelVO;
import vo.order.OrderVO;
import vo.room.RoomVO;
import vo.user.ClientVO;

public class ViewUtil {

	private static URL HOTEL_FXML;
	private static URL HOTEL_CSS;
	private static URL MAKEORDER_FXML;
	private static URL MAKEORDER_CSS;

	static {
		try {
			HOTEL_FXML = new URL("file:src/main/resources/ui/clientui/fxml/hotel_info.fxml");
			HOTEL_CSS = new URL("file:src/main/resources/ui/clientui/css/hotel_info.css");
			// CLIENTMENU_FXML = new
			// URL("file:src/main/resources/ui/clientui/fxml/clientmenu.fxml");
			// CLIENTMENU_CSS = new
			// URL("file:src/main/resources/ui/clientui/css/clientmenu.css");
			MAKEORDER_FXML = new URL("file:src/main/resources/ui/clientui/fxml/makeorder.fxml");
			MAKEORDER_CSS = new URL("file:src/main/resources/ui/clientui/css/makeorder.css");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static void showHotelInfo(HotelVO hotel, Window window) {
		try {
			ArrayList<OrderVO> order_list = ControllerFactory.getOrderBLServiceInstance()
					.queryOrderByHotel(hotel.hotelID, UserCache.getID());
			HotelInfoBundle bundle = new HotelInfoBundle(hotel, order_list);
			WindowGrab.startWindowWithBundle(window, "酒店信息", HOTEL_FXML, HOTEL_CSS, bundle);
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
		}
	}

	public static void orderMake(HotelVO hotel_info, Window window) {
		try {
			ClientVO client_info = ControllerFactory.getClientBLServiceInstance().getClientInfo(UserCache.getID());
			if (client_info.credit < 0) {
				WindowGrab.startNoticeWindow(window, "您的信用为负，不能下单，请到营业点充值");
				return;
			}
			ArrayList<RoomVO> rooms = ControllerFactory.getRoomBLServiceInstance().getRoomList(hotel_info.hotelID);
			OrderMakeBundle bundle = new OrderMakeBundle(client_info, hotel_info, rooms);
			WindowGrab.startWindowWithBundle(window, "生成订单", MAKEORDER_FXML, MAKEORDER_CSS, bundle);
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
		}
	}

}