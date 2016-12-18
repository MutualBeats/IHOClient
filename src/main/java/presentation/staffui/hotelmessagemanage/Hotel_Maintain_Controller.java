package presentation.staffui.hotelmessagemanage;

import java.net.URL;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import config.location.City;
import config.location.Field;
import config.location.Province;
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
import presentation.utilcontroller.LocationBoxController;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;
import util.UserCache;
import util.exception.NetException;
import vo.hotel.HotelVO;

public class Hotel_Maintain_Controller extends LocationBoxController implements Confirm, Initializable {

	@FXML
	private Button cancel;

	@FXML
	private TextField hotel_id;

	@FXML
	private Button update;

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

	private static URL CONFIRM_FXML;
	private static URL CONFIRM_CSS;
	static {
		CONFIRM_FXML = StaffUIURLConfig.staff_hotel_maintain_confirm_fxml_url();
		CONFIRM_CSS = StaffUIURLConfig.staff_hotel_maintain_confirm_css_url();
	}
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
		// TODO 测试用
		try {
			String hotelID = UserCache.getHotelID();
			
			HotelVO info = ControllerFactory.getHotelBLServiceInstance().showHotelInfo(hotelID);
			String[] region = info.region.split("\\s");
			// TODO combobox初始化
			for(Province e_p : province.getItems()) {
				if(e_p.getProvinceName().equals(region[0])) {
					province.getSelectionModel().select(e_p);
				}
			}
			
			for(City e_c : city.getItems()) {
				if(e_c.getCity_name().equals(region[1])){
					city.getSelectionModel().select(e_c);
				}
			}
			
			for(Field e_f : field.getItems()) {
				if(e_f.getField_name().equals(region[2])){
					field.getSelectionModel().select(e_f);
				}
			}
			
			for(String e_g : group.getItems()) {
				if(e_g.equals(info.businessDistrict)) {
					group.getSelectionModel().select(e_g);
				}
			}
			
			hotel_id.setText(hotelID);
			hotel_address.setText(info.address);
			
			hotel_name.setText(info.hotelName);
			star.getSelectionModel().select(info.starLevel - 1);
			hotel_score.setText("" + info.score);
			
			name_warning.setText("");
			address_warning.setText("");
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(0));
		}
	}

	@FXML
	void update(ActionEvent event) {
		boolean name_in = CheckUtil.checkText(hotel_name);
		boolean adress_in = CheckUtil.checkText(hotel_address);
		if (!name_in)
			name_warning.setText("请输入酒店名称");
		if (!adress_in)
			address_warning.setText("请输入地址");
		if(name_in && adress_in) {
			Window window = WindowGrab.getWindow(event);
			WindowGrab.startModifyConfirmWindow(window, this);
		}
	}

	@FXML
	void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}
	
	@FXML
	public void hotelNameModify() {
		CheckUtil.checkWarningBefore(name_warning);
	}
	
	@FXML
	public void hotelAdressModify() {
		CheckUtil.checkWarningBefore(address_warning);
	}

	@Override
	public void confirm() {
		String newName = hotel_name.getText();
		String newProvince = province.getSelectionModel().getSelectedItem().getProvinceName();
		String newCity = city.getSelectionModel().getSelectedItem().getCity_name();
		String newTown = field.getSelectionModel().getSelectedItem().getField_name();
		String newRegion = newProvince + " " + newCity + " " + newTown;
		String newDistrcit = group.getSelectionModel().getSelectedItem();
		String newAdress = hotel_address.getText();

		HotelVO vo = new HotelVO(hotel_id.getText(), newName, newAdress, newRegion, newDistrcit, 0, 0);
		try {
			ControllerFactory.getHotelBLServiceInstance().changeHotelInfo(vo);
		} catch (NetException e) {
			e.printStackTrace();
			WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(0));
		}
		WindowGrab.startNoticeWindow(WindowGrab.getWindowByStage(0), "修改成功");
	}

}
