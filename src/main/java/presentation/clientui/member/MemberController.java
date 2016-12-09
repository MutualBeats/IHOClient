package presentation.clientui.member;


import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Window;
import presentation.utilcontroller.Confirm;
import presentation.utilui.WindowGrab;

public class MemberController implements Confirm{

	@FXML
    private Button cancel;

    @FXML
    private Button confirm;

    @FXML
    private Pane original_pane;

    @FXML
    private Pane business_pane;

    @FXML
    private Label title;

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void confirm(ActionEvent event) {
    	Window window=WindowGrab.getWindow(event);
    	WindowGrab.startConfirmWindow(window, this);
    }
    
    @FXML
    void original_member(ActionEvent event) {
    	business_pane.setVisible(false);
    	original_pane.setVisible(true);
    }

    @FXML
    void business_member(ActionEvent event) {
    	original_pane.setVisible(false);
    	business_pane.setVisible(true);
    }

	@Override
	public void confirm() {
		// TODO Auto-generated method stub
		
	}
}

