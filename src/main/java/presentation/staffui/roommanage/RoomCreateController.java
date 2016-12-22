package presentation.staffui.roommanage;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;
import presentation.utilcontroller.Confirm;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;
import util.UserCache;
import util.exception.NetException;
import util.room.RoomState;
import util.room.RoomType;
import vo.room.RoomVO;

public class RoomCreateController implements Initializable, Confirm {
		
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
    
    @FXML
    private Label type_warning;
    
    @FXML
    private Label roomnumber_warning;
    
    @FXML
    private Label price_warning;

    /**
     * 房间列表界面更新接口
     */
    private UpdateRoom updateRoom;

    /**
     * 录入客房界面初始化
     */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// ComboBox初始化
		ObservableList<String> roomType = FXCollections.observableArrayList();
		for (RoomType type : RoomType.values()) {
			if(type != RoomType.ALL)
				roomType.add(type.toString());
		}
		room_type.setItems(roomType);
		// 房间列表更新接口
		updateRoom = (UpdateRoom) resources.getObject("updateRoom");
	}
    
    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void confirm(ActionEvent event) {
    	// 房间信息输入检测
    	Window window = WindowGrab.getWindow(event);
    	boolean type = CheckUtil.checkSelect(room_type);
    	boolean number = CheckUtil.checkText(room_number);
    	if(!type) {
    		type_warning.setText("请选择房间类型");
    	}
    	if(!number) {
    		roomnumber_warning.setText("房间号不可为空");
    	}
    	try {
    		int roomPrice = Integer.parseInt(room_price.getText());
    		if(roomPrice < 0) {
    			price_warning.setText("价格不可为负");
    			return;
    		}
    	} catch (NumberFormatException e) {
    		price_warning.setText("价格必须为正整数");
    		return;
    	}
    	
    	if(type && number) {
    		WindowGrab.startConfirmWindow(window, this, "是否确认录入");
    	}
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
				WindowGrab.startErrorWindow(WindowGrab.getWindowByStage(1), "房间号已存在");
			else {
				// 成功提示 房间列表添加
				updateRoom.update(room);
				WindowGrab.startNoticeWindow(WindowGrab.getWindowByStage(1), "添加成功");
			}
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(1));
		}
	}
    
    @FXML
    void roomTypeModify(MouseEvent event) {
    	CheckUtil.checkWarningBefore(type_warning);
    }
    
    @FXML
    void roomNumberModify(MouseEvent event) {
    	CheckUtil.checkWarningBefore(roomnumber_warning);
    }
    
    @FXML
    void roomPriceModify(MouseEvent event) {
    	CheckUtil.checkWarningBefore(price_warning);
    }

}
