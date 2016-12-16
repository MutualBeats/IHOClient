package presentation.staffui.roommanage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;
import vo.room.RoomVO;

public class RoomCreateController implements Initializable {
	
	@FXML
	private TableColumn<RoomVO, String> room_number;
	
	@FXML
	private TableColumn<RoomVO, ComboBox<String>> room_type;
	
	@FXML
	private TableColumn<RoomVO, Integer> room_price;
	
	@FXML
	private TableView<RoomVO> import_room_list;
	
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO
		
	}
    
    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void confirm(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window,"确认", ROOM_CREATE_CONFIRM_FXML,ROOM_CREATE_CONFIRM_CSS);
    }


}
