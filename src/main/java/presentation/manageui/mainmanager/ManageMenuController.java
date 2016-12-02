package presentation.manageui.mainmanager;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;
import presentation.manageui.addhotel.AddHotel;
import presentation.manageui.addpeople.AddPeople;
import presentation.manageui.addpeople.AddPeopleMenu;
import presentation.manageui.change.ChangeMessage;
import presentation.utilui.WindowGrab;

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
    	Window window = WindowGrab.getWindow(event);
    	try {
			WindowGrab.startWindow(window, new URL("file:src/main/resources/ui/manageui/fxml/addpeoplemenu.fxml"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    }

    @FXML
    void on_change(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	try {
			WindowGrab.startWindow(window, new URL("file:src/main/resources/ui/manageui/fxml/changemessage.fxml"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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

