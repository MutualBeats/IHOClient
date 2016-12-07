package presentation.clientui.mainclient;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import presentation.utilui.WindowGrab;

public class MainClientController {

    @FXML
    private Pane pane_browseorder;

    @FXML
    private Label user_name;

    @FXML
    private Label createorder;

    @FXML
    private Label maintainmessage;

    @FXML
    private Button all_order;

    @FXML
    private Label title;

    @FXML
    private Label menu;

    @FXML
    private Label revokeorder;

    @FXML
    private Button execute_order;

    @FXML
    private Label evaluatehotel;

    @FXML
    private TextField input;

    @FXML
    private Button search;

    @FXML
    private Button revoked_order;

    @FXML
    private Button logout;

    @FXML
    private Label browseorder;

    @FXML
    private Button unexecute_order;

    @FXML
    private Label member;

    @FXML
    private Button unusual_order;

    @FXML
    void logout(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

}

