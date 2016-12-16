package presentation.clientui.searchhotel;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SearchHotelController extends HotelListController{
	
    @FXML
    private Button search;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	super.initialize(location, resources);
    }
    
    @FXML
    void on_search(ActionEvent event) {
    	
    }

    @FXML
    void check(ActionEvent event) {

    }
  
}
