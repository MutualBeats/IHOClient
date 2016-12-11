package presentation.staffui.mainstaff;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogic.userbl.staff.Staff;
import bussinesslogicservice.userblservice.StaffBLService;
import config.urlconfig.StaffUIURLConfig;
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
	
	static {
		HOTEL_PROMOTION_FXML = StaffUIURLConfig.staff_hotel_promotion_fxml_url();
		HOTEL_PROMOTION_CSS = StaffUIURLConfig.staff_hotel_promotion_css_url();

		ROOM_MANAGE_FXML = StaffUIURLConfig.staff_room_manage_fxml_url();
		ROOM_MANAGE_CSS = StaffUIURLConfig.staff_room_manage_css_url();

		ORDER_MANAGE_FXML = StaffUIURLConfig.staff_order_manage_fxml_url();
		ORDER_MANAGE_CSS = StaffUIURLConfig.staff_order_manage_css_url();

		MAINTAIN_HOTEL_FXML = StaffUIURLConfig.staff_maintain_hotel_fxml_url();
		MAINTAIN_HOTEL_CSS = StaffUIURLConfig.staff_maintain_hotel_css_url();

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
