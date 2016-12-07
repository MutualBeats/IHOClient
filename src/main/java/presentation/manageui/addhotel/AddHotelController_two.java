package presentation.manageui.addhotel;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import presentation.utilcontroller.RegistCheckController;
import presentation.utilui.WindowGrab;
import vo.hotel.HotelVO;
import vo.user.StaffVO;

/**
 * 
 *	Confirm means next step, cancel means last step
 * 
 * @author heleninsa
 *
 */
public class AddHotelController_two extends RegistCheckController {

	@FXML
	private AnchorPane second_pane;


	private static URL ADD_HOTEL_THREE_FXML;
	private static URL ADD_HOTEL_THREE_CSS;
	static {
		try {
			ADD_HOTEL_THREE_FXML = new URL("file:src/main/resources/ui/manageui/fxml/addhotel_three.fxml");
			ADD_HOTEL_THREE_CSS = new URL("file:src/main/resources/ui/manageui/css/addhotel_three.css");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

//	@FXML
//	void second_confirm(ActionEvent event) {
//		Window window = WindowGrab.getWindow(event);
//		WindowGrab.startWindow(window, "确认", ADD_HOTEL_THREE_FXML, ADD_HOTEL_THREE_CSS);
//	}

	@FXML
	public void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

	@Override
	protected void confirm(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	
//	
//	class BothInfoBundle extends ResourceBundle {
//		
//		private StaffVO staff_info;
//		
//		private HotelVO hotel_info;
//		
//		private final static String STAFF_KEY = "staff_info";
//		
//		private final static String HOTEL_KEY = "hotel_info";
//		
//		@Override
//		protected Object handleGetObject(String key) {
//			if(STAFF_KEY.equals(key)) {
//				return staff_info;
//			} else if(HOTEL_KEY.equals(key)) {
//				return hotel_info;
//			} else {
//				return null;
//			}
//		}
//
//		@Override
//		public Enumeration<String> getKeys() {
//			return null;
//		}
//		
//	}

}
