package presentation.manageui.check;

import java.net.URL;
import java.util.ResourceBundle;

import config.NumberConfig;
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
import util.resultmessage.ResultMessage_User;

public abstract class InformationLookController implements Initializable, Confirm {

	@FXML
	Button cancel;

	@FXML
	Button change;

	@FXML
	protected Label user_name;

	@FXML
	protected TextField phone;

	@FXML
	protected TextField name;

	@FXML
	protected Label type;

	@FXML
	protected Button confirm;

	@FXML
	Label phone_warning;

	@FXML
	Label name_warning;

	boolean modify_state = false;

	// private

	@FXML
	void cancel(ActionEvent event) {
		if (modify_state) {
			toInfoState();
		} else {
			WindowGrab.closeWindow(event);
		}
	}

	@FXML
	void change(ActionEvent event) {
		// 进入修改状态
		toModifyState();
	}

	@FXML
	void confirm(ActionEvent event) {
		if (checkformatter()) {
			// 修改确认
			Window window = WindowGrab.getWindow(event);
			WindowGrab.startModifyConfirmWindow(window, this);
		}
	}

	@FXML
	public void nameModify(MouseEvent event) {
		CheckUtil.checkWarningBefore(name_warning);
	}

	@FXML
	public void phoneModify(MouseEvent event) {
		CheckUtil.checkWarningBefore(phone_warning);
	}

	@Override
	public abstract void initialize(URL location, ResourceBundle resources);

	protected void toModifyState() {
		modify_state = true;
		name.setEditable(true);
		phone.setEditable(true);
		change.setVisible(false);
		change.setDisable(true);
		confirm.setVisible(true);
		confirm.setDisable(false);
	}

	protected void toInfoState() {
		modify_state = false;
		name.setEditable(false);
		phone.setEditable(false);
		change.setVisible(true);
		change.setDisable(false);
		confirm.setVisible(false);
		confirm.setDisable(true);
	}

	protected boolean checkformatter() {
		return checkName() && checkPhone();
	}

	/**
	 * Check the name formatter
	 */
	private boolean checkName() {
		String c_name = name.getText();
		if (c_name.length() == 0) {
			name_warning.setText("请输入您的姓名");
			return false;
		}
		boolean name_check = NumberConfig.nameFormatterCheck(c_name);
		if (!name_check) {
			name_warning.setText("姓名应为1～12位，不包含空格等特殊字符");
		}
		return name_check;

	}

	/**
	 * Check the phone formatter
	 */
	private boolean checkPhone() {
		String ph = phone.getText();
		if (ph.length() == 0) {
			phone_warning.setText("请输入手机");
			return false;
		}
		boolean ph_check = NumberConfig.phoneFormatterCheck(ph);
		if (!ph_check) {
			phone_warning.setText("手机号应为11位数字");
		}
		return ph_check;
	}

	/**
	 * 选择确认修改用户信息后的确认处理方法
	 */
	public abstract void confirm();

	protected void handleResult(ResultMessage_User result, Window window) {
		if (result != ResultMessage_User.UpdateSuccess) {
			WindowGrab.startErrorWindow(window, "修改失败");
		} else {
			WindowGrab.startNoticeWindow(window, "修改成功");
			toInfoState();
		}
	}

}
