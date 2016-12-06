package presentation.manageui.check;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import vo.user.StaffVO;

public class StaffInfomationController extends InformationLookController {
	
	@FXML
	TextField hotel_id;

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
		// TODO Auto-generated method stub

	}


}
