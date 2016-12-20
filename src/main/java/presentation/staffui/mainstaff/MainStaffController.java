package presentation.staffui.mainstaff;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogicservice.orderblservice.OrderBLService;
import config.urlconfig.StaffUIURLConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Window;
import presentation.bundle.OrderListBundle;
import presentation.utilui.WindowGrab;
import util.UserCache;
import util.exception.NetException;
import util.order.OrderState;
import vo.order.OrderVO;
import vo.user.StaffVO;

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
		try {
			StaffVO staff = ControllerFactory.getStaffBLServiceInstance().showData(UserCache.getID());
			UserCache.setHotelID(staff.hotelID);
			staffID.setText(staff.id);
			staffName.setText(staff.name);
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(0));
		}
	}
    
    @FXML
    void maintainMessage(ActionEvent event) {
    	Window owner = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(owner, "酒店信息", MAINTAIN_HOTEL_FXML, MAINTAIN_HOTEL_CSS);
    }

    @FXML
    void manageOrder(ActionEvent event) {
		Window owner = WindowGrab.getWindow(event);
//			ArrayList<OrderVO> total_list = service.queryHotelOrder(hotelID, OrderState.All);
//			ArrayList<OrderVO> finish_list = service.queryHotelOrder(hotelID, OrderState.Finished);
//			ArrayList<OrderVO> unexecute_list = service.queryHotelOrder(hotelID, OrderState.Unexecuted);
//			ArrayList<OrderVO> revoked_list = service.queryHotelOrder(hotelID, OrderState.Canceled);
//			ArrayList<OrderVO> exception_list = service.queryHotelOrder(hotelID, OrderState.Exception);
//		
//			ResourceBundle bundle = new OrderListBundle(total_list, finish_list, unexecute_list, revoked_list, exception_list); 
//			WindowGrab.changeSceneWithBundle(ORDER_MANAGE_FXML, ORDER_MANAGE_CSS, frame, bundle);
		WindowGrab.startWindow(owner, "酒店订单管理", ORDER_MANAGE_FXML, ORDER_MANAGE_CSS);

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
