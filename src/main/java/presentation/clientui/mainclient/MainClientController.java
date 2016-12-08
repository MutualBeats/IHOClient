package presentation.clientui.mainclient;


import java.net.MalformedURLException;
import java.net.URL;

import com.sun.glass.events.WindowEvent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainClientController {
	@FXML
    private Button browse_order;

	@FXML
    private Button logout;
	
    @FXML
    private Label user_id;


    @FXML
    private Button create_order;

    @FXML
    private Button revoke_order;

    @FXML
    private Button member;

    @FXML
    private Button maintain_message;

    @FXML
    private Button evaluate_hotel;

    @FXML
    private Label menu_user;

    @FXML
    private Label title;

    @FXML
    private Label menu_label;

    @FXML
    private Label user_name;
    //浏览订单
    private static URL BROWSE_ORDER_FXML;
    private static URL BROWSE_ORDER_CSS;
    
    //生成订单
    private static URL CREATE_ORDER_FXML;
    private static URL CREATE_ORDER_CSS;
    
    //撤销订单
    private static URL REVOKE_ORDER_FXML;
    private static URL REVOKE_ORDER_CSS;
    
    //注册会员
    private static URL MEMBER_FXML;
    private static URL MEMBER_CSS;
    
    //评价酒店
    private static URL EVALUATE_HOTEL_FXML;
    private static URL EVALUATE_HOTEL_CSS;
   
    //维护个人信息
    private static URL MAINTAIN_MESSAGE_FXML;
    private static URL MAINTAIN_MESSAGE_CSS;
    private static URL LOGIN_FXML;
    private static URL LOGIN_CSS;
    
    
    static{
    	try {
    		BROWSE_ORDER_FXML=new URL("file:src/main/resources/ui/clientui/fxml/browse_order.fxml");
			BROWSE_ORDER_CSS=new URL("file:src/main/resources/ui/clientui/css/browse_order.css");
		
			CREATE_ORDER_FXML=new URL("file:src/main/resources/ui/clientui/fxml/create_order.fxml");
			CREATE_ORDER_CSS=new URL("file:src/main/resources/ui/clientui/css/create_order.css");
		
			REVOKE_ORDER_FXML=new URL("file:src/main/resources/ui/clientui/fxml/revoke_order.fxml");
			REVOKE_ORDER_CSS=new URL("file:src/main/resources/ui/clientui/css/revoke_order.css");
			
			MEMBER_FXML=new URL("file:src/main/resources/ui/clientui/fxml/member.fxml");
			MEMBER_CSS=new URL("file:src/main/resources/ui/clientui/css/member.css");
		
			EVALUATE_HOTEL_FXML=new URL("file:src/main/resources/ui/clientui/fxml/evaluate_hotel.fxml");
			EVALUATE_HOTEL_CSS=new URL("file:src/main/resources/ui/clientui/css/evaluate_hotel.css");
		
			MAINTAIN_MESSAGE_FXML=new URL("file:src/main/resources/ui/clientui/fxml/maintain_message.fxml");
			MAINTAIN_MESSAGE_CSS=new URL("file:src/main/resources/ui/clientui/css/maintain_message.css");
		
			LOGIN_FXML=new URL("file:src/main/resources/ui/loginui/fxml/login.fxml");
			LOGIN_CSS=new URL("file:src/main/resources/ui/loginui/css/login.css");
			
    	} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
    @FXML
    void create_order(ActionEvent event) {
    	Window window=WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "生成订单", CREATE_ORDER_FXML, CREATE_ORDER_CSS);
    	
    }

    @FXML
    void browse_order(ActionEvent event) {
    	Window window =WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "浏览订单", BROWSE_ORDER_FXML, BROWSE_ORDER_CSS);
    }

    @FXML
    void revoke_order(ActionEvent event) {
    	Window window=WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "撤销订单", REVOKE_ORDER_FXML, REVOKE_ORDER_CSS);
    }

    @FXML
    void member(ActionEvent event) {
    	Window window=WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "注册会员", MEMBER_FXML, MEMBER_CSS);
    }

    @FXML
    void maintain_message(ActionEvent event) {
    	Window window=WindowGrab .getWindow(event);
    	WindowGrab.startWindow(window, "维护个人信息", MAINTAIN_MESSAGE_FXML, MAINTAIN_MESSAGE_CSS);
    }

    @FXML
    void evaluate_hotel(ActionEvent event) {
     	Window window=WindowGrab .getWindow(event);
    	WindowGrab.startWindow(window, "评价酒店", EVALUATE_HOTEL_FXML, EVALUATE_HOTEL_CSS);
    }
    
    @FXML
    void logout(ActionEvent event) {
    	Window window=WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "登录", LOGIN_FXML, LOGIN_CSS);
    }
    
    @FXML
    void on_search(ActionEvent event) {

    }
}

