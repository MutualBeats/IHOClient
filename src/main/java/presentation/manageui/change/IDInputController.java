package presentation.manageui.change;


import java.rmi.RemoteException;

import bussinesslogic.controllerfactory.ControllerFactory;
import config.NumberConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    	if(NumberConfig.userNameFormatterCheck(id)) {
    		ResultMessage_Verify result = ResultMessage_Verify.USER_NOT_EXIST;
    		try {
				result = ControllerFactory.getIdentityService().checkIdentity(id);
			} catch (RemoteException e) {
				e.printStackTrace();
				result = ResultMessage_Verify.NET_ERROR;
			}
    	}
    }

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }
    
    
    
}
