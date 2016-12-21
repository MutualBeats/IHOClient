/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.staffui.roommanage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogicservice.roomblservice.RoomBLService;
import config.urlconfig.StaffUIURLConfig;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Window;
import presentation.bundle.RoomInfoBundle;
import presentation.bundle.RoomUpdateBundle;
import presentation.utilui.WindowGrab;
import util.UserCache;
import util.exception.NetException;
import vo.room.RoomVO;

public class RoomManageController implements Initializable, UpdateRoom {
	@FXML
	private TableColumn<RoomVO, String> room_number;
	
	@FXML
	private TableColumn<RoomVO, String> room_type;
	
	@FXML
	private TableColumn<RoomVO, Integer> room_price;
	
	@FXML
	private TableColumn<RoomVO, String> room_state;
	
    @FXML
    private TableView<RoomVO> room_list;
    
    @FXML
    private Button refresh;

    @FXML
    private Button cancel;

    @FXML
    private Label promotion_title;

    @FXML
    private Button create;

    @FXML
    private Button check;
    
    @FXML
    private Button peopleInfo;

    @FXML
    private Button hotel_message;
    
    @FXML
    private Button room;
    
    @FXML
    private Button promotion;

    @FXML
    private Button order;
    
    private static URL ROOM_CREATE_FXML;
    private static URL ROOM_CREATE_CSS;
    
    private static URL ROOM_CHECK_FXML;
    private static URL ROOM_CHECK_CSS;
    
//    private static URL ROOM_UPDATE_FXML;
//    private static URL ROOM_UPDATE_CSS;
    //人员信息界面
    private static URL MENU_FXML;
    private static URL MENU_CSS;
    
  //酒店促销策略
    private static URL HOTEL_PROMOTION_FXML;
    private static URL HOTEL_PROMOTION_CSS;
    
  //订单管理
    private static URL ORDER_MANAGE_FXML;
    private static URL ORDER_MANAGE_CSS;
    
	RoomBLService roomBLService;
    
  //酒店信息管理
    private static URL MAINTAIN_HOTEL_FXML;
	private static URL MAINTAIN_HOTEL_CSS;
	
    static{
    	try {
    		ROOM_CREATE_FXML = new URL("file:src/main/resources/ui/staffui/fxml/room_create.fxml");
    		ROOM_CREATE_CSS = new URL("file:src/main/resources/ui/staffui/css/room_create.css");
    		
    		ROOM_CHECK_FXML = new URL("file:src/main/resources/ui/staffui/fxml/room_check.fxml");
    		ROOM_CHECK_CSS = new URL("file:src/main/resources/ui/staffui/css/room_check.css");
    		
//    		ROOM_UPDATE_FXML = new URL("file:src/main/resources/ui/staffui/fxml/room_update.fxml");
//    		ROOM_UPDATE_CSS = new URL("file:src/main/resources/ui/staffui/css/room_update.css");
    		
    		MENU_FXML = new URL("file:src/main/resources/ui/staffui/fxml/staff_main.fxml");
    		MENU_CSS = new URL("file:src/main/resources/ui/staffui/css/staff_main.css");
    		
    		HOTEL_PROMOTION_FXML = StaffUIURLConfig.staff_hotel_promotion_fxml_url();
    		HOTEL_PROMOTION_CSS = StaffUIURLConfig.staff_hotel_promotion_css_url();

    		ORDER_MANAGE_FXML = StaffUIURLConfig.staff_order_manage_fxml_url();
    		ORDER_MANAGE_CSS = StaffUIURLConfig.staff_order_manage_css_url();

    		MAINTAIN_HOTEL_FXML = StaffUIURLConfig.staff_maintain_hotel_fxml_url();
    		MAINTAIN_HOTEL_CSS = StaffUIURLConfig.staff_maintain_hotel_css_url();

    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }
        
    private ObservableList<RoomVO> list = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			roomBLService = ControllerFactory.getRoomBLServiceInstance();
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(1));
		}
		refresh(null);
	}
	
	@FXML
	void refresh(ActionEvent event) {
		try {
			ArrayList<RoomVO> roomVOList = roomBLService.getRoomList(UserCache.getHotelID());
			list.clear();
			list.addAll(roomVOList);
			room_list.setItems(list);
			initColumn();
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(1));
		}
	}
	
	private void initColumn() {
		room_number.setCellValueFactory(cellData -> cellData.getValue().getRoomNumberProperty());
		room_type.setCellValueFactory(cellData -> cellData.getValue().getRoomTypeProperty());
		room_price.setCellValueFactory(cellData -> cellData.getValue().getRoomPriceProperty().asObject());
		room_state.setCellValueFactory(cellData -> cellData.getValue().getRoomStateProperty());
	}

    
    @FXML
    void check(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	RoomVO roomVO = room_list.getSelectionModel().getSelectedItem();
    	if(roomVO == null) {
    		WindowGrab.startNoticeWindow(window, "请选择房间");
    		return;
    	}
		WindowGrab.startWindowWithBundle(window, "查看客房信息",ROOM_CHECK_FXML,ROOM_CHECK_CSS, new RoomInfoBundle(roomVO, null));
    }

    @FXML
    void create(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindowWithBundle(window, "录入客房", ROOM_CREATE_FXML,ROOM_CREATE_CSS, new RoomUpdateBundle(this));
    }

	@Override
	public void update(RoomVO room) {
		room_list.getItems().add(0, room);
	}

	
	//界面跳转
	@FXML
    void peopleInfo(ActionEvent event) {
		WindowGrab.changeScene(MENU_FXML, MENU_CSS, event);
    }

    @FXML
    void hotelPromotion(ActionEvent event) {
    	WindowGrab.changeScene(HOTEL_PROMOTION_FXML, HOTEL_PROMOTION_CSS, event);
    }

    @FXML
    void manageOrder(ActionEvent event) {
    	WindowGrab.changeScene(ORDER_MANAGE_FXML, ORDER_MANAGE_CSS, event);
    }

    @FXML
    void maintainMessage(ActionEvent event) {
    	WindowGrab.changeScene(MAINTAIN_HOTEL_FXML, MAINTAIN_HOTEL_CSS, event);
    }
}
