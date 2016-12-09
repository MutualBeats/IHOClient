package presentation.manageui.check;

import java.net.URL;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;
import util.resultmessage.ResultMessage_User;
import vo.user.ManagerVO;

public class ManagerInformationController extends InformationLookController {

	private ManagerVO info;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		info = (ManagerVO) resources.getObject("info");
		init();
	}

	private void init() {
		this.user_name.setText(info.id);
		this.name.setText(info.name);
		this.type.setText("网站管理人员");
		this.phone.setText(info.contactWay);
	}

	@Override
	public void confirm() {
		Window window = WindowGrab.getWindowByStage(1);
		ManagerVO vo = new ManagerVO(info.id, name.getText(), phone.getText());
		ResultMessage_User result = ResultMessage_User.UpdateSuccess;
		try {
			result = ControllerFactory.getManagerBLServiceInstance().changeManagerInfo(vo);
		} catch (Exception e) {
			WindowGrab.startErrorWindow(window, "网络错误，请检查您的网络");
			return;
		}
		handleResult(result, window);
	}

}
