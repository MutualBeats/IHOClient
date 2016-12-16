package presentation.marketui.unusualorder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogic.orderbl.Order;
import bussinesslogic.orderbl.OrderController;
import config.urlconfig.MarketUIURLConfig;
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
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.stage.Window;
import presentation.marketui.utilui.OrderListView;
import presentation.utilcontroller.OrderInfoBundle;
import presentation.utilui.WindowGrab;
import util.exception.NetException;
import util.order.OrderState;
import util.resultmessage.ResultMessage_Credit;
import util.resultmessage.ResultMessage_Order;
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
	 final ToggleGroup buttom_group = new ToggleGroup();
	
	 private static URL APPEAL_FXML;
	 private static URL APPEAL_CSS;
	 
	 private static URL UNUSUAL_ORDER_FXML;
	 private static URL UNUSUAL_ORDER_CSS;
	 
	 static{
		 try {
			APPEAL_FXML=new URL("file: src/main/resources/ui/marketui/fxml/appeal_credit.fxml");
			APPEAL_CSS=new URL("file: src/main/resources/ui/marketui/css/appeal_credit.css");
			
			UNUSUAL_ORDER_FXML=new URL("file: src/main/resources/ui/marketui/fxml/unusual_order.fxml");
			UNUSUAL_ORDER_CSS=new URL("file: src/main/resources/ui/marketui/css/unusual_order.css");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 
	 
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
		 // TODO Auto-generated method stub
		ArrayList< OrderVO> unusual=(ArrayList<OrderVO>)resources.getObject("unusual");
		unusual_orderlist.addAll(unusual);
		
		order_list.setItems(unusual_orderlist);
		
		initColumn();
	}
	    
	 private void initColumn(){
		 order_id.setCellValueFactory(celldata->celldata.getValue().getId_property());
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
    void check(ActionEvent event) {
    	
    }

    @FXML
    void on_search(ActionEvent event) {
    	
    }
    
    
    @FXML
    void on_revoke(ActionEvent event) {
    	// Revoke Order
    	Window	window=WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "恢复信用值", APPEAL_FXML, APPEAL_CSS);
    	
    	boolean recovery=AppealController.all_credit;
    	
    	revoke(event,recovery);
    }

    
    void revoke(ActionEvent event,boolean recovery){
    	TableViewSelectionModel<OrderVO> model = order_list.getSelectionModel();
    	Window window = WindowGrab.getWindow(event);
    	int select_index = model.getSelectedIndex();
    	if (select_index == -1) {
    		WindowGrab.startNoticeWindow(window, "请选择要撤销的订单");
    	}
    	else{
    		OrderVO info = model.getSelectedItem();
    		String order_ID = order_id.getCellData(model.getSelectedIndex());
    		ResultMessage_Order result=ResultMessage_Order.Appeal_Successful;
    		
    		try {
				result=ControllerFactory.getOrderBLServiceInstance().appeal(order_ID, recovery);
			} catch (NetException e) {
				// TODO Auto-generated catch block
				WindowGrab.startNetErrorWindow(window);
				return;
			}
    		if(result==ResultMessage_Order.Appeal_Successful){
    			WindowGrab.startNoticeWindow(window, "撤销订单成功！");
    			//本地刷新记录
    			WindowGrab.closeWindow(event);
    			WindowGrab.startWindow(window, "查看异常订单", UNUSUAL_ORDER_FXML, UNUSUAL_ORDER_CSS);
    		}
    		else{
    			WindowGrab.startNoticeWindow(window, "撤销订单失败！");
    			
    		}
    	}
    }
}
