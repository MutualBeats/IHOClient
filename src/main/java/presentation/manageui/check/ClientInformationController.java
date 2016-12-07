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

	private ClientVO info;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		info = (ClientVO) resources.getObject("info");
		init();
	}

	private void init() {
		this.user_name.setText(info.clientID);
		this.name.setText(info.clientName);
		this.phone.setText(info.contactWay);
		this.credit.setText(info.credit + "");
		this.member_info.setText(info.memberMessage);
		this.member_type.setText(info.memberType.toString());
		this.member_level.setText(info.level + "");
		this.type.setText("客户");
	}

	@Override
	public void confirm() {
		boolean check = checkformatter();
		if(check) {
			ClientInfoChangeVO vo = new ClientInfoChangeVO(info.clientID, name.getText(), phone.getText());
			ResultMessage_User result = ResultMessage_User.UpdateSuccess;
			try {
				result = ControllerFactory.getManagerBLServiceInstance().changeClientInfo(vo);
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
