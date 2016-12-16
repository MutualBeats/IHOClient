package presentation.staffui.roommanage;

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
import presentation.utilui.WindowGrab;
import util.exception.NetException;
import vo.room.RoomRecordVO;
import vo.room.RoomVO;

public class RoomCheckController implements Initializable {
	
	private static final String[] ROOM_TYPE = {"单人间", "双人间", "三人间", "四人间"};
	private static final String[] ROOM_STATE = {"已预订", "未预订", "已入住"};
	
	@FXML
	private Label room_number;
	
	@FXML
	private Label room_type;
	
	@FXML
	private Label room_price;
	
	@FXML
	private Label room_state;
	
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

    private static URL ROOM_RECORD_ADD_FXML;
    private static URL ROOM_RECORD_ADD_CSS;
    
	static {
		// TODO 文件名字修改
		ROOM_RECORD_ADD_FXML = StaffUIURLConfig.staff_room_update_fxml_url();
		ROOM_RECORD_ADD_CSS = StaffUIURLConfig.staff_room_update_css_url();
	}
    
    private RoomVO room;
    
    private RoomBLService roomBLService;
    
    private ObservableList<RoomRecordVO> list = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		room_record_list.getSelectionModel().selectionModeProperty().set(SelectionMode.MULTIPLE);
		room = (RoomVO)resources.getObject("room");
		room_number.setText(room.roomNumber);
		room_type.setText(ROOM_TYPE[room.type.ordinal()]);
		room_price.setText("" + room.price);
		room_state.setText(ROOM_STATE[room.condition.ordinal()]);
		try {
			// 未来房间记录获取
			roomBLService = ControllerFactory.getRoomBLServiceInstance();
			ArrayList<RoomRecordVO> roomRecordList = roomBLService.getOrderRecord(room.hotelID, room.roomNumber);
			list.addAll(roomRecordList);
			room_record_list.setItems(list);
			initColumn();
		} catch (NetException e) {
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
		WindowGrab.startWindow(window,"更新客房信息", ROOM_RECORD_ADD_FXML,ROOM_RECORD_ADD_CSS);
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
