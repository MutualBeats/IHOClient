package presentation.marketui.unusualorder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import config.urlconfig.MarketUIURLConfig;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import presentation.marketui.utilui.OrderListView;
import presentation.utilui.WindowGrab;
import vo.order.OrderVO;

public class UnusualOrderController extends OrderListView{

	 @FXML
	 private Button cancel;
	 
	 @FXML
	 private TextField id_text;
	 
	 @FXML
	 private Button search;
	 
	 @FXML
	 private TableColumn<OrderVO,String> user_name;
	 
	 @FXML
	 private TableColumn<OrderVO,String> contact;
	 
	 @FXML
	 private Button revoke;
	 
	 @FXML
	 private Button check;

	 @FXML
	 private TableColumn<OrderVO,String> order_id;
	 
	 @FXML
	 private TableView<OrderVO> order_list;
	 
	 @FXML
	 private Label unusualorder_title;

	 @FXML
	 private TableColumn<OrderVO,String> hotelname;
	
	
	 private ObservableList<OrderVO> unusual_orderlist=FXCollections.observableArrayList();
	    

	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
		 // TODO Auto-generated method stub
		ArrayList< OrderVO> unusual=(ArrayList<OrderVO>)resources.getObject("unusual");
		unusual_orderlist.addAll(unusual);
		
		order_list.setItems(unusual_orderlist);
		
		initColumn();
	}
	    
	 private void initColumn(){
		 
	 }
    @FXML
    void cancel(ActionEvent event) {
    	
    }

    @FXML
    void check(ActionEvent event) {
    	
    }

    @FXML
    void on_search(ActionEvent event) {

    }
    @FXML
    void on_revoke(ActionEvent event) {

    }

}
