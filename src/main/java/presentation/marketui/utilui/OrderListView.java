package presentation.marketui.utilui;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import com.sun.javafx.collections.ObservableListWrapper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.stage.Window;
import presentation.bundle.OrderInfoBundle;
import presentation.utilui.WindowGrab;
import vo.order.OrderVO;
import vo.user.BaseVO;

public abstract class OrderListView implements Initializable {

	@FXML
	private Label unexcuted_order_title;

	@FXML
	private Button cancel;

	@FXML
	private TextField id_text;

	@FXML
	private Button search;

	@FXML
	private Button check;

	@FXML
	private TableView<OrderVO> order_list;

	@FXML
	private TableColumn<OrderVO, String> user_name;

	@FXML
	private TableColumn<OrderVO, String> contact;

	@FXML
	private TableColumn<OrderVO, String> id;

	@FXML
    private Label promotionName;
	
	@FXML
	private TableColumn<OrderVO, String> hotelname;
	
	private ObservableList<OrderVO> orderList = FXCollections.observableArrayList();
	
	private static URL ORDER_INFO_FXML;
    private static URL ORDER_INFO_CSS;
    
    static{
    	try {
			ORDER_INFO_FXML= new URL("file:src/main/resources/ui/utilui/fxml/order_information.fxml");
			ORDER_INFO_CSS=new URL("file:src/main/resources/ui/utilui/css/order_information.css");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	
	@Override
	public  abstract void initialize(URL location, ResourceBundle resources);
	
	@FXML
	void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

	@FXML
	void on_check(ActionEvent event) {
		// Check Order Information
		TableViewSelectionModel<OrderVO> model = order_list.getSelectionModel();
		Window window = WindowGrab.getWindow(event);
		int select_index = model.getSelectedIndex();
		if (select_index == -1) {
			WindowGrab.startNoticeWindow(window, "请选择要查看的订单");
		} 
		else {
			OrderVO info = model.getSelectedItem();
			// TODO : the reach of hotel name is waiting to check.
			String hotel_name = hotelname.getCellData(model.getSelectedIndex());
			String promotion_name=promotionName.getText();
			OrderInfoBundle bundle = new OrderInfoBundle(info, hotel_name, promotion_name);
			
			WindowGrab.startWindowWithBundle(window, "订单详情", ORDER_INFO_FXML, ORDER_INFO_CSS, bundle);
			// WindowGrab.startWindow(window, "查看订单详情", CHECK_FXML, CHECK_CSS);
		}
    	
	}

	@FXML
	void on_search(ActionEvent event) {
		String id=id_text.getText();
		ObservableList<OrderVO> satisfy = null;
		satisfy=getSatisfyList(orderList.iterator(), id);
	}
	
	
	private ObservableList<OrderVO> getSatisfyList(Iterator<OrderVO> iterator , String filter) {
		ObservableList<OrderVO> orderVOs=FXCollections.observableArrayList();
		while (iterator.hasNext()) {
			OrderVO each=iterator.next();
			if(each.orderID.contains(filter)){
				orderVOs.add(each);
			}
		}
		return orderVOs;
		
	}
	
}
