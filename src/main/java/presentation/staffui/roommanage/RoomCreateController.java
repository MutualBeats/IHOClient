package presentation.staffui.roommanage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import presentation.utilcontroller.Confirm;
import presentation.utilui.WindowGrab;
import util.UserCache;
import util.exception.NetException;
import util.room.RoomState;
import util.room.RoomType;
import vo.room.RoomVO;

public class RoomCreateController implements Initializable, Confirm {
	
	private static final ObservableList<String> ROOM_TYPE = FXCollections.observableArrayList("单人间", "双人间", "三人间", "四人间");
	
	@FXML
	private ComboBox<String> room_type;
	
	@FXML
	private TextField room_number;
	
	@FXML
	private TextField room_price;
	
    @FXML
    private Button cancel;

    @FXML
    private Button confirm;

    private static URL ROOM_CREATE_CONFIRM_FXML;
    private static URL ROOM_CREATE_CONFIRM_CSS;
    
    static{
    	try {
    		ROOM_CREATE_CONFIRM_FXML = new URL("file:src/main/resources/ui/staffui/fxml/roomcreate_confirm.fxml");
    		ROOM_CREATE_CONFIRM_CSS = new URL("file:src/main/resources/ui/staffui/css/roomcreate_confirm.css");
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }
    
    private UpdateRoom update;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		room_type.setItems(ROOM_TYPE);
		update = (UpdateRoom) resources.getObject("update");
	}
    
    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void confirm(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	int roomTypeIndex = room_type.getSelectionModel().getSelectedIndex();
    	if(roomTypeIndex == -1) {
    		WindowGrab.startNoticeWindow(window, "请选择房间类型");
    		return;
    	}
    	if(room_number.getText() == "") {
    		WindowGrab.startNoticeWindow(window, "房间号不可为空");
    		return;
    	}
    	try {
    		int roomPrice = Integer.parseInt(room_price.getText());
    		if(roomPrice < 0) {
    			WindowGrab.startNoticeWindow(window, "房间价格不可为负");
    			return;
    		}
    	} catch (NumberFormatException e) {
    		WindowGrab.startNoticeWindow(window, "请输入正确的价格");
    		return;
    	}
    	WindowGrab.startConfirmWindow(window, this, "是否确认录入");
    }

	@Override
	public void confirm() {
		String hotelID = UserCache.getHotelID();
		RoomType roomType = RoomType.values()[room_type.getSelectionModel().getSelectedIndex()];
		String roomNumber = room_number.getText();
		int roomPrice = Integer.parseInt(room_price.getText());
		RoomVO room = new RoomVO(hotelID, roomNumber, roomType, roomPrice, RoomState.NotReserved);
		ArrayList<RoomVO> importList = new ArrayList<>();
		importList.add(room);
		try {
			ArrayList<String> failList = ControllerFactory.getRoomBLServiceInstance().importRoom(importList);
			if(failList.size() > 0)
				// TODO 窗口
				WindowGrab.startNoticeWindow(WindowGrab.getWindowByStage(1), "房间号已存在");
			
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(1));
			return;
		}
		// TODO 成功提示 房间列表添加
		update.update(room);
	}

}
