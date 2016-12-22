package presentation.staffui.hotelmessagemanage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;
import presentation.bundle.EvaluationBundle;
import presentation.utilcontroller.Confirm;
import presentation.utilcontroller.LocationBoxController;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;
import util.UserCache;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Hotel;
import vo.hotel.HotelEvaluationVO;
import vo.hotel.HotelVO;

public class Hotel_Maintain_Controller extends LocationBoxController implements Confirm, Initializable {

	@FXML
	private Button cancel;

	@FXML
	private TextField hotel_id;

	@FXML
	private Button update;
	
	@FXML
	private Button evaluation;

	@FXML
	private Label address_warning;

	@FXML
	private TextArea hotel_address;

	@FXML
	private TextField hotel_name;

	@FXML
	private Label pane;

	@FXML
	private TextField hotel_score;

	@FXML
	private Label name_warning;
	
	@FXML
	private Label region_warning;
		
	//酒店促销策略
    private static URL HOTEL_PROMOTION_FXML;
    private static URL HOTEL_PROMOTION_CSS;
    
    // 房间管理
    private static URL ROOM_MANAGE_FXML;
    private static URL ROOM_MANAGE_CSS;
    
    // 订单管理
    private static URL ORDER_MANAGE_FXML;
    private static URL ORDER_MANAGE_CSS;
    
	 // 人员信息
    private static URL MENU_FXML;
	private static URL MENU_CSS;
	
	// 查看酒店评价
	private static URL EVALUATION_FXML;
	private static URL EVALUATION_CSS;
	
	static{
    	MENU_FXML = StaffUIURLConfig.staff_main_fxml_url();
		MENU_CSS = StaffUIURLConfig.staff_main_css_url();
		
		HOTEL_PROMOTION_FXML = StaffUIURLConfig.staff_hotel_promotion_fxml_url();
		HOTEL_PROMOTION_CSS = StaffUIURLConfig.staff_hotel_promotion_css_url();

		ORDER_MANAGE_FXML = StaffUIURLConfig.staff_order_manage_fxml_url();
		ORDER_MANAGE_CSS = StaffUIURLConfig.staff_order_manage_css_url();

		ROOM_MANAGE_FXML = StaffUIURLConfig.staff_room_manage_fxml_url();
		ROOM_MANAGE_CSS = StaffUIURLConfig.staff_room_manage_css_url();
		
		try {
			EVALUATION_FXML = new URL("file:src/main/resources/ui/clientui/fxml/evaluation.fxml");
			EVALUATION_CSS = new URL("file:src/main/resources/ui/clientui/css/evaluation.css");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }
	
	/**
	 * 维护酒店信息界面初始化
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
		try {
			String hotelID = UserCache.getHotelID();
			
			// 酒店具体信息获取
			HotelVO info = ControllerFactory.getHotelBLServiceInstance().showHotelInfo(hotelID);
			String[] region = info.region.split("\\s");
			// 所在省份初始化
			for(Province e_p : province.getItems()) {
				if(e_p.getProvinceName().equals(region[0])) {
					province.getSelectionModel().select(e_p);
				}
			}
			// 所在市初始化
			for(City e_c : city.getItems()) {
				if(e_c.getCity_name().equals(region[1])){
					city.getSelectionModel().select(e_c);
				}
			}
			// 所在县初始化
			for(Field e_f : field.getItems()) {
				if(e_f.getField_name().equals(region[2])){
					field.getSelectionModel().select(e_f);
				}
			}
			// 所在商圈初始化
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
			// 警告信息初始化
			name_warning.setText("");
			address_warning.setText("");
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(0));
		}
	}
	
	/**
	 * 查看酒店评价
	 */
	@FXML
	void evaluation(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		try {
			ArrayList<HotelEvaluationVO> evaluationVOs = ControllerFactory.getHotelBLServiceInstance()
					.getHotelEvalutions(UserCache.getHotelID());
			WindowGrab.startWindowWithBundle(window, "酒店评价列表", EVALUATION_FXML, EVALUATION_CSS,
					new EvaluationBundle(evaluationVOs));
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
		}
	}

	@FXML
	void update(ActionEvent event) {
		// 输入信息检测
		boolean name_in = CheckUtil.checkText(hotel_name);
		boolean adress_in = CheckUtil.checkText(hotel_address);
		boolean region_in = CheckUtil.checkSelect(province) && CheckUtil.checkSelect(city) && CheckUtil.checkSelect(field) && CheckUtil.checkSelect(group);
		if (!name_in)
			name_warning.setText("请输入酒店名称");
		if (!adress_in)
			address_warning.setText("请输入地址");
		if (!region_in)
			region_warning.setText("请选择完整地址商圈");
		// 信息无误，显示确认窗口
		if (name_in && adress_in && region_in) {
			Window window = WindowGrab.getWindow(event);
			WindowGrab.startModifyConfirmWindow(window, this);
		}
	}

	
	@FXML
	public void hotelNameModify() {
		CheckUtil.checkWarningBefore(name_warning);
	}
	
	@FXML
	public void hotelAdressModify() {
		CheckUtil.checkWarningBefore(address_warning);
	}
	
	@FXML
	public void regionModify(MouseEvent event) {
		CheckUtil.checkWarningBefore(region_warning);
	}

	@Override
	public void confirm() {
		Window window = WindowGrab.getWindowByStage(0);
		
		// 修改后信息获取
		String newName = hotel_name.getText();
		String newProvince = province.getSelectionModel().getSelectedItem().getProvinceName();
		String newCity = city.getSelectionModel().getSelectedItem().getCity_name();
		String newTown = field.getSelectionModel().getSelectedItem().getField_name();
		String newRegion = newProvince + " " + newCity + " " + newTown;
		String newDistrcit = group.getSelectionModel().getSelectedItem();
		String newAdress = hotel_address.getText();

		HotelVO vo = new HotelVO(hotel_id.getText(), newName, newAdress, newRegion, newDistrcit, 0, 0);
		try {
			// 更新酒店信息
			ResultMessage_Hotel result = ControllerFactory.getHotelBLServiceInstance().changeHotelInfo(vo);
			if(result == ResultMessage_Hotel.Change_Successful)
				WindowGrab.startNoticeWindow(window, "修改成功");
			else 
				WindowGrab.startErrorWindow(window, "修改失败");
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
		}
	}

	//界面跳转
	 @FXML
	 void manageOrder(ActionEvent event) {
		 WindowGrab.changeScene(ORDER_MANAGE_FXML, ORDER_MANAGE_CSS, event);
	 }	

	 @FXML
	 void hotelPromotion(ActionEvent event) {
		 WindowGrab.changeScene(HOTEL_PROMOTION_FXML, HOTEL_PROMOTION_CSS, event);
	 }

	@FXML
	void peopleInfo(ActionEvent event) {
		WindowGrab.changeScene(MENU_FXML, MENU_CSS, event);
	}
	@FXML
    void room(ActionEvent event) {
		WindowGrab.changeScene(ROOM_MANAGE_FXML, ROOM_MANAGE_CSS, event);
    }
	
}
