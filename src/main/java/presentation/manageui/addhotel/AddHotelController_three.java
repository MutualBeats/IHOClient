package presentation.manageui.addhotel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import presentation.utilui.WindowGrab;

public class AddHotelController_three {

	@FXML
    private Button third_cancel;

    @FXML
    private AnchorPane third_pane;

    @FXML
    private Button third_confirm;

    
    @FXML
    void third_confirm(ActionEvent event) {
    	
    }

    @FXML
    void third_cancel(ActionEvent event){
    	WindowGrab.closeWindow(event);
    }

}
