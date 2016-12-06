package presentation.manageui.change;


import java.util.Enumeration;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import config.NumberConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;
import util.resultmessage.ResultMessage_Verify;

public class IDInputController {

    @FXML
    private Button cancel;

    @FXML
    private Button search;
    
    @FXML
    private TextField id_input;

    @FXML
    void on_search(ActionEvent event) {
    	String id = id_input.getText();
    	ResultMessage_Verify result = ResultMessage_Verify.USER_NOT_EXIST;
    	Window window = WindowGrab.getWindow(event);
    	if(NumberConfig.userNameFormatterCheck(id)) {
    		try {
				result = ControllerFactory.getIdentityService().checkIdentity(id);
			} catch (Exception e) {
				result = ResultMessage_Verify.NET_ERROR;
			}
    	}
    	handleResult(result, window);
    }

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }
    
    private void handleResult(ResultMessage_Verify result, Window window) {
    	if(result == ResultMessage_Verify.NET_ERROR || result == ResultMessage_Verify.USER_NOT_EXIST ) {
    		String error_message = result.toString();
    		WindowGrab.startErrorWindow(window, error_message);
    	} else {
    		//跳转
    		System.out.println("Jump");
    	}
    }
    
    class InformationBundle extends ResourceBundle {

    	private Object information;   
    	private final static String INFOR_MATION_KEY = "info";
    	
		public InformationBundle(Object information) {
			super();
			this.information = information;
		}

		@Override
		protected Object handleGetObject(String key) {
			if(INFOR_MATION_KEY.equals(key)) {
				return information;
			}
			return null;
		}

		@Override
		public Enumeration<String> getKeys() {
			return null;
		}
    	
    }
    
}
