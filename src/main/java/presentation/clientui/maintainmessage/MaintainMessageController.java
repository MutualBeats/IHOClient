package presentation.clientui.maintainmessage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Window;
import presentation.bundle.CreditListBundle;
import presentation.manageui.check.ClientInformationController;
import presentation.utilui.WindowGrab;
import util.exception.NetException;
import util.resultmessage.ResultMessage_User;
import vo.credit.CreditVO;
import vo.user.ClientInfoChangeVO;

public class MaintainMessageController extends ClientInformationController {

	@FXML
	private Label title;

	@FXML
	private Button credit_history;

	private static URL CREDIT_FXML;
	private static URL CREDIT_CSS;

	static {
		try {
			CREDIT_FXML = new URL("file:src/main/resources/ui/clientui/fxml/credit.fxml");
			CREDIT_CSS = new URL("file:src/main/resources/ui/clientui/css/credit.css");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void credit_history(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		try {
			ArrayList<CreditVO> credit_record = ControllerFactory.getCreditBLServiceInstance().checkCreditRecord(info.id);
			WindowGrab.startWindowWithBundle(window, "信用变更记录", CREDIT_FXML, CREDIT_CSS, new CreditListBundle(credit_record));
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
		}
	}
	
	@FXML
	protected void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}
	
	@Override
	public void confirm() {
		Window window = WindowGrab.getWindowByStage(1);
		ClientInfoChangeVO vo = new ClientInfoChangeVO(info.id, name.getText(), phone.getText());
		ResultMessage_User result = ResultMessage_User.UpdateSuccess;
		try {
			result = ControllerFactory.getClientBLServiceInstance().changeClientInfo(vo);
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
