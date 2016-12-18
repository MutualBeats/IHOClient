package presentation.marketui.webpromotion;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import presentation.utilcontroller.Confirm;
import presentation.utilui.WindowGrab;

public class MemberLevelController implements Confirm{

    @FXML
    private Button confirm;

    @FXML
    private Button cancel;

    @FXML
    private TextField credit_lv2;

    @FXML
    private TextField credit_lv3;

    @FXML
    private TextField credit_lv0;

    @FXML
    private TextField credit_lv1;

    @FXML
    private AnchorPane l;

    @FXML
    private TextField discount_lv2;

    @FXML
    private TextField discount_lv3;

    @FXML
    private TextField discount_lv0;

    @FXML
    private TextField discount_lv1;

    @FXML
    void confirm(ActionEvent event) {
    	Window window=WindowGrab.getWindow(event);
    	WindowGrab.startConfirmWindow(window, this, "是否确认该操作？");
    }

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void creditModify(ActionEvent event) {
    	
    }


    @FXML
    void discountModify(ActionEvent event) {

    }

	@Override
	public void confirm() {
		// TODO Auto-generated method stub
		
	}


}

