package presentation.clientui.maintainmessage;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import presentation.utilui.WindowGrab;
import vo.credit.CreditVO;

public class CreditController implements Initializable{

    @FXML
    private Button cancel;
    
    private TableView<CreditVO> credit_list;
    
    @FXML
    private TableColumn<CreditVO, String> date;

    @FXML
    private TableColumn<CreditVO, Integer> value_of_change;

    @FXML
    private TableColumn<CreditVO, String> reson;

    @FXML
    private TableColumn<CreditVO, Integer> cur_value;

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
     }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		@SuppressWarnings("unchecked")
		ArrayList<CreditVO> credit_change_list = (ArrayList<CreditVO>) resources.getObject("credit");
		ObservableList<CreditVO> credits = FXCollections.observableArrayList();
		credits.addAll(credit_change_list);
		credit_list.setItems(credits);
		//initialize the column of table view
		date.setCellValueFactory(cellData->cellData.getValue().getTime_property());
		value_of_change.setCellValueFactory(cellData->cellData.getValue().getChange_property().asObject());
		reson.setCellValueFactory(cellData->cellData.getValue().getReson_property());
		cur_value.setCellValueFactory(cellData->cellData.getValue().getAfter_property().asObject());
	}

}

