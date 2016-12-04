package presentation.staffui.mainstaff;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogicservice.userblservice.StaffBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class MainStaffController implements Initializable{

    @FXML
    private Label staffName;

    @FXML
    private Button hotel_message;

    @FXML
    private Pane pane;

    @FXML
    private Label title;

    @FXML
    private Label staffID;

    @FXML
    private Button room;

    @FXML
    private Button order;

    @FXML
    private Button promotion;
    
    //酒店促销策略
    private static URL HOTEL_PROMOTION_FXML;
    private static URL HOTEL_PROMOTION_CSS;
    
    //房间管理
    private static URL ROOM_MANAGE_FXML;
    private static URL ROOM_MANAGE_CSS;
    
    //订单管理
    private static URL ORDER_MANAGE_FXML;
    private static URL ORDER_MANAGE_CSS;
    
    //酒店信息管理
    private static URL MAINTAIN_HOTEL_FXML;
    private static URL MAINTAIN_HOTEL_CSS;
    static{
    	try {
    		HOTEL_PROMOTION_FXML = new URL("file:src/main/resources/ui/staffui/fxml/hotel_promotion.fxml");
    		HOTEL_PROMOTION_CSS = new URL("file:src/main/resources/ui/staffui/css/hotel_promotion.css");
    		
    		ROOM_MANAGE_FXML = new URL("file:src/main/resources/ui/staffui/fxml/room_manage.fxml");
    		ROOM_MANAGE_CSS = new URL("file:src/main/resources/ui/staffui/css/room_manage.css");
    		
    		ORDER_MANAGE_FXML = new URL("file:src/main/resources/ui/staffui/fxml/order_manage.fxml");
    		ORDER_MANAGE_CSS = new URL("file:src/main/resources/ui/staffui/css/order_manage.css");
    		
    		MAINTAIN_HOTEL_FXML = new URL("file:src/main/resources/ui/staffui/fxml/maintain_hotel.fxml");
    		MAINTAIN_HOTEL_CSS = new URL("file:src/main/resources/ui/staffui/css/maintain_hotel.css");
    		
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		}
    
    @FXML
    void maintainMessage(ActionEvent event) {
    	Window owner = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(owner, "酒店信息", MAINTAIN_HOTEL_FXML, MAINTAIN_HOTEL_CSS);
    }

    @FXML
    void manageOrder(ActionEvent event) {
    	Window owner = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(owner, "管理订单", ORDER_MANAGE_FXML, ORDER_MANAGE_CSS);
    }

    @FXML
    void manageRoom(ActionEvent event) {
    	Window owner = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(owner, "管理房间",ROOM_MANAGE_FXML, ROOM_MANAGE_CSS);
    }

    @FXML
    void hotelPromotion(ActionEvent event) {
    	Window owner = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(owner, "酒店促销策略", HOTEL_PROMOTION_FXML, HOTEL_PROMOTION_CSS);
    }


}
