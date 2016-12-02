package presentation.manageui.mainmanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import presentation.manageui.addhotel.AddHotel;
import presentation.manageui.addpeople.AddPeople;
import presentation.manageui.addpeople.AddPeopleMenu;
import presentation.manageui.change.ChangeMessage;

public class ManageMenuController {

    @FXML
    private Button addhotel;

    @FXML
    private Button addpeople;

    @FXML
    private Button change;

    @FXML
    private Label manageID;

    @FXML
    private Button Look;

    @FXML
    private Label managerName;

    @FXML
    void faf9eb(ActionEvent event) {

    }

    @FXML
    void on_look(ActionEvent event) {

    }

    @FXML
    void add_people(ActionEvent event) {
    	Stage stage=new Stage();
    	AddPeopleMenu aPeople=new AddPeopleMenu();
    	try {
    		aPeople.start(stage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void on_change(ActionEvent event) {
    	Stage stage=new Stage();
    	ChangeMessage change=new ChangeMessage();
    	try {
			change.start(stage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void add_hotel(ActionEvent event) {
    	Stage stage=new Stage();
    	AddHotel addHotel=new AddHotel();
    	try {
			addHotel.start(stage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}

