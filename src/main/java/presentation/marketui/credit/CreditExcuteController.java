package presentation.marketui.credit;

import java.net.URL;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;
import presentation.utilcontroller.Confirm;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;
import util.Time;
import util.credit.CreditChangeAction;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Credit;
import vo.credit.CreditVO;
import vo.user.ClientVO;

public class CreditExcuteController implements Initializable, Confirm {
	@FXML
	private Button confirm;

	@FXML
	private Button cancel;

	@FXML
	private TextField credit_to_add;

	@FXML
	private Label user_name;

	@FXML
	private Label credit_warning;

	@FXML
	private Label name;

	@FXML
	private Label creditnow;

	private ClientVO info;

	@FXML
	void confirm(ActionEvent event) {
		if (checkCreditInput()) {
			Window window = WindowGrab.getWindow(event);
			WindowGrab.startConfirmWindow(window, this, "是否确认充值");
		}
	}

	private boolean checkCreditInput() {
		boolean check = CheckUtil.checkText(credit_to_add);
		if (!check) {
			credit_warning.setText("请输入充值额度");
			return false;
		}
		try {
			int credit_add = Integer.parseInt(credit_to_add.getText());
			if (100 * (credit_add / 100) == credit_add) {
				credit_warning.setText("输入额度应为100的倍数");
				return false;
			} else if (credit_add <= 0) {
				credit_warning.setText("请输入正整数");
				return false;
			}
		} catch (Exception e) {
			credit_warning.setText("请输入整数额度");
			return false;
		}
		return true;
	}

	@FXML
	void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

	@FXML
	public void passwordAgainModify(MouseEvent event) {
		boolean warn_before = CheckUtil.checkWarningBefore(credit_warning);
		if (warn_before) {
			credit_warning.setText("");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		info = (ClientVO) resources.getObject("info");
		if (info != null) {
			user_name.setText(info.id);
			name.setText(info.name);
			creditnow.setText(info.credit + "");

		}
	}

	@Override
	public void confirm() {
		Window window = WindowGrab.getWindowByStage(1);
		int credit_add = Integer.parseInt(credit_to_add.getText());
		CreditVO updateVO = new CreditVO(info.id, Time.getCurrentTime(), credit_add, -1, CreditChangeAction.Deposit,
				"");
		ResultMessage_Credit result = ResultMessage_Credit.Update_Successful;
		try {
			result = ControllerFactory.getCreditBLServiceInstance().creditUpdate(updateVO);
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
			return;
		}
		if (result == ResultMessage_Credit.Update_Successful) {
			WindowGrab.startNoticeWindow(window, "信用充值成功");
		} else if (result == ResultMessage_Credit.Credit_Net_Error) {
			WindowGrab.startNetErrorWindow(window);
		} else {
			WindowGrab.startErrorWindow(window, "信用充值失败");
		}
	}

}
