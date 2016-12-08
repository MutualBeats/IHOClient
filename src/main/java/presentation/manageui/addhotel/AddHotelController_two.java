package presentation.manageui.addhotel;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import config.urlconfig.ManageUIURLConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import presentation.utilcontroller.RegistCheckController;
import presentation.utilui.WindowGrab;
import vo.user.StaffVO;

/**
 * 
 *	Confirm means next step, cancel means last step
 * 
 * @author heleninsa
 *
 */
public class AddHotelController_two extends RegistCheckController implements Initializable{

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

	@FXML
	public void cancel(ActionEvent event) {
		storeInfo();
		Scene frame = WindowGrab.getScene(event);
		WindowGrab.changeScene(ManageUIURLConfig.manage_add_hotel_one_fxml(), ManageUIURLConfig.manage_add_hotel_one_css(), frame);
	}

	@Override
	protected void confirm(ActionEvent event) {
		if(checkInputFormatter()) {
			Window window = WindowGrab.getWindow(event);
			if(checkName(window)) {
				storeInfo();
				//
				Scene frame = WindowGrab.getScene(event);
				WindowGrab.changeScene(ADD_HOTEL_THREE_FXML, ADD_HOTEL_THREE_CSS, frame);
			}
		}
	}
	
	private void storeInfo() {
		//
		String staffID = user_name.getText();
		String contactWay = phone.getText();
		String staffName = name.getText();
		String psw = ps.getText();
		String psa = ps_again.getText();
		StaffVO info = new StaffVO(staffID, staffName, contactWay, null);
		ViewCache.initStaff(info, psw, psa);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(ViewCache.staff_info != null) {
			StaffVO info = ViewCache.staff_info;
			user_name.setText(info.staffID);
			name.setText(info.staffName);
			phone.setText(info.contactWay);
			ps.setText(ViewCache.ps);
			ps_again.setText(ViewCache.ps_again);
		}
	}
	

}
