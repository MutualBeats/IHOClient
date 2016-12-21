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
		this.user_name.setText(info.id);
		this.name.setText(info.name);
		this.type.setText("网站营销人员");
		this.phone.setText(info.contactWay);
	}
	
	@Override
	protected void toInfoState() {
		super.toInfoState();
		name.setText(info.name);
		phone.setText(info.contactWay);
	}

	@Override
	public void confirm() {
		Window window = WindowGrab.getWindowByStage(1);
		MarketerVO vo = new MarketerVO(info.id, name.getText(), phone.getText());
		ResultMessage_User result = ResultMessage_User.UpdateSuccess;
		try {
			result = ControllerFactory.getManagerBLServiceInstance().changeMarketerData(vo);
			if (result == ResultMessage_User.UpdateSuccess) {
				info.setNameProperty(name.getText());
				info.setContactProperty(phone.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
			WindowGrab.startErrorWindow(window, "网络错误，请检查您的网络");
			return;
		}
		handleResult(result, window);
	}

}
