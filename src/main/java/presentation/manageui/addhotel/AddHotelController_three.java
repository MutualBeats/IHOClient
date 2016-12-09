package presentation.manageui.addhotel;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;
import util.resultmessage.ResultMessage_User;
import vo.hotel.HotelVO;
import vo.user.StaffVO;

public class AddHotelController_three {

	@FXML
	private Button third_cancel;

	@FXML
	private AnchorPane third_pane;

	@FXML
	private Button third_confirm;

	@FXML
	void third_confirm(ActionEvent event) {
		HotelVO hotel_info = ViewCache.hotel_info;
		StaffVO staff_info = ViewCache.staff_info;
		Window window = WindowGrab.getWindow(event);
		
		ResultMessage_User result = ResultMessage_User.PEOPLE_ADD_SUCCESS;
		try {
			String hotelID = ControllerFactory.getManagerBLServiceInstance().addHotel(hotel_info);
			if (hotelID != null) {
				staff_info.hotelID = hotelID;
				result = ControllerFactory.getManagerBLServiceInstance().addStaff(staff_info, ViewCache.ps);
			} else {
				result = ResultMessage_User.PEOPLE_ADD_FAILED;
			}
		} catch (Exception e) {
			WindowGrab.startErrorWindow(window, "网络异常，请检查网络连接");
			return;
		}
		//人员注册成功，代表酒店生成成功。
		if (result == ResultMessage_User.Net_Error) {
			WindowGrab.startErrorWindow(window, "网络异常，请检查网络连接");
		} else if (result == ResultMessage_User.PEOPLE_ADD_SUCCESS) {
			WindowGrab.startNoticeWindow(window, "酒店添加成功");
		} else {
			WindowGrab.startErrorWindow(window, "酒店添加失败");
		}

	}

	@FXML
	void third_cancel(ActionEvent event) {
		ViewCache.clearCache();
		WindowGrab.closeWindow(event);
	}

}
