package presentation.marketui.webpromotion;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Window;
import presentation.utilcontroller.Confirm;
import presentation.utilui.WindowGrab;

public class WebPromotionCreateController implements Confirm{

    @FXML
    private Button cancel;

    @FXML
    private Button confirm;

    @FXML
    private Pane field;

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void confirm(ActionEvent event) {
    	Window window=WindowGrab.getWindow(event);
    	WindowGrab.startConfirmWindow(window, this, "是否确认新建 ？");
    }

	@Override
	public void confirm() {
		// TODO Auto-generated method stub
		
	}

}
