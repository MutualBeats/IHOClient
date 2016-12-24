package presentation.utilcontroller;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import presentation.utilui.WindowGrab;

/**
 * 
 * 通用信息提示界面
 * 
 * @author heleninsa
 *
 */
public class NoticeController implements Initializable{

    @FXML
    private Button confirm;

    @FXML
    private Label notice;
    
    @FXML
    void confirm(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String error_message = resources.getString("error_message");
		notice.setText(error_message);
	}

}
