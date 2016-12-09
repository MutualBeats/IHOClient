package presentation.marketui.mainmarket;


import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Window;
import presentation.marketui.credit.CreditIDInputHandle;
import presentation.utilui.WindowGrab;

public class MainMarketController {

    @FXML
    private Button web_promotion;

    @FXML
    private Button unexcuted_order;

    @FXML
    private Label staffName;

    @FXML
    private Button unusual_order;

    @FXML
    private Pane pane;

    @FXML
    private Label title;

    @FXML
    private Button credit;

    @FXML
    private Label staffID;

    private static URL CREDIT_FXML;
    private static URL CREDIT_CSS;
    
    private static URL WEB_PROMOTION_FXML;
    private static URL WEB_PROMOTION_CSS;
    
    private static URL UNUSUAL_ORDER_FXML;
    private static URL UNUSUAL_ORDER_CSS;
    
    private static URL UNEXCUTED_ORDER_FXML;
    private static URL UNEXCUTED_ORDER_CSS;
    
    static{
    	try {
    		CREDIT_FXML=new URL("file:src/main/resources/ui/marketui/fxml/credit.fxml");
    		CREDIT_CSS=new URL("file:src/main/resources/ui/marketui/css/credit.css");
    		
    		WEB_PROMOTION_FXML=new URL("file:src/main/resources/ui/marketui/fxml/web_promotion.fxml");
    		WEB_PROMOTION_CSS=new URL("file:src/main/resources/ui/marketui/css/web_promotion.css");
    		
    		UNUSUAL_ORDER_FXML=new URL("file:src/main/resources/ui/marketui/fxml/unusual_order.fxml");
    		UNUSUAL_ORDER_CSS=new URL("file:src/main/resources/ui/marketui/css/unusual_order.css");
    		
    		UNEXCUTED_ORDER_FXML=new URL("file:src/main/resources/ui/marketui/fxml/unexcuted_order.fxml");
    		UNEXCUTED_ORDER_CSS=new URL("file:src/main/resources/ui/marketui/css/unexcuted_order.css");
    		
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void web_promotion(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "制定网站促销策略", WEB_PROMOTION_FXML,WEB_PROMOTION_CSS);   
    }

    @FXML
    void credit(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	WindowGrab.startIDInputWindow(window, new CreditIDInputHandle());
    }

    @FXML
    void unexcuted_order(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "查看未执行订单", UNEXCUTED_ORDER_FXML,UNEXCUTED_ORDER_CSS);
    }

    @FXML
    void unusual_order(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "撤销异常订单", UNUSUAL_ORDER_FXML,UNUSUAL_ORDER_CSS);
    }

}

