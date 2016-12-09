package presentation.marketui.credit;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.stage.Window;
import presentation.utilcontroller.ResultHandle;
import presentation.utilui.WindowGrab;
import util.resultmessage.ResultMessage_Verify;
import vo.user.ClientVO;

public class CreditIDInputHandle implements ResultHandle {

	@Override
	public void handleResult(String user_name, ResultMessage_Verify result, Window window) {
		if (result == ResultMessage_Verify.CLIENT) {
			try {
				ClientVO info = ControllerFactory.getClientBLServiceInstance().getClientInfo(user_name);
				
			} catch (Exception e) {
				WindowGrab.startNetErrorWindow(window);
			}
		} else {
			String error_message = "请输入正确的用户名";
			WindowGrab.startErrorWindow(window, error_message);
		}
	}

}
