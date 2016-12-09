package presentation.loginui;

import java.net.URL;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Window;
import presentation.utilcontroller.RegistCheckController;
import presentation.utilui.ResultDeal;
import presentation.utilui.WindowGrab;
import util.resultmessage.ResultMessage_User;
import vo.user.ClientRegistVO;

public class SigninController extends RegistCheckController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	@FXML
	protected void confirm(ActionEvent event) {
		boolean formatter_check = checkInputFormatter();
		if (formatter_check) {
			Window window = WindowGrab.getWindow(event);
			if (checkName(window)) {
				String id = user_name.getText();
				String u_name = name.getText();
				String contactWay = phone.getText();
				String psw = ps.getText();
				ClientRegistVO info = new ClientRegistVO(id, u_name, contactWay, psw);
				ResultMessage_User result = ResultMessage_User.Register_Success;
				try {
					result = ControllerFactory.getClientBLServiceInstance().regist(info);
				} catch (Exception e) {
					WindowGrab.startErrorWindow(window, "网络异常，请检查网络连接");
					return;
				}
				ResultDeal.checkResult(result, window);
			}
		}
	}

	@FXML
	public void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}
}