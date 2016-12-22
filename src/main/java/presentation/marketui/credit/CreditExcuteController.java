package presentation.marketui.credit;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Window;
import presentation.bundle.PromotionBundle;
import presentation.bundle.SingleOrderListBundle;
import presentation.utilcontroller.Confirm;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;
import util.Time;
import util.credit.CreditChangeAction;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Credit;
import vo.credit.CreditVO;
import vo.order.OrderVO;
import vo.promotion.PromotionVO;
import vo.user.ClientVO;

public class CreditExcuteController implements Initializable, Confirm {
	@FXML
	private Button confirm;

	@FXML
	private Button cancel;

	@FXML
	private TextField credit_to_add;

	@FXML
	private Label user_name;

	@FXML
	private Label credit_warning;

	@FXML
	private Label name;

	@FXML
	private Label creditnow;

	private ClientVO info;


	@FXML
    private Pane pane;
	
	private static URL WEB_PROMOTION_FXML;
    private static URL WEB_PROMOTION_CSS;
    
    private static URL UNUSUAL_ORDER_FXML;
    private static URL UNUSUAL_ORDER_CSS;
    
    
    private static URL MENU_FXML;
    private static URL MENU_CSS;
	
    private static URL UNEXCUTED_ORDER_FXML;
	private static URL UNEXCUTED_ORDER_CSS;

    static{
    	try {
    		WEB_PROMOTION_FXML=new URL("file:src/main/resources/ui/marketui/fxml/web_promotion.fxml");
    		WEB_PROMOTION_CSS=new URL("file:src/main/resources/ui/marketui/css/web_promotion.css");
    		
    		UNUSUAL_ORDER_FXML=new URL("file:src/main/resources/ui/marketui/fxml/unusual_order.fxml");
    		UNUSUAL_ORDER_CSS=new URL("file:src/main/resources/ui/marketui/css/unusual_order.css");
    		
    		MENU_FXML=new URL("file:src/main/resources/ui/marketui/fxml/marketmenu.fxml");
    		MENU_CSS=new URL("file:src/main/resources/ui/marketui/css/marketmenu.css");
    		
    		UNEXCUTED_ORDER_FXML = new URL("file:src/main/resources/ui/marketui/fxml/unexecuted_order.fxml");
			UNEXCUTED_ORDER_CSS = new URL("file:src/main/resources/ui/marketui/css/unexecuted_order.css");

    	} catch (MalformedURLException e) {
			e.printStackTrace();
			
		}
    }
	
	@FXML
	void confirm(ActionEvent event) {
		if (checkCreditInput()) {

			Window window = WindowGrab.getWindow(event);
			WindowGrab.startConfirmWindow(window, this, "是否确认充值");
		}
	}

	@FXML
	public void onValueModify(MouseEvent mouseEvent) {
		CheckUtil.checkWarningBefore(credit_warning);
	}

	private boolean checkCreditInput() {
		boolean check = CheckUtil.checkText(credit_to_add);
		if (!check) {
			credit_warning.setText("请输入充值额度");
			return false;
		}
		try {
			// int credit_add =
			Integer.parseInt(credit_to_add.getText());
			// if (100 * (credit_add / 100) == credit_add) {
			// credit_warning.setText("输入额度应为100的倍数");
			// return false;
			// } else if (credit_add <= 0) {
			// credit_warning.setText("请输入正整数");
			// return false;
			// }
		} catch (Exception e) {
			credit_warning.setText("请输入整数额度");
			return false;
		}
		return true;
	}

	

	@FXML
	public void passwordAgainModify(MouseEvent event) {
		boolean warn_before = CheckUtil.checkWarningBefore(credit_warning);
		if (warn_before) {
			credit_warning.setText("");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		info = (ClientVO) resources.getObject("info");
		if (info != null) {
			user_name.setText(info.id);
			name.setText(info.name);
			creditnow.setText(info.credit + "");
		}
	}

	@Override
	public void confirm() {
		Window window = WindowGrab.getWindowByStage(0);
		int credit_add = Integer.parseInt(credit_to_add.getText()) * 100;
		CreditVO updateVO = new CreditVO(info.id, Time.getCurrentTime(), credit_add, info.credit,
				CreditChangeAction.Deposit, "");
		ResultMessage_Credit result = ResultMessage_Credit.Update_Successful;
		try {
			result = ControllerFactory.getCreditBLServiceInstance().creditUpdate(updateVO);
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
			return;
		}
		if (result == ResultMessage_Credit.Update_Successful) {
			WindowGrab.startNoticeWindow(window, "信用充值成功");
			// 本地刷新一下记录
			info.credit += credit_add;
			creditnow.setText(info.credit + "");
			credit_to_add.setText("");
			credit_warning.setText("");
		} else if (result == ResultMessage_Credit.Credit_Net_Error) {
			WindowGrab.startNetErrorWindow(window);
		} else {
			WindowGrab.startErrorWindow(window, "信用充值失败");
		}
	}

	@FXML
    void peopleInfo(ActionEvent event) {
		WindowGrab.changeScene(MENU_FXML, MENU_CSS, event);
    }

    @FXML
    void unexecuted_order(ActionEvent event) {
    	Scene frame = WindowGrab.getScene(event);
		ArrayList<OrderVO> order_info = null;
		try {
			order_info = ControllerFactory.getOrderBLServiceInstance().queryUnexecutedOrder(util.Time.getCurrentDate());
		} catch (NetException e) {
			Window window = WindowGrab.getWindow(event);
			WindowGrab.startNetErrorWindow(window);
		}
		ResourceBundle bundle = new SingleOrderListBundle(order_info);
		WindowGrab.changeSceneWithBundle(UNEXCUTED_ORDER_FXML, UNEXCUTED_ORDER_CSS, frame, bundle);

	
    }

    @FXML
    void unusual_order(ActionEvent event) {
    	Scene frame=WindowGrab.getScene(event);
    	ArrayList<OrderVO> order_info=null;
		try {
			order_info = ControllerFactory.getOrderBLServiceInstance().queryAbnormalOrder();
		} catch (NetException e) {
			Window window=WindowGrab.getWindow(event);
			WindowGrab.startNetErrorWindow(window);
		}
    	ResourceBundle bundle=new SingleOrderListBundle(order_info);
    	WindowGrab.changeSceneWithBundle(UNUSUAL_ORDER_FXML, UNUSUAL_ORDER_CSS, frame, bundle);
    
   
    }

    @FXML
    void web_promotion(ActionEvent event) {
    	Scene frame=WindowGrab.getScene(event);
    	ArrayList<PromotionVO> promotionList=null;
    	try {
			promotionList=ControllerFactory.getPromotionBLServiceInstance().getWebPromotion();
		} catch (NetException e) {
			Window window=WindowGrab.getWindow(event);
			WindowGrab.startNetErrorWindow(window);
		}
    	ResourceBundle bundle=new PromotionBundle(promotionList);
    	WindowGrab.changeSceneWithBundle(WEB_PROMOTION_FXML, WEB_PROMOTION_CSS, frame, bundle);
    	
   
    }
}
