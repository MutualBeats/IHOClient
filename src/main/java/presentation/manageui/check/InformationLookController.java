package presentation.manageui.check;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import presentation.utilcontroller.Confirm;
import presentation.utilui.WindowGrab;

public abstract class InformationLookController implements Initializable, Confirm {

	@FXML
	Button cancel;

	@FXML
	Button change;

	@FXML
	TextField user_name;

	@FXML
	TextField phone;

	@FXML
	TextField name;

	@FXML
	TextField type;

	@FXML
	Label phone_warning;

	@FXML
	Label name_warning;

	boolean modify_state = false;

	// private

	@FXML
	void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

	@FXML
	void change(ActionEvent event) {
		if (!modify_state) {
			// 进入修改状态
			toModifyState();
		} else {
			// 修改确认
			Window window = WindowGrab.getWindow(event);
			WindowGrab.startConfirmWindow(window, this);
		}
	}

	@Override
	public abstract void initialize(URL location, ResourceBundle resources);

	protected void toModifyState() {
		modify_state = true;
		name.setEditable(true);
		phone.setEditable(true);
		change.setText("确认");
	}

	protected void toInfoState() {
		modify_state = false;
		name.setEditable(false);
		phone.setEditable(false);
		change.setText("修改");
	}

	@Override
	public abstract void confirm();

}
