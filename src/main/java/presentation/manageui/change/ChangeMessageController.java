package presentation.manageui.change;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import presentation.manageui.change.confirm.Confirm;

public class ChangeMessageController implements Initializable{
	
    @FXML
    private Button cancel;

    @FXML
    void cancel(ActionEvent event) {
        ChangeMessage.stage.close();
    }
    
    @FXML
    void add_people(ActionEvent event) {
    	Stage stage=new Stage();
    	Confirm confirm=new Confirm();
    	try {
    		confirm.start(stage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
