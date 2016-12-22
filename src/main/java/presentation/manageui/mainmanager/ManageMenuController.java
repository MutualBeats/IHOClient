package presentation.manageui.mainmanager;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogicservice.userblservice.ManagerBLService;
import config.urlconfig.LoginUIURLConfig;
import config.urlconfig.ManageUIURLConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Window;
import presentation.bundle.ManageIDInputHandle;
import presentation.bundle.PeopleListBundle;
import presentation.utilui.WindowGrab;
import util.UserCache;
import util.exception.NetException;
import vo.user.ClientVO;
import vo.user.ManagerVO;
import vo.user.MarketerVO;
import vo.user.StaffVO;

public class ManageMenuController implements Initializable {

	@FXML
    private Button addhotel;

    @FXML
    private Button addpeople;

    @FXML
    private Button change;

    @FXML
    private Button logout;
    
    @FXML
    private Label contact;

    @FXML
    private Label manageID;

    @FXML
    private Pane pane;

    @FXML
    private Label photo;

    @FXML
    private Button check;

    @FXML
    private Label managerName;


	@FXML
	void on_check(ActionEvent event) {
		Scene frame=WindowGrab.getScene(event);
		try {
			ManagerBLService mService = ControllerFactory.getManagerBLServiceInstance();
			ArrayList<ClientVO> clientVOs = mService.getClientList();
			ArrayList<StaffVO> staffVOs = mService.getStaffList();
			ArrayList<MarketerVO> marketerVOs = mService.getMarketerList();
			ManagerVO managerVO = mService.getManagerInfor();
			PeopleListBundle bundle = new PeopleListBundle(clientVOs, staffVOs, marketerVOs, managerVO);
			WindowGrab.changeSceneWithBundle(ManageUIURLConfig.manage_check_menu_fxml(), ManageUIURLConfig.manage_check_menu_css(), frame, bundle);
		} catch (NetException e) {
			Window window=WindowGrab.getWindow(event);
			WindowGrab.startNetErrorWindow(window);
		}
	}

	@FXML
	void add_people(ActionEvent event) {
		WindowGrab.changeScene(ManageUIURLConfig.manage_add_people_fxml(), ManageUIURLConfig.manage_add_people_css(), event);
	}

	@FXML
	void on_change(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		WindowGrab.startIDInputWindow(window, new ManageIDInputHandle());
	}

	@FXML
	void add_hotel(ActionEvent event) {
		WindowGrab.changeScene(ManageUIURLConfig.manage_add_hotel_one_fxml(), ManageUIURLConfig.manage_add_hotel_one_css(), event);
	}

	@FXML
	void logout(ActionEvent event) {
		Window window =WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, "Login", LoginUIURLConfig.login_fxml_url(), LoginUIURLConfig.login_css_url());
	}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		manageID.setText(UserCache.getID());
		try {
			managerName.setText(ControllerFactory.getManagerBLServiceInstance().getManagerInfor().name);
			contact.setText(ControllerFactory.getManagerBLServiceInstance().getManagerInfor().contactWay);
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(0));
		}
	}

}
