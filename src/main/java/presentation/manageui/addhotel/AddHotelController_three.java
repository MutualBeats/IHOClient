package presentation.manageui.addhotel;

import bussinesslogic.controllerfactory.ControllerFactory;
import config.urlconfig.ManageUIURLConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;
import util.MD5;
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
				System.out.println("SUCCESS");
				staff_info.hotelID = hotelID;
				result = ControllerFactory.getManagerBLServiceInstance().addStaff(staff_info, MD5.md5(ViewCache.ps));
			} else {
				result = ResultMessage_User.PEOPLE_ADD_FAILED;
			}
		} catch (Exception e) {
			WindowGrab.startErrorWindow(window, "网络异常，请检查网络连接");
			return;
		}
		// 人员注册成功，代表酒店生成成功。
		if (result == ResultMessage_User.Net_Error) {
			WindowGrab.startErrorWindow(window, "网络异常，请检查网络连接");
		} else if (result == ResultMessage_User.Register_Success) {
			ViewCache.clearCache();
			WindowGrab.changeScene(ManageUIURLConfig.manage_add_hotel_one_fxml(), ManageUIURLConfig.manage_add_hotel_one_css(), event);
			WindowGrab.startNoticeWindow(WindowGrab.getWindowByStage(0), "酒店添加成功");
		} else {
			WindowGrab.startErrorWindow(window, "酒店添加失败");
		}

	}

	@FXML
	void third_cancel(ActionEvent event) {
		// 关闭当前窗口
		Scene curScene = WindowGrab.getScene(event);
		WindowGrab.changeScene(ManageUIURLConfig.manage_add_hotel_two_fxml(), ManageUIURLConfig.manage_add_hotel_two_css(), curScene);
	}


}
