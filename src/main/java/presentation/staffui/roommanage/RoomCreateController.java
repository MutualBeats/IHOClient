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
	private TextField start_number;
	
	@FXML
	private TextField total_number;
	
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
    private Label startnumber_warning;
    
    @FXML
    private Label totalnumber_warning;
    
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
		total_number.setText("1");
		// 房间列表更新接口
		updateRoom = (UpdateRoom) resources.getObject("updateRoom");
	}
    
    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }
    
    /**
     * 检查TextField输入数字是否为正整数
     * @param input
     * @param warning
     * @param warningMessage
     * @return boolean
     */
    private boolean checkInputValue(TextField input, Label warning, String warningMessage) {
    	try {
    		int value = Integer.parseInt(input.getText());
    		if (value <= 0) {
    			warning.setText(warningMessage);
    			return false;
    		}
    	} catch (NumberFormatException e) {
    		warning.setText("请输入正整数");
    		return false;
		}
    	return true;
    }

    @FXML
    void confirm(ActionEvent event) {
    	// 房间信息输入检测
    	Window window = WindowGrab.getWindow(event);
    	boolean typeInput = CheckUtil.checkSelect(room_type);
    	if(!typeInput) {
    		type_warning.setText("请选择房间类型");
    	}
    	boolean numberInput = true;
    	numberInput &= checkInputValue(start_number, startnumber_warning, "开始号码至少为1");
    	numberInput &= checkInputValue(total_number, totalnumber_warning, "录入房间数量至少为1");
    	numberInput &= checkInputValue(room_price, price_warning, "价格必须为正");
    	
    	if(typeInput && numberInput) {
    		WindowGrab.startConfirmWindow(window, this, "是否确认录入");
    	}
    }
    
	@Override
	public void confirm() {
		String hotelID = UserCache.getHotelID();
		RoomType roomType = RoomType.values()[room_type.getSelectionModel().getSelectedIndex()];
		String roomNumber = room_number.getText();
		int startNumber = Integer.parseInt(start_number.getText());
		int totalNumber = Integer.parseInt(total_number.getText());
		int roomPrice = Integer.parseInt(room_price.getText());
		// 录入房间列表初始化
		ArrayList<RoomVO> importRooms = new ArrayList<RoomVO>(totalNumber);
		for (int i = 0; i < totalNumber; i++) {
			RoomVO room = new RoomVO(hotelID, roomNumber + (startNumber + i), roomType, roomPrice, RoomState.NotReserved);
			importRooms.add(room);
		}
		Window window = WindowGrab.getWindowByStage(1);
		try {
			ArrayList<String> failList = ControllerFactory.getRoomBLServiceInstance().importRoom(importRooms);
			if(failList.size() == importRooms.size())
				// 全部添加失败
				WindowGrab.startErrorWindow(window, "所有房间都已存在");
			else if(failList.size() == 0) {
				// 全部添加成功
				WindowGrab.startNoticeWindow(window, "全部房间添加成功");
			}
			else {
				// 部分添加成功
				String message = "房间号" + failList.get(0);
				for (int i = 1; i < failList.size(); i++) {
					if(i == 3) {
						message += "等" + failList.size() + "个房间";
						break;
					}
					message += "、" + failList.get(i);
				}
				message += "已存在";
				WindowGrab.startNoticeWindow(window, message);
			}
			// 更新房间列表
			updateRoom.update();
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
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
    void startNumberModify(MouseEvent event) {
    	CheckUtil.checkWarningBefore(startnumber_warning);
    }
    
    @FXML
    void totalNumberModify(MouseEvent event) {
    	CheckUtil.checkWarningBefore(totalnumber_warning);
    }
    
    @FXML
    void roomPriceModify(MouseEvent event) {
    	CheckUtil.checkWarningBefore(price_warning);
    }

}
