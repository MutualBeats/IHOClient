package presentation.manageui.addpeople;

import java.net.URL;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Window;
import presentation.utilcontroller.Confirm;
import presentation.utilcontroller.RegistCheckController;
import presentation.utilui.ResultDeal;
import presentation.utilui.WindowGrab;
import util.resultmessage.ResultMessage_User;
import vo.user.MarketerVO;

public class AddPeopleController extends RegistCheckController implements Initializable, Confirm {

	@FXML
	private Label addpeople_title;

	@FXML
	protected void confirm(ActionEvent event) {
		boolean inputOK = checkInputFormatter();
		if (inputOK) {
			Window window = WindowGrab.getWindow(event);
			if(checkName(window)) {
				WindowGrab.startConfirmWindow(window, this);
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@Override
	public void confirm() {
		ResultMessage_User result = ResultMessage_User.Register_Success;

		Window window = WindowGrab.getWindowByStage(1);
		String id = user_name.getText();
		String u_name = name.getText();
		String contactWay = phone.getText();
		MarketerVO info = new MarketerVO(id, u_name, contactWay);
		String password = ps.getText();

		try {
			result = ControllerFactory.getManagerBLServiceInstance().addMarketer(info, password);
		} catch (Exception e) {
			WindowGrab.startErrorWindow(window, "网络异常，请检查网络连接");
			return;
		}

		ResultDeal.checkResult(result, window);

	}

}
