/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation.manageui.mainmanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import presentation.manageui.addhotel.AddHotel;
import presentation.manageui.addpeople.AddPeople;

public class ManageController {

    @FXML
    private Button search;

    @FXML
    private MenuItem change;

    @FXML
    private Button add_hotel;

    @FXML
    private MenuItem add_people;

    @FXML
    private Button look;

    @FXML
    void add78f(ActionEvent event) {

    }

    @FXML
    void fffbe5(ActionEvent event) {

    }

    @FXML
    void bfbe97(ActionEvent event) {

    }

    @FXML
    void d9a96a(ActionEvent event) {

    }

    @FXML
    void bfe5a5(ActionEvent event) {

    }

    @FXML
    void on_Search(ActionEvent event) {

    }

    @FXML
    void add_people(ActionEvent event) {
    	Stage stage=new Stage();
    	AddPeople people=new AddPeople();
    	try {
    		people.start(stage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void on_change(ActionEvent event) {

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

    @FXML
    void on_Look(ActionEvent event) {

    }

}



