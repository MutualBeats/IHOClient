package presentation.marketui.webpromotion;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

public class MemberLevelController implements Confirm,Initializable{

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
    
    ArrayList<Integer> credit_list;
    ArrayList<Double> discount_list;
    
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
		credit_list.set(0, Integer.valueOf(credit_lv0.getText()));
		credit_list.set(1, Integer.valueOf(credit_lv1.getText()));
		credit_list.set(2, Integer.valueOf(credit_lv1.getText()));
		
		discount_list.set(0, Double.valueOf(discount_lv0.getText()));
		discount_list.set(1, Double.valueOf(discount_lv1.getText()));
		discount_list.set(2, Double.valueOf(discount_lv2.getText()));
		discount_list.set(3, Double.valueOf(discount_lv3.getText()));
		
		Window window=WindowGrab.getWindowByStage(0);
		
		try {
			ResultMessage_Promotion levelInfo=ControllerFactory.getPromotionBLServiceInstance().makeLevel(credit_list, discount_list);
			if(ResultMessage_Promotion.Level_Make_Successful==levelInfo){
				WindowGrab.startNoticeWindow(window, "会员等级制定成功");
			}
			else {
				WindowGrab.startErrorWindow(window, "会员等级制定失败");
			}
		} catch (NetException e) {
			// TODO Auto-generated catch block
			WindowGrab.startNetErrorWindow(window);;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 初始化得到已有的等级和折扣信息
		credit_list = (ArrayList<Integer>)resources.getObject("credit_list");
		discount_list = (ArrayList<Double>)resources.getObject("discount_list");
		
		discount_lv0.setText(discount_list.get(0).toString());
		discount_lv1.setText(discount_list.get(1).toString());
		discount_lv2.setText(discount_list.get(2).toString());
		discount_lv3.setText(discount_list.get(3).toString());
		
		credit_lv0.setText(credit_list.get(0).toString());
		credit_lv1.setText(credit_list.get(1).toString());
		credit_lv2.setText(credit_list.get(2).toString());
		
	}


}

