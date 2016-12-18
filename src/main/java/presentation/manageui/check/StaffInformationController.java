package presentation.manageui.check;

import java.net.URL;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;
import util.resultmessage.ResultMessage_User;
import vo.user.StaffChangeVO;
import vo.user.StaffVO;

public class StaffInformationController extends InformationLookController {

	@FXML
	Label hotel_id;

	StaffVO info;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		info = (StaffVO) resources.getObject("info");
		init();
	}

	private void init() {
		this.user_name.setText(info.id);
		this.name.setText(info.name);
		this.phone.setText(info.contactWay);
		this.hotel_id.setText(info.hotelID);
		this.type.setText("客户");
	}

	@Override
	public void confirm() {
		Window window = WindowGrab.getWindowByStage(1);
		StaffChangeVO vo = new StaffChangeVO(info.id, name.getText(), phone.getText());
		ResultMessage_User result = ResultMessage_User.UpdateSuccess;
		try {
			result = ControllerFactory.getManagerBLServiceInstance().changeStaffData(vo);
			if (result == ResultMessage_User.UpdateSuccess) {
				info.setNameProperty(name.getText());
				info.setContactProperty(phone.getText());
			}
		} catch (Exception e) {
			WindowGrab.startErrorWindow(window, "网络错误，请检查您的网络");
			return;
		}
		handleResult(result, window);
	}

}
