package presentation.staffui.hotelpromotion;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Window;
import presentation.utilcontroller.Confirm;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;
import util.UserCache;
import util.exception.NetException;
import util.promotion.PromotionType;
import vo.promotion.PromotionVO;

public class HotelPromotionCreateController implements Initializable, Confirm {

    @FXML
    private Button cancel;

    @FXML
    private ComboBox<String> promotion_type;

    @FXML
    private Label discount_warning;

    @FXML
    private TableView<String> enterprise_list;

    @FXML
    private Label start_date_warning;

    @FXML
    private Label finish_date_warning;

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
    private DatePicker start_date;

    @FXML
    private Label name_warning;

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> promotionTypes = FXCollections.observableArrayList(PromotionType.Birthday.toString(), PromotionType.Room.toString(), PromotionType.Holiday.toString(), PromotionType.Enterprise.toString());
		promotion_type.setItems(promotionTypes);
	}

    @FXML
    void confirm(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	if(checkInput())
    		WindowGrab.startConfirmWindow(window, this, "是否确认新建促销策略");
    }
    
    private boolean checkInput() {
    	boolean check = true;
		if (promotion_name.getText() == "") {
			name_warning.setText("请输入名称");
			check = false;
		}
		if (promotion_type.getSelectionModel().getSelectedIndex() == -1) {
			type_warning.setText("请选择类型");
			check = false;
		}
		if (start_date.getEditor().getText().compareTo(util.Time.getCurrentDate()) > 0) {
			start_date_warning.setText("开始日期不可在今天前");
			check = false;
		}
		if (start_date.getEditor().getText().compareTo(finish_date.getEditor().getText()) > 0) {
			finish_date_warning.setText("结束日期不可在开始日期前");
			check = false;
		}
		try {
			if (Double.parseDouble(discount_lv0.getText()) <= 0 || Double.parseDouble(discount_lv0.getText()) > 10) {
				discount_warning.setText("折扣数值错误");
				check = false;
			}
			if (Double.parseDouble(discount_lv1.getText()) <= 0 || Double.parseDouble(discount_lv1.getText()) > 10) {
				discount_warning.setText("折扣数值错误");
				check = false;
			}
			if (Double.parseDouble(discount_lv2.getText()) <= 0 || Double.parseDouble(discount_lv2.getText()) > 10) {
				discount_warning.setText("折扣数值错误");
				check = false;
			}
			if (Double.parseDouble(discount_lv3.getText()) <= 0 || Double.parseDouble(discount_lv3.getText()) > 10) {
				discount_warning.setText("折扣数值错误");
				check = false;
			}
    	} catch (NumberFormatException e) {
    		discount_warning.setText("折扣格式错误");
		}
    	// TODO 检测企业
    	
    	return check;
    }

	@Override
	public void confirm() {
		// TODO 企业获取
		String name = promotion_name.getText();
		PromotionType type = PromotionType.valueOf(promotion_type.getSelectionModel().getSelectedItem());
		String startDate = start_date.getEditor().getText();
		String finishDate = finish_date.getEditor().getText();
		ArrayList<Double> discount = new ArrayList<>();
		discount.add(Double.parseDouble(discount_lv0.getText()));
		discount.add(Double.parseDouble(discount_lv1.getText()));
		discount.add(Double.parseDouble(discount_lv2.getText()));
		discount.add(Double.parseDouble(discount_lv3.getText()));
		PromotionVO promotionVO = new PromotionVO(null, name, type, discount, UserCache.getHotelID(), startDate, finishDate);
		try {
			String promotionID = ControllerFactory.getPromotionBLServiceInstance().addhotelPromotion(promotionVO);
			promotionVO.promotionID = promotionID;
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(0));
		}
		// TODO 更新promotion列表
		
	}
	
	@FXML
    void nameModify(ActionEvent event) {
		CheckUtil.checkWarningBefore(name_warning);
    }
	
	@FXML
    void startDateModify(ActionEvent event) {
		CheckUtil.checkWarningBefore(start_date_warning);
    }

    @FXML
    void finishDateModify(ActionEvent event) {
    	CheckUtil.checkWarningBefore(finish_date_warning);
    }

    @FXML
    void discountModify(ActionEvent event) {
    	CheckUtil.checkWarningBefore(discount_warning);
    }

    @FXML
    void typeModify(ActionEvent event) {
    	CheckUtil.checkWarningBefore(type_warning);
    }

}
