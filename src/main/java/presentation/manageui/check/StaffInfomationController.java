package presentation.manageui.check;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;
import util.resultmessage.ResultMessage_User;
import vo.user.MarketerVO;
import vo.user.StaffVO;

public class StaffInfomationController extends InformationLookController {
	
	@FXML
	Label hotel_id;

	StaffVO info;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		info = (StaffVO) resources.getObject("info");
		init();
	}

	private void init() {
		this.user_name.setText(info.staffID);
		this.name.setText(info.staffName);
		this.phone.setText(info.contactWay);
		this.hotel_id.setText(info.hotelID);
		this.type.setText("客户");
	}

	@Override
	public void confirm() {
		boolean check = checkformatter();
		if(check) {
//			MarketerVO vo = new MarketerVO(info.marketerID, name.getText(), phone.getText());
			ResultMessage_User result = ResultMessage_User.UpdateSuccess;
			try {
//				result = ControllerFactory.getMarketerBLServiceInstance().
			} catch (Exception e) {
				Window window = WindowGrab.getWindowByStage(1);
				WindowGrab.startErrorWindow(window, "网络错误，请检查您的网络");
				return;
			}
			if(result != ResultMessage_User.UpdateSuccess) {
				Window window = WindowGrab.getWindowByStage(1);
				WindowGrab.startErrorWindow(window, "修改失败");
			} else {
				toInfoState();
			}
		}
	}


}
