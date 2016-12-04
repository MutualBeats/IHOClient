package presentation.staffui.mainstaff;

import java.net.URL;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogicservice.userblservice.StaffBLService;
import config.URLConfig;
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Initial Lization of Staff information
//		StaffBLService staffBLService = ControllerFactory.getStaffBLServiceInstance();
	}
    
    @FXML
    void maintainMessage(ActionEvent event) {
    	Window owner = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(owner, "酒店信息", URLConfig.staff_maintain_hotel_fxml_url(), URLConfig.staff_maintain_hotel_css_url());
    }

    @FXML
    void manageOrder(ActionEvent event) {
    	Window owner = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(owner, "管理订单", URLConfig.staff_order_manage_fxml_url(), URLConfig.staff_order_manage_css_url());
    }

    @FXML
    void manageRoom(ActionEvent event) {
    	Window owner = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(owner, "管理房间",URLConfig.staff_room_manage_fxml_url(), URLConfig.staff_room_manage_css_url());
    }

    @FXML
    void hotelPromotion(ActionEvent event) {
    	Window owner = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(owner, "酒店促销策略", URLConfig.staff_hotel_promotion_fxml_url(), URLConfig.staff_hotel_promotion_css_url());
    }


}
