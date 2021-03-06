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
import presentation.utilcontroller.PromotionUpdate;
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
	private TextField name;

	@FXML
	private DatePicker end_time;
	
	@FXML
    private TextField discount_lv2;

    @FXML
    private TextField discount_lv3;

    @FXML
    private TextField discount_lv0;

    @FXML
    private TextField discount_lv1;

	@FXML
	private Label name_warning;


	private PromotionUpdate update;
	
	@FXML
	void confirm(ActionEvent event) {
		if (checkInput()) {
			Window owner = WindowGrab.getWindow(event);
			WindowGrab.closeWindow(owner);
			String p_name = name.getText();
			String startDate = start_time.getEditor().getText();
			String finishDate = end_time.getEditor().getText();
		
			PromotionVO vo = null;

			try {
				// 初始化所有等级会员的折扣
				ArrayList<Double> dis_list = new ArrayList<>();
				dis_list.add(Double.valueOf(discount_lv0.getText()));
				dis_list.add(Double.valueOf(discount_lv1.getText()));
				dis_list.add(Double.valueOf(discount_lv2.getText()));
				dis_list.add(Double.valueOf(discount_lv3.getText()));
				
				vo = new PromotionVO("", p_name, PromotionType.Holiday, dis_list, "", startDate, finishDate);
					
				//父窗口更新
				String promotionID = ControllerFactory.getPromotionBLServiceInstance().addWebPromotion(vo);
				vo.setPromotionIDProperty(promotionID);
				update.update(vo);
				WindowGrab.startNoticeWindow(owner, "添加成功");
			} catch (NetException e) {
				WindowGrab.startNetErrorWindow(owner);
			}
		}
	}

	@FXML
	void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

	private boolean checkInput() {
		boolean select=true;
		if(!CheckUtil.checkText(name)){
			name_warning.setText("请输入策略名称");
			select=false;
		}
		if(!(CheckUtil.checkDiscount(discount_lv0.getText())&&CheckUtil.checkDiscount(discount_lv1.getText())
				&&CheckUtil.checkDiscount(discount_lv2.getText())&&CheckUtil.checkDiscount(discount_lv3.getText()))){
			discount_warning.setText("请输入折扣");
			select=false;
		}
		
		return select;
	}


	@FXML
	void nameModify(MouseEvent event) {
		CheckUtil.checkWarningBefore(name_warning);
	}


	@FXML
	void discountModify(MouseEvent event) {
		CheckUtil.checkWarningBefore(discount_warning);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		CheckUtil.inAndOutDatePickerInit(start_time, end_time, LocalDate.now(), LocalDate.now());
		update=(PromotionUpdate)resources.getObject("update");
	}
	
	
}
