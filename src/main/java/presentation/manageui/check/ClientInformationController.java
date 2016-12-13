package presentation.manageui.check;

import java.net.URL;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;
import util.resultmessage.ResultMessage_User;
import vo.user.ClientInfoChangeVO;
import vo.user.ClientVO;

public class ClientInformationController extends InformationLookController {

	@FXML
	private Label member_type;

	@FXML
	private Label member_info;

	@FXML
	private Label credit;

	@FXML
	private Label member_level;

	protected ClientVO info;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		info = (ClientVO) resources.getObject("info");
		init();
	}

	private void init() {
		this.user_name.setText(info.id);
		this.name.setText(info.name);
		this.phone.setText(info.contactWay);
		this.credit.setText(info.credit + "");
		this.member_info.setText(info.memberMessage);
		this.member_type.setText(info.memberType.toString());
		this.member_level.setText(info.level + "");
		this.type.setText("客户");
	}

	@Override
	public void confirm() {
		Window window = WindowGrab.getWindowByStage(1);
		ClientInfoChangeVO vo = new ClientInfoChangeVO(info.id, name.getText(), phone.getText());
		ResultMessage_User result = ResultMessage_User.UpdateSuccess;
		try {
			result = ControllerFactory.getManagerBLServiceInstance().changeClientInfo(vo);
			if (result == ResultMessage_User.UpdateSuccess) {
				info.setNameProperty(name.getText());
				info.setContactProperty(phone.getText());
			}
		} catch (Exception e) {
			WindowGrab.startNetErrorWindow(window);
			return;
		}
		handleResult(result, window);
	}

}
