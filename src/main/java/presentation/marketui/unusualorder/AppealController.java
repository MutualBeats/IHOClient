package presentation.marketui.unusualorder;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import presentation.utilui.WindowGrab;

public class AppealController implements Initializable{

    @FXML
    private Button all;

    @FXML
    private Button half;

    @FXML
    private Text confirm_text;
    
    private ChooseCredit choose;
    
    @FXML
    void all(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    	choose.choose(true);
    }

    @FXML
    void half(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    	choose.choose(false);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		choose = (ChooseCredit) resources.getObject("choose");
	}
}
