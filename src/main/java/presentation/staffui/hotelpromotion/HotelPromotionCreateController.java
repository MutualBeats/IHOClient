package presentation.staffui.hotelpromotion;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Window;
import presentation.bundle.EnterpriseUpdateBundle;
import presentation.utilcontroller.Confirm;
import presentation.utilcontroller.PromotionUpdate;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;
import util.UserCache;
import util.exception.NetException;
import util.promotion.PromotionType;
import vo.promotion.EnterprisePromotionVO;
import vo.promotion.PromotionVO;

public class HotelPromotionCreateController implements Initializable, Confirm, UpdateEnterList {

	@FXML
	private Button cancel;

	@FXML
	private ComboBox<String> promotion_type;

	@FXML
	private Label discount_warning;

	@FXML
	private TextField discount_lv2;

	@FXML
	private TextField discount_lv3;

	@FXML
	private TextField discount_lv0;

	@FXML
	private TextField discount_lv1;

	@FXML
	private Button confirm;

	@FXML
	private TextField promotion_name;

	@FXML
	private DatePicker finish_date;

	@FXML
	private Label type_warning;

	@FXML
	private Label enterprise_warning;

	@FXML
	private Text enterprise_label;

	@FXML
	private ListView<String> enterprise_list;

	@FXML
	private Button add_enterprise;

	@FXML
	private DatePicker start_date;

	@FXML
	private Label name_warning;

	private static URL ENTERPRISE_INPUT_FXML;
	private static URL ENTERPRISE_INPUT_CSS;

	static {
		try {
			ENTERPRISE_INPUT_FXML = new URL("file:src/main/resources/ui/staffui/fxml/enterprise_input.fxml");
			ENTERPRISE_INPUT_CSS = new URL("file:src/main/resources/ui/staffui/css/enterprise_input.css");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 酒店促销策略更新接口
	 */
	private PromotionUpdate update;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> promotionTypes = FXCollections.observableArrayList(PromotionType.Birthday.toString(),
				PromotionType.Room.toString(), PromotionType.Holiday.toString(), PromotionType.Enterprise.toString());
		promotion_type.setItems(promotionTypes);
		CheckUtil.inAndOutDatePickerInit(start_date, finish_date, LocalDate.now(), LocalDate.now());
		update = (PromotionUpdate) resources.getObject("update");
	}

	@FXML
	void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

	@FXML
	void confirm(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		if (checkInput())
			WindowGrab.startConfirmWindow(window, this, "是否确认新建促销策略");
	}

	/**
	 * 检查促销策略输入是否合法
	 * @return boolean
	 */
	private boolean checkInput() {
		boolean check = true;
		if (!CheckUtil.checkText(promotion_name)) {
			name_warning.setText("请输入名称");
			check = false;
		}
		if (!CheckUtil.checkSelect(promotion_type)) {
			type_warning.setText("请选择类型");
			check = false;
		}

		try {
			// 检测折扣输入
			if (!(CheckUtil.checkDiscount(discount_lv0.getText()) && CheckUtil.checkDiscount(discount_lv1.getText())
					&& CheckUtil.checkDiscount(discount_lv2.getText())
					&& CheckUtil.checkDiscount(discount_lv3.getText()))) {
				discount_warning.setText("折扣数值错误");
				check = false;
			}
		} catch (NumberFormatException e) {
			discount_warning.setText("折扣格式错误");
		}
		if (promotion_type.getSelectionModel().getSelectedIndex() == 3
				&& enterprise_list.getItems().size() == 0) {
			enterprise_warning.setText("未添加企业");
			check = false;
		}
		return check;
	}

	/**
	 * 添加促销策略确认
	 */
	@Override
	public void confirm() {
		String name = promotion_name.getText();
		PromotionType type = PromotionType.values()[promotion_type.getSelectionModel().getSelectedIndex()];
		String startDate = start_date.getEditor().getText();
		String finishDate = finish_date.getEditor().getText();
		ArrayList<Double> discount = new ArrayList<>();
		discount.add(Double.parseDouble(discount_lv0.getText()));
		discount.add(Double.parseDouble(discount_lv1.getText()));
		discount.add(Double.parseDouble(discount_lv2.getText()));
		discount.add(Double.parseDouble(discount_lv3.getText()));

		PromotionVO promotionVO = null;
		if (type == PromotionType.Enterprise) {
			ArrayList<String> enterpriseList = new ArrayList<>();
			for (String each : enterprise_list.getItems()) {
				enterpriseList.add(each);
			}
			promotionVO = new EnterprisePromotionVO(null, name, type, discount, UserCache.getHotelID(), startDate,
					finishDate, enterpriseList);
		} else
			promotionVO = new PromotionVO(null, name, type, discount, UserCache.getHotelID(), startDate, finishDate);
		try {
			// 促销策略id获取
			String promotionID = ControllerFactory.getPromotionBLServiceInstance().addhotelPromotion(promotionVO);
			promotionVO.setPromotionIDProperty(promotionID);
			// 更新promotion列表
			update.update(promotionVO);
			WindowGrab.closeWindow(WindowGrab.getWindowByStage(1));
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(1));
		}
	}

	/**
	 * 企业名输入
	 */
	@FXML
	void addEnterprise(ActionEvent event) {
		CheckUtil.checkWarningBefore(enterprise_warning);
		
		Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindowWithBundle(window, "企业名输入", ENTERPRISE_INPUT_FXML, ENTERPRISE_INPUT_CSS,
				new EnterpriseUpdateBundle(this));
	}
	
	/**
	 * 企业名称列表添加企业名
	 */
	@Override
	public void update(String enter_name) {
		enterprise_list.getItems().add(enter_name);
	}

	@FXML
	void nameModify(MouseEvent event) {
		CheckUtil.checkWarningBefore(name_warning);
	}

	@FXML
	void discountModify(MouseEvent event) {
		CheckUtil.checkWarningBefore(discount_warning);
	}

	@FXML
	void typeModify(ActionEvent event) {
		CheckUtil.checkWarningBefore(type_warning);
		// 若选择企业类促销策略，显示添加企业标签、列表和按钮
		if (promotion_type.getSelectionModel().getSelectedItem().equals(PromotionType.Enterprise.toString())) {
			enterprise_label.setVisible(true);
			add_enterprise.setVisible(true);
			enterprise_list.setVisible(true);
		} else {
			enterprise_label.setVisible(false);
			add_enterprise.setVisible(false);
			enterprise_list.setVisible(false);
		}
	}

}
