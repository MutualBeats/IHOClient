package presentation.marketui.webpromotion;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogicservice.promotionblservice.PromotionBLService;
import config.DiscountConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;
import util.exception.NetException;
import util.promotion.PromotionType;
import vo.promotion.PromotionVO;

public class TimeDiscountController implements Initializable {

	@FXML
	private Button confirm;

	@FXML
	private Button cancel;

	@FXML
	private DatePicker start_time;

	@FXML
	private Label discount_warning;

	@FXML
	private Label etime_warning;

	@FXML
	private TextField name;

	@FXML
	private DatePicker end_time;

	@FXML
	private ComboBox<Integer> discount;

	@FXML
	private Label name_warning;

	@FXML
	private Label stime_warning;

	private PromotionUpdate update;

	@FXML
	void confirm(ActionEvent event) {
		if (checkFormatter()) {
			Window owner = WindowGrab.getWindow(event);
			String p_name = name.getText();
			String startDate = start_time.getEditor().getText();
			String finishDate = end_time.getEditor().getText();
			double dis = discount.getSelectionModel().getSelectedItem();
			PromotionVO vo = new PromotionVO("", p_name, PromotionType.Holiday, null, "", startDate, finishDate);
			
			try {
				// 初始化所有等级会员的折扣
				PromotionBLService bl = ControllerFactory.getPromotionBLServiceInstance();
				int number_of_level = bl.getMemberLevel().size();
				ArrayList<Double> dis_list = new ArrayList<>();
				for (int i = 0; i < number_of_level; i++) {
					dis_list.add(dis);
				}
				vo.discount = dis_list;
				//父窗口更新
				String promotionID = bl.addhotelPromotion(vo);
				if (promotionID != null) {
					update.update(promotionID);
				}
				WindowGrab.startNoticeWindow(owner, "添加成功");
				WindowGrab.closeWindow(owner);
			} catch (NetException e) {
				WindowGrab.startNetErrorWindow(owner);
			}
		}
	}

	@FXML
	void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

	private boolean checkFormatter() {
		return checkName() && checkDiscount();
	}

	private boolean checkName() {
		boolean check = CheckUtil.checkText(name);
		if (!check) {
			name_warning.setText("请输入策略名称");
		}
		return check;
	}

	private boolean checkDiscount() {
		boolean select = CheckUtil.checkSelect(discount);
		if (!select) {
			discount_warning.setText("请选择折扣");
		}
		return select;
	}

	@FXML
	void nameModify(ActionEvent event) {
		CheckUtil.checkWarningBefore(name_warning);
	}

	@FXML
	void stimeModify(ActionEvent event) {
		CheckUtil.checkWarningBefore(stime_warning);
	}

	@FXML
	void etimeModify(ActionEvent event) {
		CheckUtil.checkWarningBefore(etime_warning);
	}

	@FXML
	void discountModify(ActionEvent event) {
		CheckUtil.checkWarningBefore(discount_warning);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		discount.getItems().addAll(DiscountConfig.DISCOUNT);
		CheckUtil.init(start_time, end_time, LocalDate.now(), LocalDate.now());

	}

}
