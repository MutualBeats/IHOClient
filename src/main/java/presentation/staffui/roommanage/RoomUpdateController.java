package presentation.staffui.roommanage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Window;
import presentation.utilcontroller.Confirm;
import presentation.utilui.WindowGrab;
import vo.room.RoomRecordVO;
import vo.room.RoomVO;

public class RoomUpdateController implements Initializable, Confirm {
	
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		room = (RoomVO)resources.getObject("room");
		room_number.setText(room.roomNumber);
		room_type.setText(ROOM_TYPE[room.type.ordinal()]);
		room_price.setText("" + room.price);
		room_state.setText(ROOM_STATE[room.condition.ordinal()]);
	}
    
    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void confirm(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
//		WindowGrab.startWindow(window,"确认", ROOM_UPDATE_CONFIRM_FXML,ROOM_UPDATE_CONFIRM_CSS);
		WindowGrab.startConfirmWindow(window, this, "是否确认添加房间记录");
    }

	@Override
	public void confirm() {
		// TODO 如何获取DatePicker
		RoomRecordVO roomRecord;
		
	}


}
