package presentation.manageui.check;

import java.net.URL;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import config.urlconfig.ManageUIURLConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Window;
import presentation.bundle.ManageIDInputHandle;
import presentation.utilui.WindowGrab;
import util.resultmessage.ResultMessage_User;
import vo.user.ClientInfoChangeVO;
import vo.user.ClientVO;

public class ClientInformationController extends InformationLookController {

	@FXML
	private Label member_type;

	@FXML
	private Label member_info;

	@FXML
	private Label credit;

	@FXML
	private Label member_level;

	protected ClientVO info;

	@FXML
    private Button addhotel;

    @FXML
    private Button addpeople;

    @FXML
    private Button peopleInfo;
	
    @FXML
    private Button change;
    
    @FXML
    private Button check;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		info = (ClientVO) resources.getObject("info");
		init();
	}

	private void init() {
		this.user_name.setText(info.id);
		this.name.setText(info.name);
		this.phone.setText(info.contactWay);
		this.credit.setText(info.credit + "");
		this.member_info.setText(info.memberMessage);
		this.member_type.setText(info.memberType.toString());
		this.member_level.setText(info.level + "");
		this.type.setText("客户");
	}
	
	@Override
	protected void toInfoState() {
		super.toInfoState();
		name.setText(info.name);
		phone.setText(info.contactWay);
	}
	
	@Override
	public void confirm() {
		Window window = WindowGrab.getWindowByStage(1);
		ClientInfoChangeVO vo = new ClientInfoChangeVO(info.id, name.getText(), phone.getText());
		ResultMessage_User result = ResultMessage_User.UpdateSuccess;
		try {
			result = ControllerFactory.getManagerBLServiceInstance().changeClientInfo(vo);
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
	
	@FXML
    void peopleInfo(ActionEvent event) {
		WindowGrab.changeScene(ManageUIURLConfig.manage_menu_fxml(), ManageUIURLConfig.manage_menu_css(), event);
    }

    @FXML
    void on_change(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startIDInputWindow(window, new ManageIDInputHandle());
    }

    @FXML
    void addhotel(ActionEvent event) {
    	WindowGrab.changeScene(ManageUIURLConfig.manage_add_hotel_one_fxml(), ManageUIURLConfig.manage_add_hotel_one_css(), event);
    }

    @FXML
    void add_people(ActionEvent event) {
    	WindowGrab.changeScene(ManageUIURLConfig.manage_add_people_fxml(), ManageUIURLConfig.manage_add_people_css(), event);
    }
	
}
