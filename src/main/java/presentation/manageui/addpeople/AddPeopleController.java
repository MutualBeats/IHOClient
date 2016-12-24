package presentation.manageui.addpeople;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogicservice.userblservice.ManagerBLService;
import config.urlconfig.ManageUIURLConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Window;
import presentation.bundle.ManageIDInputHandle;
import presentation.bundle.PeopleListBundle;
import presentation.utilcontroller.Confirm;
import presentation.utilcontroller.RegistCheckController;
import presentation.utilui.ResultDeal;
import presentation.utilui.WindowGrab;
import util.MD5;
import util.exception.NetException;
import util.resultmessage.ResultMessage_User;
import vo.user.ClientVO;
import vo.user.ManagerVO;
import vo.user.MarketerVO;
import vo.user.StaffVO;

public class AddPeopleController extends RegistCheckController implements Initializable, Confirm {

	@FXML
    private Button cancel;
	
	@FXML
	protected void confirm(ActionEvent event) {
		//确认窗口
		boolean inputOK = checkInputFormatter();
		if (inputOK) {
			Window window = WindowGrab.getWindow(event);
			if(checkName(window)) {
				WindowGrab.startConfirmWindow(window, this, "是否确认添加人员？");
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	@Override
	public void confirm() {
		ResultMessage_User result = ResultMessage_User.Register_Success;
		Window window = WindowGrab.getWindowByStage(0);
		String id = user_name.getText();
		String u_name = name.getText();
		String contactWay = phone.getText();
		MarketerVO info = new MarketerVO(id, u_name, contactWay);
		String password = ps.getText();
		password = MD5.md5(password);
		try {
			result = ControllerFactory.getManagerBLServiceInstance().addMarketer(info, password);
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
			return;
		}

		ResultDeal.checkResult(result, window);

	}
	
	@FXML
    void on_check(ActionEvent event) {
		Scene frame=WindowGrab.getScene(event);
		try {
			//获取展示人员信息
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
    void on_change(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startIDInputWindow(window, new ManageIDInputHandle());
	
    }

    @FXML
    void addhotel(ActionEvent event) {
    	WindowGrab.changeScene(ManageUIURLConfig.manage_add_hotel_one_fxml(), ManageUIURLConfig.manage_add_hotel_one_css(), event);
    }

    @FXML
    void peopleInfo(ActionEvent event) {
    	WindowGrab.changeScene(ManageUIURLConfig.manage_menu_fxml(), ManageUIURLConfig.manage_menu_css(), event);
    }
}
