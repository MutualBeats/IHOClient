package presentation.loginui;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import config.urlconfig.ClientUIURLConfig;
import config.urlconfig.LoginUIURLConfig;
import config.urlconfig.ManageUIURLConfig;
import config.urlconfig.MarketUIURLConfig;
import config.urlconfig.StaffUIURLConfig;
import dataservice.utildataservice.Identify;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;
import util.UserCache;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Verify;

public class LoginController implements Initializable {

	@FXML
	Button signin;
	@FXML
	Button login;
	@FXML
	Button visit;
	@FXML
	Button exit;
	@FXML
	TextField user_name;
	@FXML
	PasswordField password;

	@FXML
	Label name_warning;
	@FXML
	Label pass_warning;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	@FXML
	public void signin(ActionEvent event) {
		URL fxml = LoginUIURLConfig.signin_fxml_url();
		URL css = LoginUIURLConfig.signin_css_url();
		Window owner = WindowGrab.getWindow(event);
		WindowGrab.startWindow(owner, "注册", fxml, css);
	}

	@FXML
	public void login(ActionEvent event) {
		String name = user_name.getText();
		String pass = password.getText();
		Window window = WindowGrab.getWindow(event);
		boolean name_in = CheckUtil.checkText(user_name);
		boolean pass_in = CheckUtil.checkText(password);
		if (!name_in) {
			name_warning.setText("请输入用户名");
		}
		if (!pass_in) {
			pass_warning.setText("请输入密码");
		}
		if (name_in && pass_in) {
			// TODO : check the internet
			try {
				Identify identify = ControllerFactory.getIdentityService();
				ResultMessage_Verify type = identify.login(name, pass);
				if (type == ResultMessage_Verify.NET_ERROR) {
					WindowGrab.startNetErrorWindow(window);
				} else if (type == ResultMessage_Verify.USER_NOT_EXIST) {
					name_warning.setText("该用户不存在");
				} else {
					UserCache.init_Cache(name);
					switch (type) {
					case CLIENT:
						WindowGrab.changeScene(ClientUIURLConfig.client_menu_fxml_url(),
								ClientUIURLConfig.client_menu_css_url(), event);
						break;
					case STAFF:
						WindowGrab.changeScene(StaffUIURLConfig.staff_main_fxml_url(),
								StaffUIURLConfig.staff_main_css_url(), event);
						break;
					case MARKETER:
						WindowGrab.changeScene(MarketUIURLConfig.market_market_menu_fxml_url(),
								MarketUIURLConfig.market_market_menu_css_url(), event);
						break;
					case MANAGER:
						WindowGrab.changeScene(ManageUIURLConfig.manage_menu_fxml(),
								ManageUIURLConfig.manage_menu_css(), event);
						break;
					default:
						break;
					}
				}
			} catch (NetException | RemoteException e) {
				WindowGrab.startNetErrorWindow(window);
			}
		}
	}

	@FXML
	public void visit(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		WindowGrab.startNoticeWindow(window, "该功能暂时还未开通");
		// TODO : Change to user stage
		// ObservableList<Stage> stage = FXRobotHelper.getStages();
		// Dialog dialog = new Dialog("Test", stage.get(0), "Test");
		// dialog.showDialog();
	}

	@FXML
	public void exit(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	public void userNameModify(MouseEvent event) {
		CheckUtil.checkWarningBefore(name_warning);
	}

	@FXML
	public void passwordModify(MouseEvent event) {
		if (CheckUtil.checkWarningBefore(pass_warning)) {
			password.setText("");
		}
	}

}
