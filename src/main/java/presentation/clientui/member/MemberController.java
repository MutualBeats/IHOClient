package presentation.clientui.member;

import java.net.URL;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Window;
import presentation.utilcontroller.Confirm;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;
import util.UserCache;
import util.exception.NetException;
import util.resultmessage.ResultMessage_User;
import util.user.MemberType;
import vo.user.MemberVO;

public class MemberController implements Confirm, Initializable {

	@FXML
	private Button cancel;

	@FXML
	private Button confirm;

	@FXML
	private Pane original_pane;

	@FXML
	private Pane business_pane;

	@FXML
	private Label title;

	@FXML
	private TextField enterprise;

	@FXML
	private DatePicker birth;

	@FXML
	void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

	@FXML
	void confirm(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		WindowGrab.startConfirmWindow(window, this, "是否确认注册会员？");
	}

	@FXML
	void original_member(ActionEvent event) {
		business_pane.setVisible(false);
		original_pane.setVisible(true);
	}

	@FXML
	void business_member(ActionEvent event) {
		original_pane.setVisible(false);
		business_pane.setVisible(true);
	}

	@Override
	public void confirm() {
		MemberVO memver_info;
		Window window = WindowGrab.getWindowByStage(1);
		if (original_pane.isVisible()) {
			// 普通会员
			if (CheckUtil.checkSelect(birth)) {
				memver_info = new MemberVO(UserCache.getID(), MemberType.Ordinary, 0, birth.getEditor().getText());
			} else {
				WindowGrab.startNoticeWindow(window, "请选择您的生日。");
				return;
			}
		} else {
			// 企业会员
			if (CheckUtil.checkText(enterprise)) {
				memver_info = new MemberVO(UserCache.getID(), MemberType.Enterprise, 0, enterprise.getText());
			} else {
				WindowGrab.startNoticeWindow(window, "请填写您所在的企业名称.");
				return;
			}
		}
		
		try {
			ResultMessage_User result = ControllerFactory.getClientBLServiceInstance().registerMember(memver_info);
			if(result == ResultMessage_User.Register_Success) {
				WindowGrab.closeWindow(window);
				WindowGrab.startNoticeWindow(WindowGrab.getWindowByStage(0), "注册会员成功");
			} else if(result == ResultMessage_User.Net_Error){
				WindowGrab.startNetErrorWindow(window);
			} else {
				WindowGrab.startNoticeWindow(window, "注册会员失败");
			}
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
		}
	}

	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		birth.setConverter(CheckUtil.getConverter());
	}
}
