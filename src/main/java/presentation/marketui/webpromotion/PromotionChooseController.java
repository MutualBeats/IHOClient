package presentation.marketui.webpromotion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import presentation.utilui.WindowGrab;

public class PromotionChooseController {

	@FXML
    private Button cancel;

    @FXML
    private Button create;
	
    @FXML
    void create(ActionEvent event) {
    	
    }

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

}

