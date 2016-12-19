package presentation.staffui.roommanage;

import java.net.MalformedURLException;
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
	
	private static final String[] ROOM_TYPE = {"单人间", "双人间", "三人间", "四人间"};
	
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

    private static URL ROOM_UPDATE_CONFIRM_FXML;
    private static URL ROOM_UPDATE_CONFIRM_CSS;
    
    static{
    	try {
    		ROOM_UPDATE_CONFIRM_FXML = new URL("file:src/main/resources/ui/staffui/fxml/roomupdate_confirm.fxml");
    		ROOM_UPDATE_CONFIRM_CSS = new URL("file:src/main/resources/ui/staffui/css/roomupdate_confirm.css");
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }
    
    private RoomVO room;
    private UpdateRoomRecord updateRoomRecord;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		room = (RoomVO)resources.getObject("room");
		room_number.setText(room.roomNumber);
		room_type.setText(ROOM_TYPE[room.type.ordinal()]);
		room_price.setText("" + room.price);
		CheckUtil.init(check_in_date, estimate_check_out_date, LocalDate.now(), LocalDate.now());
		updateRoomRecord = (UpdateRoomRecord) resources.getObject("update");
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
		Window window = WindowGrab.getWindowByStage(3);
		
		String checkInDate = check_in_date.getEditor().getText();
		String checkOutDate = estimate_check_out_date.getEditor().getText();
		
		RoomRecordVO roomRecord = new RoomRecordVO(checkInDate, checkOutDate, "", room.hotelID, room.roomNumber);
		try {
			ResultMessage_Room result = ControllerFactory.getRoomBLServiceInstance().addRecord(roomRecord);
			switch (result) {
			case Record_Add_Successful:
				WindowGrab.closeWindow(window);
				window = WindowGrab.getWindowByStage(2);
				WindowGrab.startNoticeWindow(window, "添加成功");
				// 房间记录列表添加
				updateRoomRecord.update(roomRecord);
				break;
			case Time_Conflict_Error:
				WindowGrab.startNoticeWindow(window, "时间冲突，无法添加");
				break;
			default:
				WindowGrab.startNoticeWindow(window, "异常错误");
				break;
			}
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
		}
		
	}


}
