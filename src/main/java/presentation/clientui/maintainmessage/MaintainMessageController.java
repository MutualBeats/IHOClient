package presentation.clientui.maintainmessage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Window;
import presentation.manageui.check.ClientInformationController;
import presentation.utilui.WindowGrab;
import util.exception.NetException;
import vo.credit.CreditVO;

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

//	@Override
//	public void initialize(URL location, ResourceBundle resources) {
//		info = (ClientVO) resources.getObject("info");
//		user_name.setText(info.id);
//		name.setText(info.name);
//		phone.setText(info.contactWay);
//		type.setText(info.credit + "");
//	}
//	
	class CreditListBundle extends ResourceBundle {

		private ArrayList<CreditVO> credit_record;

		private final static String RECORD = "credit";

		public CreditListBundle(ArrayList<CreditVO> credit_record) {
			super();
			this.credit_record = credit_record;
		}

		@Override
		protected Object handleGetObject(String key) {
			if (RECORD.equals(key)) {
				return credit_record;
			}
			return null;
		}

		@Override
		public Enumeration<String> getKeys() {
			return null;
		}

	}

}
