package presentation.marketui.webpromotion;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;
import presentation.utilcontroller.Confirm;
import presentation.utilcontroller.LocationBoxController;
import presentation.utilcontroller.PromotionUpdate;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;
import util.exception.NetException;
import util.promotion.PromotionType;
import vo.promotion.DistrictPromotionVO;

public class MemberDiscountController extends LocationBoxController implements Confirm,Initializable {

	@FXML
    private Button cancel;

    @FXML
    private DatePicker finishTime;

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
    private TextField promotionName;


    @FXML
    private DatePicker startTime;


    @FXML
    private Label name_warning;

    @FXML
    private Label field_warning;
    
    private PromotionUpdate update;
    
    @FXML
    void confirm(ActionEvent event) {
    	Window window=WindowGrab.getWindow(event);
    	if(checkInput())
    		WindowGrab.startConfirmWindow(window, this, "是否确认新建促销策略");
    }
    //检测输入
    private boolean checkInput() {
    	boolean check = true;
		if (!CheckUtil.checkText(promotionName)) {
			name_warning.setText("请输入名称");
			check = false;
		}
		if (!(CheckUtil.checkSelect(city)&&CheckUtil.checkSelect(field)
				&&CheckUtil.checkSelect(group)&&CheckUtil.checkSelect(province))) {
			field_warning.setText("请选择商圈");
			check = false;
		}
		
		try {
			if(!(CheckUtil.checkText(discount_lv0)&&CheckUtil.checkText(discount_lv1)
					&&CheckUtil.checkText(discount_lv2)&&CheckUtil.checkText(discount_lv1))){
				discount_warning.setText("请输入折扣信息");
				check = false;
			}
			else if (!(CheckUtil.checkDiscount(discount_lv0.getText())&&CheckUtil.checkDiscount(discount_lv1.getText())
					&&CheckUtil.checkDiscount(discount_lv2.getText())&&CheckUtil.checkDiscount(discount_lv3.getText()))) {
				discount_warning.setText("折扣数值错误");
				check = false;
			}
    	} catch (NumberFormatException e) {
			check = false;
    		discount_warning.setText("折扣格式错误");
		}
    	
    	return check;
    }
    
    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

	@Override
	public void confirm() {
		// TODO Auto-generated method stub
		Window window=WindowGrab.getWindowByStage(1);
		WindowGrab.closeWindow(window);
		String name=promotionName.getText();
		String start=startTime.getEditor().getText();
		String finish=finishTime.getEditor().getText();
		ArrayList<Double> discount = new ArrayList<>();
		discount.add(Double.parseDouble(discount_lv0.getText()));
		discount.add(Double.parseDouble(discount_lv1.getText()));
		discount.add(Double.parseDouble(discount_lv2.getText()));
		discount.add(Double.parseDouble(discount_lv3.getText()));
		
		ArrayList<String> districtList=new ArrayList<>();
		districtList.add(group.getEditor().getText());
		
		DistrictPromotionVO promotionVO = new DistrictPromotionVO("", name, PromotionType.BusinessDistrict, discount , "", start, finish, districtList);
		try {
			String promotionID=ControllerFactory.getPromotionBLServiceInstance().addWebPromotion(promotionVO);
			promotionVO.promotionID=promotionID;
			promotionVO.setPromotionIDProperty(promotionID);
			update.update(promotionVO);
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
		}
		
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
    void  disModify(MouseEvent event) {
    	CheckUtil.checkWarningBefore(field_warning);
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 初始化商圈和Time
		super.initialize(location, resources);
		CheckUtil.inAndOutDatePickerInit(startTime, finishTime, LocalDate.now(), LocalDate.now());
		update=(PromotionUpdate)resources.getObject("update");
	}
	

	

}

