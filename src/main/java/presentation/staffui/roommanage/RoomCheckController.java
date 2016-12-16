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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;
import util.exception.NetException;
import vo.room.RoomRecordVO;

public class RoomCheckController implements Initializable {
	
	@FXML
	private TextField room_number;
	
	@FXML
	private TextField room_type;
	
	@FXML
	private TextField room_price;
	
	@FXML
	private TextField room_state;
	
	@FXML
	private TableColumn<RoomRecordVO, String> order_id;
	
	@FXML
	private TableColumn<RoomRecordVO, String> check_in_date;
	
	@FXML
	private TableColumn<RoomRecordVO, String> estimate_check_out_date;
	
	@FXML
	private TableView<RoomRecordVO> room_record_list;

    @FXML
    private Button addRecord;
	
	@FXML
	private Button checkIn;
	
	@FXML
	private Button checkOut;

    @FXML
    private Button cancel;

    private static URL ROOM_UPDATE_FXML;
    private static URL ROOM_UPDATE_CSS;
    
    static{
    	try {
    		ROOM_UPDATE_FXML = new URL("file:src/main/resources/ui/staffui/fxml/room_update.fxml");
    		ROOM_UPDATE_CSS = new URL("file:src/main/resources/ui/staffui/css/room_update.css");
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }
    
    private RoomBLService roomBLService;
    
    private ObservableList<RoomRecordVO> list = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO 房间信息初始化
//		room_record_list.getSelectionModel().selectionModeProperty().set(SelectionMode.MULTIPLE);
		try {
			// 房间未来记录获取
			roomBLService = ControllerFactory.getRoomBLServiceInstance();
			// TODO 具体酒店id 房间号获取
			ArrayList<RoomRecordVO> roomRecordList = roomBLService.getOrderRecord("00000001", "3B321");
			list.addAll(roomRecordList);
			room_record_list.setItems(list);
			initColumn();
		} catch (NetException e) {
			e.printStackTrace();
			WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(0));
		}
	}
	
	private void initColumn() {
		order_id.setCellValueFactory(cellData -> cellData.getValue().getOrderIDProperty());
		check_in_date.setCellValueFactory(cellData -> cellData.getValue().getCheckInDateProperty());
		estimate_check_out_date.setCellValueFactory(cellData -> cellData.getValue().getCheckOutDateProperty());
	}
    
    @FXML
    void addRecord(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window,"更新客房信息", ROOM_UPDATE_FXML,ROOM_UPDATE_CSS);
    }
    
    @FXML
    void checkIn(ActionEvent event) {
    	// TODO 线下入住
    	
    }
    
    @FXML
    void checkOut(ActionEvent event) {
    	// TODO 线下退房
    	
    }
    
    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

}
