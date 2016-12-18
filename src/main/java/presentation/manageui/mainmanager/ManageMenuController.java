package presentation.manageui.mainmanager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogicservice.userblservice.ManagerBLService;
import config.urlconfig.ManageUIURLConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
	private Label manageID;

	@FXML
	private Pane hotel_pane;

	@FXML
	private Pane people_pane;

	@FXML
	private Button check;

	@FXML
	private Label managerName;

	@FXML
	private Label title;

	private static URL menu_fxml;
	private static URL menu_css;

	static {

		try {
			menu_fxml = new URL("file:src/main/resources/ui/manageui/fxml/check_menu.fxml");
			menu_css = new URL("file:src/main/resources/ui/manageui/css/check_menu.css");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void on_check(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		try {
			ManagerBLService mService = ControllerFactory.getManagerBLServiceInstance();
			ArrayList<ClientVO> clientVOs = mService.getClientList();
			ArrayList<StaffVO> staffVOs = mService.getStaffList();
			ArrayList<MarketerVO> marketerVOs = mService.getMarketerList();
			ManagerVO managerVO = mService.getManagerInfor();
			PeopleListBundle bundle = new PeopleListBundle(clientVOs, staffVOs, marketerVOs, managerVO);
			WindowGrab.startWindowWithBundle(window, "查询人员信息", menu_fxml, menu_css, bundle);
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
		}
	}

	@FXML
	void add_people(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, "添加营销人员", ManageUIURLConfig.manage_add_people_fxml(),
				ManageUIURLConfig.manage_add_people_css());
	}

	@FXML
	void on_change(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		WindowGrab.startIDInputWindow(window, new ManageIDInputHandle());
	}

	@FXML
	void add_hotel(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, "添加酒店", ManageUIURLConfig.manage_add_hotel_one_fxml(),
				ManageUIURLConfig.manage_add_hotel_one_css());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		manageID.setText(UserCache.getID());
		try {
			managerName.setText(ControllerFactory.getManagerBLServiceInstance().getManagerInfor().name);
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(0));
		}
	}

}
