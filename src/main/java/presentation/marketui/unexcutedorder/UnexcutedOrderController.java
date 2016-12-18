/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.marketui.unexcutedorder;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import presentation.marketui.utilui.OrderListView;
import presentation.utilui.WindowGrab;
import util.exception.NetException;
import vo.order.OrderVO;

public class UnexcutedOrderController extends OrderListView{


    @FXML
    private TableColumn<OrderVO,String> user_name;

    @FXML
    private TableColumn<OrderVO,String> contact;


    @FXML
    private TableColumn<OrderVO,String> id;

    @FXML
    private TableView<OrderVO> order_list;

    @FXML
    private TableColumn<OrderVO,String> hotelname;

    

	@Override
	@SuppressWarnings("unchecked")
	public void initialize(URL location, ResourceBundle resources) {
		ArrayList<OrderVO> unexecute_order=(ArrayList<OrderVO>) resources.getObject("order_list");
		order_list.getItems().addAll(unexecute_order);
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



}
