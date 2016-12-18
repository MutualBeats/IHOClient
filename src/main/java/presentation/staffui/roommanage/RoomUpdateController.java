package presentation.staffui.roommanage;

import java.net.MalformedURLException;
import java.net.URL;
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
import presentation.utilui.WindowGrab;
import util.exception.NetException;
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
	private Label check_in_warning;
	
	@FXML
	private Label check_out_warning;

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
    	// TODO 输入合法性检测
		String checkInDate = check_in_date.getEditor().getText();
		if (util.Time.getCurrentDate().compareTo(checkInDate) > 0) {
			check_in_warning.setText("入住日期不可在当前日期前");
			return;
		}
		String checkOutDate = estimate_check_out_date.getEditor().getText();
		if(checkInDate.compareTo(checkOutDate) > 0) {
			check_out_warning.setText("预计离开日期不可在入住日期前");
			return;
		}
		WindowGrab.startConfirmWindow(window, this, "是否确认添加房间记录");
    }
    
    @FXML
    void checkInDate() {
    	if (!check_in_warning.getText().equals(""))
    		check_in_warning.setText("");
    }
    
    @FXML
    void checkOutDate() {
    	if (!check_out_warning.getText().equals(""))
    		check_out_warning.setText("");
    }

	@Override
	public void confirm() {
		// TODO DatePicker操作
		String checkInDate = check_in_date.getEditor().getText();
		String checkOutDate = estimate_check_out_date.getEditor().getText();
		
		RoomRecordVO roomRecord = new RoomRecordVO(checkInDate, checkOutDate, "", room.hotelID, room.roomNumber);
		try {
			ControllerFactory.getRoomBLServiceInstance().addRecord(roomRecord);
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(0));
		}
		// TODO 房间记录列表添加
		
	}


}
