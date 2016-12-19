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
	
	private PromotionUpdate update;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> promotionTypes = FXCollections.observableArrayList(PromotionType.Birthday.toString(),
				PromotionType.Room.toString(), PromotionType.Holiday.toString(), PromotionType.Enterprise.toString());
		promotion_type.setItems(promotionTypes);
		CheckUtil.init(start_date, finish_date, LocalDate.now(), LocalDate.now());
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

	@Override
	public void confirm() {
		String name = promotion_name.getText();
		PromotionType type = PromotionType.valueOf(promotion_type.getSelectionModel().getSelectedItem());
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
			String promotionID = ControllerFactory.getPromotionBLServiceInstance().addhotelPromotion(promotionVO);
//			promotionVO.promotionID = promotionID;
			promotionVO.setPromotionIDProperty(promotionID);
			// 更新promotion列表
			update.update(promotionVO);
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(0));
		}
	}

	@FXML
	void addEnterprise(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);

		WindowGrab.startWindowWithBundle(window, "企业名输入", ENTERPRISE_INPUT_FXML, ENTERPRISE_INPUT_CSS,
				new EnterpriseUpdateBundle(this));
	}

	@FXML
	void nameModify(ActionEvent event) {
		CheckUtil.checkWarningBefore(name_warning);
	}

	@FXML
	void discountModify(ActionEvent event) {
		CheckUtil.checkWarningBefore(discount_warning);
	}

	@FXML
	void typeModify(ActionEvent event) {
		CheckUtil.checkWarningBefore(type_warning);
		if (promotion_type.getSelectionModel().getSelectedItem().equals("Enterprise")) {
			enterprise_label.setVisible(true);
			add_enterprise.setVisible(true);
			enterprise_list.setVisible(true);
		} else {
			enterprise_label.setVisible(false);
			add_enterprise.setVisible(false);
			enterprise_list.setVisible(false);
		}
	}

	@Override
	public void update(String enter_name) {
		enterprise_list.getItems().add(enter_name);
	}

}
