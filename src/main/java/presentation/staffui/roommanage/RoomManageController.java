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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;
import util.exception.NetException;
import vo.room.RoomVO;

public class RoomManageController implements Initializable {

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
    
    @FXML
    private TableView<RoomVO> room_table;
    
    private ObservableList<RoomVO> data = FXCollections.observableArrayList();

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			ObservableList<TableColumn<RoomVO, ?>> observableList = room_table.getColumns();
			observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("roomNumberProperty"));
			observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("roomTypeProperty"));
			observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("roomPriceProperty"));
			observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("roomStateProperty"));
			
			RoomBLService roomBL = ControllerFactory.getRoomBLServiceInstance();
			// TODO 获取酒店id
			ArrayList<RoomVO> roomVOList = roomBL.getRoomList("00000001");
			for (RoomVO room : roomVOList) {
				room.setRoomNumber(room.roomNumber);
				room.setRoomType(room.type);
				room.setRoomPrice(room.price);
				room.setRoomState(room.condition);
//				RoomData roomData = new RoomData(room.roomNumber, room.type, room.price, room.condition);
				data.add(room);
			}
			room_table.setItems(data);
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(0));
		}
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
