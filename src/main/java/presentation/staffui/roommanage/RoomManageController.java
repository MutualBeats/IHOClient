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
import presentation.utilui.WindowGrab;
import util.UserCache;
import util.exception.NetException;
import vo.room.RoomVO;

public class RoomManageController implements Initializable {
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
    private Button cancel;

    @FXML
    private Label promotion_title;

    @FXML
    private Button change;

    @FXML
    private Button create;

    @FXML
    private Button look;
    
    private static URL ROOM_CREATE_FXML;
    private static URL ROOM_CREATE_CSS;
    
    private static URL ROOM_CHECK_FXML;
    private static URL ROOM_CHECK_CSS;
    
    private static URL ROOM_UPDATE_FXML;
    private static URL ROOM_UPDATE_CSS;
    
    static{
    	try {
    		ROOM_CREATE_FXML = new URL("file:src/main/resources/ui/staffui/fxml/room_create.fxml");
    		ROOM_CREATE_CSS = new URL("file:src/main/resources/ui/staffui/css/room_create.css");
    		
    		ROOM_CHECK_FXML = new URL("file:src/main/resources/ui/staffui/fxml/room_check.fxml");
    		ROOM_CHECK_CSS = new URL("file:src/main/resources/ui/staffui/css/room_check.css");
    		
    		ROOM_UPDATE_FXML = new URL("file:src/main/resources/ui/staffui/fxml/room_update.fxml");
    		ROOM_UPDATE_CSS = new URL("file:src/main/resources/ui/staffui/css/room_update.css");
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }
        
    private ObservableList<RoomVO> list = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			String hotelID = ControllerFactory.getStaffBLServiceInstance().showData(UserCache.getID()).hotelID;
			RoomBLService roomBL = ControllerFactory.getRoomBLServiceInstance();
			ArrayList<RoomVO> roomVOList = roomBL.getRoomList(hotelID);
			list.addAll(roomVOList);
			room_list.setItems(list);
			initColumn();
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(0));
		}
	}
	
	private void initColumn() {
		room_number.setCellValueFactory(cellData -> cellData.getValue().getRoomNumberProperty());
		room_type.setCellValueFactory(cellData -> cellData.getValue().getRoomTypeProperty());
		room_price.setCellValueFactory(cellData -> cellData.getValue().getRoomPriceProperty().asObject());
		room_state.setCellValueFactory(cellData -> cellData.getValue().getRoomStateProperty());
	}
    
    @FXML
    void change(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "修改客房信息",ROOM_UPDATE_FXML,ROOM_UPDATE_CSS);
	}

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void look(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, "查看客房信息",ROOM_CHECK_FXML,ROOM_CHECK_CSS);
    }

    @FXML
    void create(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, "录入客房", ROOM_CREATE_FXML,ROOM_CREATE_CSS);
    }

}
