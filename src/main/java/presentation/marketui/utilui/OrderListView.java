package presentation.marketui.utilui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class OrderListView {
	
	@FXML
    private Button cancel;

    @FXML
    private TextField id_text;

    @FXML
    private Button search;
    
    @FXML
    private Button check;

    @FXML
    private TableColumn<?, ?> user_name;

    @FXML
    private TableColumn<?, ?> contact;

    @FXML
    private Label unexcuted_order_title;

  

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableView<?> order_list;

    @FXML
    private TableColumn<?, ?> hotelname;

    
    
    @FXML
    void cancel(ActionEvent event) {

    }

    @FXML
    void on_check(ActionEvent event) {

    }

    @FXML
    void on_search(ActionEvent event) {

    }

}
