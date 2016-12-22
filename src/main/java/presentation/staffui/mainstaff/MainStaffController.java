package presentation.staffui.mainstaff;

import java.net.URL;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import config.urlconfig.StaffUIURLConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import presentation.utilui.WindowGrab;
import util.UserCache;
import util.exception.NetException;
import vo.user.StaffVO;

public class MainStaffController implements Initializable{

    @FXML
    private Label staffName;
    
    @FXML
    private Label staffID;
    
    @FXML
    private Label contactWay;

    @FXML
    private Button hotel_message;

    @FXML
    private Pane pane;

    @FXML
    private Button room;

    @FXML
    private Button order;

    @FXML
    private Button promotion;
        
    @FXML
    private Label photo;
    
    @FXML
    private Button logout;
    
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
		try {
			StaffVO staff = ControllerFactory.getStaffBLServiceInstance().showData(UserCache.getID());
			UserCache.setHotelID(staff.hotelID);
			staffID.setText(staff.id);
			staffName.setText(staff.name);
			contactWay.setText(staff.contactWay);
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(0));
		}
	}
    
    @FXML
    void maintainMessage(ActionEvent event) {
    	WindowGrab.changeScene(MAINTAIN_HOTEL_FXML, MAINTAIN_HOTEL_CSS, event);
    }

    @FXML
    void manageOrder(ActionEvent event) {
		WindowGrab.changeScene( ORDER_MANAGE_FXML, ORDER_MANAGE_CSS, event);

    }

    @FXML
    void manageRoom(ActionEvent event) {
    	WindowGrab.changeScene(ROOM_MANAGE_FXML, ROOM_MANAGE_CSS, event);
    }

    @FXML
    void hotelPromotion(ActionEvent event) {
    	WindowGrab.changeScene( HOTEL_PROMOTION_FXML, HOTEL_PROMOTION_CSS, event);
    }

    @FXML
    void logout(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

}
