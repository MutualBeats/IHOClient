package presentation.staffui.roommanage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Window;
import presentation.utilcontroller.Confirm;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Room;
import vo.room.RoomRecordVO;
import vo.room.RoomVO;

public class RoomUpdateController implements Initializable, Confirm {
		
	@FXML
	private Label room_number;
	
	@FXML
	private Label room_type;
	
	@FXML
	private Label room_price;
	
	@FXML
	private DatePicker check_in_date;
	
	@FXML
	private DatePicker estimate_check_out_date;

    @FXML
    private Button cancel;

    @FXML
    private Button confirm;
    
    /**
     * 房间信息
     */
    private RoomVO room;
    
    /**
     * 房间列表界面更新接口
     */
    private UpdateRoom updateRoom;
    
    /**
     * 房间记录列表界面更新接口
     */
    private UpdateRoomRecord updateRoomRecord;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		room = (RoomVO)resources.getObject("room");
		room_number.setText(room.roomNumber);
		room_type.setText(room.type.toString());
		room_price.setText("" + room.price);
		CheckUtil.inAndOutDatePickerInit(check_in_date, estimate_check_out_date, LocalDate.now(), LocalDate.now());
		updateRoom = (UpdateRoom) resources.getObject("updateRoom");
		updateRoomRecord = (UpdateRoomRecord) resources.getObject("updateRoomRecord");
	}
    
    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void confirm(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startConfirmWindow(window, this, "是否确认添加房间记录");
    }

	@Override
	public void confirm() {
		Window window = WindowGrab.getWindowByStage(2);
		
		String checkInDate = check_in_date.getEditor().getText();
		String checkOutDate = estimate_check_out_date.getEditor().getText();
		
		RoomRecordVO roomRecord = new RoomRecordVO(checkInDate, checkOutDate, "", room.hotelID, room.roomNumber);
		try {
			ResultMessage_Room result = ControllerFactory.getRoomBLServiceInstance().addRecord(roomRecord);
			switch (result) {
			case Record_Add_Successful:
				WindowGrab.closeWindow(window);
				window = WindowGrab.getWindowByStage(1);
				// 房间记录列表添加
				updateRoomRecord.update(roomRecord);
				updateRoom.update(null);
				WindowGrab.startNoticeWindow(window, "添加成功");
				break;
			case Time_Conflict_Error:
				WindowGrab.startErrorWindow(window, "时间冲突，无法添加");
				break;
			default:
				WindowGrab.startErrorWindow(window, "异常错误");
				break;
			}
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
		}
	}

}
