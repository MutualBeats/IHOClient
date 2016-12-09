package presentation.utilcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import config.NumberConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;
import util.resultmessage.ResultMessage_Verify;

public class IDInputController implements Initializable{
	
	@FXML
	private Button cancel;

	@FXML
	private Button search;

	@FXML
	protected TextField id_input;
	
	private ResultHandle owner;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		owner = (ResultHandle) resources.getObject("handle");
	}
	
	@FXML
	protected void on_search(ActionEvent event) {
		String id = id_input.getText();
		ResultMessage_Verify result = ResultMessage_Verify.USER_NOT_EXIST;
		Window window = WindowGrab.getWindow(event);
		if (NumberConfig.userNameFormatterCheck(id)) {
			try {
				result = ControllerFactory.getIdentityService().checkIdentity(id);
			} catch (Exception e) {
				result = ResultMessage_Verify.NET_ERROR;
			}
		}
		if (result == ResultMessage_Verify.NET_ERROR ) {
			WindowGrab.startNetErrorWindow(window);
		} else if (result == ResultMessage_Verify.USER_NOT_EXIST) {
			String error_message = "请输入正确的用户名";
			WindowGrab.startErrorWindow(window, error_message);
		}else{
			owner.handleResult(id_input.getText(), result, window);
		}
	}

	@FXML
	protected void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

}
