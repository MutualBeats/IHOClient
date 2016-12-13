package presentation.staffui.hotelmessagemanage;

import java.net.URL;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import config.urlconfig.StaffUIURLConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import presentation.utilcontroller.Confirm;
import presentation.utilui.WindowGrab;
import util.exception.NetException;
import vo.hotel.HotelVO;

public class Hotel_Maintain_Controller implements Confirm, Initializable {

	@FXML
	private Button cancel;

	@FXML
	private TextField hotel_star;

	@FXML
	private TextField hotel_id;

	@FXML
	private Button update;
	
	@FXML
	private ComboBox<String> hotel_province;

	@FXML
    private ComboBox<String> hotel_town;

    @FXML
    private ComboBox<String> hotel_city;
    
	@FXML
	private ComboBox<String> hotel_field;

	@FXML
	private Label address_warning;

	@FXML
	private TextArea hotel_address;

	@FXML
	private TextField hotel_name;

	@FXML
	private Label hotel_maintain_title;

	@FXML
	private TextField hotel_score;

	@FXML
	private Label name_warning;

	@FXML
	private Label star_warning;

	private static URL CONFIRM_FXML;
	private static URL CONFIRM_CSS;
	static {
		CONFIRM_FXML = StaffUIURLConfig.staff_hotel_maintain_confirm_fxml_url();
		CONFIRM_CSS = StaffUIURLConfig.staff_hotel_maintain_confirm_css_url();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO 测试用
		try {
			HotelVO info = ControllerFactory.getHotelBLServiceInstance().showHotelInfo("00000001");
			String[] region = info.region.split(" ");
			// TODO combobox操作
			hotel_province.setValue(region[0]);
			hotel_city.setValue(region[1]);
			hotel_town.setValue(region[2]);
			
			hotel_id.setText(info.hotelID);
			hotel_address.setText(info.address);
			hotel_field.setValue(info.businessDistrict);
			hotel_name.setText(info.hotelName);
			hotel_star.setText("" + info.starLevel);
			hotel_score.setText("" + info.score);
			
			name_warning.setText("");
			star_warning.setText("");
			address_warning.setText("");
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(0));
		}
	}

	@FXML
	void update(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		WindowGrab.startModifyConfirmWindow(window, this);
	}

	@FXML
	void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

	@Override
	public void confirm() {
		String newName = hotel_name.getText();
		// TODO
		String newRegion = hotel_province.getAccessibleText() + " " + hotel_city.getAccessibleText() + " " 
				+ hotel_town.getAccessibleText();
		String newDistrcit = hotel_field.getAccessibleText();
		String newAdress = hotel_address.getText();
		HotelVO vo = new HotelVO(hotel_id.getText(), newName, newAdress, newRegion, newDistrcit, 0, 0);
		
		try {
			ControllerFactory.getHotelBLServiceInstance().changeHotelInfo(vo);
		} catch (NetException e) {
			// TODO 错误提示
			e.printStackTrace();
		}
		
	}

}
