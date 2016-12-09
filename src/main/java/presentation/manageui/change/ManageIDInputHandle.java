package presentation.manageui.change;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.stage.Window;
import presentation.utilcontroller.InformationBundle;
import presentation.utilcontroller.ResultHandle;
import presentation.utilui.WindowGrab;
import util.resultmessage.ResultMessage_Verify;

public class ManageIDInputHandle implements ResultHandle {

	public void handleResult(String user_name, ResultMessage_Verify result, Window window) {
		// 跳转
		Object information = null;
		try {
			switch (result) {
			case CLIENT:
				information = ControllerFactory.getClientBLServiceInstance().getClientInfo(user_name);
				openClientInformation(information, window);
				break;
			case MARKETER:
				information = ControllerFactory.getMarketerBLServiceInstance().showData(user_name);
				openMarketerInformation(information, window);
				break;
			case MANAGER:
				information = ControllerFactory.getManagerBLServiceInstance().getManagerInfor();
				openManageInformation(information, window);
				break;
			case STAFF:
				information = ControllerFactory.getStaffBLServiceInstance().showData(user_name);
				openStaffInformation(information, window);
				break;
			default:
				throw new RemoteException();
			}
		} catch (Exception e) {
			WindowGrab.startNetErrorWindow(window);
		}

	}

	private void openManageInformation(Object info, Window window) {
		openInformation(new InformationBundle(info), null, window);
	}

	private void openStaffInformation(Object info, Window window) {
		openInformation(new InformationBundle(info), null, window);
	}

	private void openMarketerInformation(Object info, Window window) {
		openInformation(new InformationBundle(info), null, window);
	}

	private void openClientInformation(Object info, Window window) {
		openInformation(new InformationBundle(info), null, window);
	}

	private void openInformation(ResourceBundle bundle, URL fxml, Window window) {
		WindowGrab.startWindowWithBundle(window, "人员信息", fxml, null, bundle);
	}

}
