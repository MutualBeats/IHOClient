package presentation.marketui.webpromotion;


import java.util.ArrayList;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import presentation.utilcontroller.Confirm;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Promotion;

public class MemberLevelController implements Confirm{

    @FXML
    private Button confirm;

    @FXML
    private Button cancel;

    @FXML
    private TextField credit_lv2;

    @FXML
    private TextField credit_lv0;

    @FXML
    private TextField credit_lv1;

    @FXML
    private AnchorPane l;

    @FXML
    private TextField discount_lv2;

    @FXML
    private TextField discount_lv3;

    @FXML
    private TextField discount_lv0;

    @FXML
    private TextField discount_lv1;

    @FXML
    private Label discount_warning;
    
    @FXML
    private Label credit_warning;
    
    @FXML
    void confirm(ActionEvent event) {
    	Window window=WindowGrab.getWindow(event);
    	if(CheckedIn()){
    		WindowGrab.startConfirmWindow(window, this, "是否确认该操作？");
    		}
    }

    private boolean CheckedIn() {
		//判断输入
    	boolean check=true;
    	if(discount_lv0.getText().isEmpty()){
    		discount_warning.setText("请输入折扣信息");
    		 check=false;
    	}
    	if(discount_lv1.getText().isEmpty()){
    		discount_warning.setText("请输入折扣信息");
    		 check=false;
    	}
    	if(discount_lv2.getText().isEmpty()){
    		discount_warning.setText("请输入折扣信息");
    		 check=false;
    	}
    	if(discount_lv3.getText().isEmpty()){
    		discount_warning.setText("请输入折扣信息");
    		 check=false;
    	}
    	
    	if(credit_lv0.getText().isEmpty()){
    		credit_warning.setText("请输入信用值");
    		 check=false;
    	}
    	
    	if(credit_lv1.getText().isEmpty()){
    		credit_warning.setText("请输入信用值");
    		 check=false;
    	}
    	
    	if(credit_lv2.getText().isEmpty()){
    		credit_warning.setText("请输入信用值");
    		 check=false;
    	}
    	
    	
    	return check;
	}

	@FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void creditModify(ActionEvent event) {
    	CheckUtil.checkWarningBefore(credit_warning);
    }


    @FXML
    void discountModify(ActionEvent event) {
    	CheckUtil.checkWarningBefore(discount_warning);
    }

	@Override
	public void confirm() {
		//会员等级及对应折扣获取
		WindowGrab.closeWindow(WindowGrab.getWindowByStage(2));
		ArrayList<Integer> credit=new ArrayList<>();
		credit.add(Integer.valueOf(credit_lv0.getText()));
		credit.add(Integer.valueOf(credit_lv1.getText()));
		credit.add(Integer.valueOf(credit_lv2.getText()));
		
		ArrayList<Double> discount=new ArrayList<>();
		discount.add(Double.parseDouble(discount_lv0.getText()));
		discount.add(Double.parseDouble(discount_lv1.getText()));
		discount.add(Double.parseDouble(discount_lv2.getText()));
		discount.add(Double.parseDouble(discount_lv3.getText()));
		
		try {
			ResultMessage_Promotion levelInfo=ControllerFactory.getPromotionBLServiceInstance().makeLevel(credit, discount);
		} catch (NetException e) {
			// TODO Auto-generated catch block
			Window window=WindowGrab.getWindowByStage(0);
			WindowGrab.startNetErrorWindow(window);;
		}
	}


}

