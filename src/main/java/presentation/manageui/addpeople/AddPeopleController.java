package presentation.manageui.addpeople;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class AddPeopleController implements Initializable{
	
    @FXML
    private Button cancel;

    @FXML
    void cancel(ActionEvent event) {
        AddPeople.stage.close();
    }
    
    @FXML
    void add_people(ActionEvent event) {

    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
