package presentation.marketui.webpromotion;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import presentation.utilui.WindowGrab;

public class TimeDiscountController {

    @FXML
    private Button confirm;

    @FXML
    private Button cancel;
    

    @FXML
    private DatePicker start_time;

    @FXML
    private Label discount_warning;

    @FXML
    private Label etime_warning;

    @FXML
    private TextField name;

    @FXML
    private DatePicker end_time;

    @FXML
    private ComboBox<?> discount;

    @FXML
    private Label name_warning;

    @FXML
    private Label stime_warning;
    
    @FXML
    void confirm(ActionEvent event) {

    }

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }
    
    @FXML
    void nameModify(ActionEvent event) {

    }

    @FXML
    void stimeModify(ActionEvent event) {

    }

    @FXML
    void etimeModify(ActionEvent event) {

    }

    @FXML
    void discountModify(ActionEvent event) {

    }


}

