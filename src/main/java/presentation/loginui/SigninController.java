package presentation.loginui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import presentation.utilcontroller.RegistCheckController;
import presentation.utilui.WindowGrab;

public class SigninController extends RegistCheckController implements Initializable{
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	@FXML
	protected void confirm(ActionEvent event) {
		boolean formatter_check = checkInputFormatter();
		if(formatter_check) {
			//TODO : Pass the check
			
		}
	}
	
	@FXML
	public void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}
	@FXML
    void b22e2e(ActionEvent event) {

    }
		
}
