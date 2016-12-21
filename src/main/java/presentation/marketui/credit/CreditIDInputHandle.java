package presentation.marketui.credit;

import java.net.MalformedURLException;
import java.net.URL;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.stage.Window;
import presentation.bundle.InformationBundle;
import presentation.utilcontroller.ResultHandle;
import presentation.utilui.WindowGrab;
import util.resultmessage.ResultMessage_Verify;
import vo.user.ClientVO;

public class CreditIDInputHandle implements ResultHandle {

	private static URL CREDIT_EXCUTE_FXML;
    private static URL CREDIT_EXCUTE_CSS;
    
    static{
    	try {
    		
    		CREDIT_EXCUTE_FXML=new URL("file:src/main/resources/ui/marketui/fxml/credit_excute.fxml");
    		CREDIT_EXCUTE_CSS=new URL("file:src/main/resources/ui/marketui/css/credit_excute.css");
    		
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    	
    }
	
	@Override
	public void handleResult(String user_name, ResultMessage_Verify result, Window window) {
		if (result == ResultMessage_Verify.CLIENT) {
			ClientVO info = null;
			try {
				info = ControllerFactory.getClientBLServiceInstance().getClientInfo(user_name);
			} catch (Exception e) {
				WindowGrab.startNetErrorWindow(window);
				return;
			}
			if(info != null) {
				WindowGrab.closeWindow(window);
				WindowGrab.changeSceneWithBundle(CREDIT_EXCUTE_FXML, CREDIT_EXCUTE_CSS, WindowGrab.getSceneByStage(0), new InformationBundle(info));
			}
		} else {
			String error_message = "请输入正确的用户名";
			WindowGrab.startErrorWindow(window, error_message);
		}
	}

}
