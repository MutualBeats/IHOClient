package presentation.bundle;

import java.rmi.RemoteException;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.stage.Window;
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
				WindowGrab.openClientInformation(information, window);
				break;
			case MARKETER:
				information = ControllerFactory.getMarketerBLServiceInstance().showData(user_name);
				WindowGrab.openMarketerInformation(information, window);
				break;
			case MANAGER:
				information = ControllerFactory.getManagerBLServiceInstance().getManagerInfor();
				WindowGrab.openManageInformation(information, window);
				break;
			case STAFF:
				information = ControllerFactory.getStaffBLServiceInstance().showData(user_name);
				WindowGrab.openStaffInformation(information, window);
				break;
			default:
				throw new RemoteException();
			}
		} catch (Exception e) {
			WindowGrab.startNetErrorWindow(window);
		}

	}

}
