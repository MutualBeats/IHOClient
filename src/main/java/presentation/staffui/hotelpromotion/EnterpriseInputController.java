package presentation.staffui.hotelpromotion;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;

public class EnterpriseInputController implements Initializable{

    @FXML
    private Button confirm;

    @FXML
    private Button cancel;

    @FXML
    private TextField enterprise_input;
    
    /**
     * 酒店列表更新接口
     */
    private UpdateEnterList update;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		update = (UpdateEnterList) resources.getObject("update");
	}

    @FXML
    void confirm(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	if(CheckUtil.checkText(enterprise_input)) {
    		WindowGrab.closeWindow(event);
    		update.update(enterprise_input.getText());
    	} else {
    		WindowGrab.startErrorWindow(window, "请输入正确的企业名称");
    	}
    }

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }
    
}