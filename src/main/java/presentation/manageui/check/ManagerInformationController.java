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
		this.user_name.setText(info.managerID);
		this.name.setText(info.managerName);
		this.type.setText("网站管理人员");
		this.phone.setText(info.contactWay);
	}

	@Override
	public void confirm() {
		ManagerVO vo = new ManagerVO(info.managerID, name.getText(), phone.getText());
		ResultMessage_User result = ResultMessage_User.UpdateSuccess;
		try {
			result = ControllerFactory.getManagerBLServiceInstance().changeManagerInfo(vo);
		} catch (Exception e) {
			WindowGrab.startErrorWindow(WindowGrab.getWindowByStage(1), "网络错误，请检查您的网络");
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
