package presentation.manageui.check;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class InformationLookController implements Initializable {

	@FXML
	private Button cancel;

	@FXML
	private TextField phone;

	@FXML
	private TextField user_name;

	@FXML
	private Button change;

	@FXML
	private TextField name;

	@FXML
	private TextField type;

	@FXML
	private Label phone_warning;

	@FXML
	private Label name_warning;
	
	private boolean modify_state = false;
	
//	private 
	
	 private static URL CHANGE_MESSAGE_CONFIRM_FXML;
	    private static URL CHANGE_MESSAGE_CONFIRM_CSS;
	    static{
	    	try {
	    		CHANGE_MESSAGE_CONFIRM_FXML = new URL("file:src/main/resources/ui/manageui/fxml/changemessageconfirm.fxml");
	    		CHANGE_MESSAGE_CONFIRM_CSS = new URL("file:src/main/resources/ui/manageui/css/changemessageconfirm.css");
	    	} catch (MalformedURLException e) {
				e.printStackTrace();
			}
	    	
	    }
	
	public static InformationLookController controller;

	@FXML
	void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

	@FXML
	void change(ActionEvent event) {
		if(!modify_state) {
			//进入修改状态
			toModifyState();
		} else {
			//修改确认
//			toInfoState();
			Window window = WindowGrab.getWindow(event);
	    	WindowGrab.startWindow(window, "修改人员信息",CHANGE_MESSAGE_CONFIRM_FXML,CHANGE_MESSAGE_CONFIRM_CSS);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		controller = this;
	}
	
	private void toModifyState() {
		name.setEditable(true);
		phone.setEditable(true);
		change.setText("确认");
		modify_state = true;
	}
	
	protected void toInfoState() {
		
		
		
		name.setEditable(false);
		phone.setEditable(false);
		change.setText("修改");
		modify_state = false;
		//Modify by server;
		
	}
	
}
