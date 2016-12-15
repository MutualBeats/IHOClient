/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.marketui.unexcutedorder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.naming.ldap.ControlFactory;
import javax.swing.text.SimpleAttributeSet;

import org.dom4j.tree.SingleIterator;

import bussinesslogic.controllerfactory.ControllerFactory;
import config.urlconfig.ManageUIURLConfig;
import config.urlconfig.MarketUIURLConfig;
import config.urlconfig.UtilUIURLConfig;
import javafx.beans.property.SimpleStringProperty;
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
import util.exception.NetException;
import vo.order.OrderVO;
import vo.user.ClientVO;

public class UnexcutedOrderController extends OrderListView{

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
    private Label unexcuted_order_title;

    @FXML
    private Button check;

    @FXML
    private TableColumn<OrderVO,String> id;

    @FXML
    private TableView<OrderVO> order_list;

    @FXML
    private TableColumn<OrderVO,String> hotelname;

    private ObservableList<OrderVO> unexecute_orderlist=FXCollections.observableArrayList();
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ArrayList<OrderVO> unexecute_order=(ArrayList<OrderVO>) resources.getObject("unexecuted");
		unexecute_orderlist.addAll(unexecute_order);
		
		order_list.setItems(unexecute_orderlist);
		
		initColumn();
	}
	
	private void initColumn(){
		id.setCellValueFactory(celldata->celldata.getValue().getId_property());
//		 ControllerFactory.getClientBLServiceInstance().getClientInfo(clientID)
		user_name.setCellValueFactory(celldata->{
			try {
				return ControllerFactory.getClientBLServiceInstance().getClientInfo(celldata.getValue().clientID).getName_property();
			} catch (NetException e1) {
				// TODO Net Exception
				
				return new SimpleStringProperty("");
			}
		});

		contact.setCellValueFactory(celldata->{
			try{
				return ControllerFactory.getClientBLServiceInstance().getClientInfo(celldata.getValue().clientID).getContact_property();
			}catch (NetException e) {
				// TODO: Net Exception 
				return new SimpleStringProperty("");
			}
		});
		
		hotelname.setCellValueFactory(celldata -> { 
			try{
				return new SimpleStringProperty(ControllerFactory.getHotelBLServiceInstance()
						.showHotelInfo(celldata.getValue().getHotel_property().getValue()).hotelName);
			}catch (NetException e) {
				// TODO: handle exception
				WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(0));
				return new SimpleStringProperty("");
			}
		});
	}
	
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
