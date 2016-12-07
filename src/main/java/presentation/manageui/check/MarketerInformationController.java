package presentation.manageui.check;

import java.net.URL;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;
import util.resultmessage.ResultMessage_User;
import vo.user.MarketerVO;

public class MarketerInformationController extends InformationLookController {

	private MarketerVO info;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		info = (MarketerVO) resources.getObject("info");
		init();
	}

	private void init() {
		this.user_name.setText(info.marketerID);
		this.name.setText(info.marketerName);
		this.type.setText("网站管理人员");
		this.phone.setText(info.contactWay);
	}

	@Override
	public void confirm() {
		Window window = WindowGrab.getWindowByStage(1);
		MarketerVO vo = new MarketerVO(info.marketerID, name.getText(), phone.getText());
		ResultMessage_User result = ResultMessage_User.UpdateSuccess;
		try {
			result = ControllerFactory.getManagerBLServiceInstance().changeMarketerData(vo);
		} catch (Exception e) {
			WindowGrab.startErrorWindow(window, "网络错误，请检查您的网络");
			return;
		}
		handleResult(result, window);
	}

}
