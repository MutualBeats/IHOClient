package presentation.marketui.mainmarket;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import config.urlconfig.LoginUIURLConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Window;
import presentation.bundle.PromotionBundle;
import presentation.bundle.SingleOrderListBundle;
import presentation.marketui.credit.CreditIDInputHandle;
import presentation.utilui.WindowGrab;
import util.UserCache;
import util.exception.NetException;
import vo.order.OrderVO;
import vo.promotion.PromotionVO;
import vo.user.MarketerVO;

public class MainMarketController implements Initializable{

    @FXML
    private Button web_promotion;

    @FXML
    private Button unexecuted_order;

    @FXML
    private Label marketerName;

    @FXML
    private Button unusual_order;

    @FXML
    private Pane pane;

    @FXML
    private Label title;

    @FXML
    private Button credit;

    @FXML
    private Label marketerID;

    @FXML
    private Label marketerContact;
    
    @FXML
    private Label photo;
    
    @FXML
    private Button all;
    
    @FXML
    private Button logout;
    
    private static URL WEB_PROMOTION_FXML;
    private static URL WEB_PROMOTION_CSS;
    
    private static URL UNUSUAL_ORDER_FXML;
    private static URL UNUSUAL_ORDER_CSS;
    
    private static URL UNEXCUTED_ORDER_FXML;
    private static URL UNEXCUTED_ORDER_CSS;
    
    static{
    	try {
    		WEB_PROMOTION_FXML=new URL("file:src/main/resources/ui/marketui/fxml/web_promotion.fxml");
    		WEB_PROMOTION_CSS=new URL("file:src/main/resources/ui/marketui/css/web_promotion.css");
    		
    		UNUSUAL_ORDER_FXML=new URL("file:src/main/resources/ui/marketui/fxml/unusual_order.fxml");
    		UNUSUAL_ORDER_CSS=new URL("file:src/main/resources/ui/marketui/css/unusual_order.css");
    		
    		UNEXCUTED_ORDER_FXML=new URL("file:src/main/resources/ui/marketui/fxml/unexecuted_order.fxml");
    		UNEXCUTED_ORDER_CSS=new URL("file:src/main/resources/ui/marketui/css/unexecuted_order.css");
    		
    	} catch (MalformedURLException e) {
			e.printStackTrace();
			
		}
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

    @FXML
    void credit(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	WindowGrab.startIDInputWindow(window, new CreditIDInputHandle());
    }

    @FXML
    void unexecuted_order(ActionEvent event) {
    	Scene frame=WindowGrab.getScene(event);
    	ArrayList<OrderVO> order_info=null;
		try {
			order_info = ControllerFactory.getOrderBLServiceInstance().queryUnexecutedOrder(util.Time.getCurrentDate());
		} catch (NetException e) {
			Window window=WindowGrab.getWindow(event);
			WindowGrab.startNetErrorWindow(window);
		}
    	ResourceBundle bundle=new SingleOrderListBundle(order_info);
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			MarketerVO vo=ControllerFactory.getMarketerBLServiceInstance().showData(UserCache.getID());
			marketerName.setText(vo.name);
			marketerID.setText(vo.id);
			marketerContact.setText(vo.contactWay);
		} catch (NetException e) {
			e.printStackTrace();
		}
	}

	@FXML
    void logout(ActionEvent event) {
		WindowGrab.changeScene(LoginUIURLConfig.login_fxml_url(), LoginUIURLConfig.login_css_url(), event);
    }
}


