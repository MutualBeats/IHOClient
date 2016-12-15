package presentation.marketui.utilui;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;
import vo.order.OrderVO;

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
	private TableColumn<OrderVO, String> hotelname;
	
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
	public abstract void initialize(URL location, ResourceBundle resources);
	
	@FXML
	void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

	@FXML
	void on_check(ActionEvent event) {
		Window window=WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "订单详细信息", ORDER_INFO_FXML, ORDER_INFO_CSS);
    	
	}

	@FXML
	void on_search(ActionEvent event) {

	}

}
