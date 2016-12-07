package presentation.clientui.browseorder;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import presentation.utilui.WindowGrab;

public class BrowseOrderController {

	@FXML
    private Button logout;

    @FXML
    private Button revoked_order;

    @FXML
    private Button executed_order;

    @FXML
    private Label user_name;

    @FXML
    private Button unusual_order;

    @FXML
    private Button all_order;

    @FXML
    private Label title;
    
    @FXML
    private Button unexcuted_order;
    
    @FXML
    private Button unexecuted_order;
    @FXML
    void logout(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

}

